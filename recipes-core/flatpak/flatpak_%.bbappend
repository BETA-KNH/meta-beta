FILESEXTRAPATHS:prepend := "${THISDIR}/files:"

SRC_URI += "file://flatpak.conf"

do_install:append() {
    # Ensure flatpak state persists across RAUC A/B rootfs updates.
    # Keep default path (/var/lib/flatpak) but redirect it to /data/flatpak.
    install -d ${D}${localstatedir}/lib
    
    # Remove existing directory if the original recipe created it
    if [ -d "${D}${localstatedir}/lib/flatpak" ] && [ ! -L "${D}${localstatedir}/lib/flatpak" ]; then
        rm -rf "${D}${localstatedir}/lib/flatpak"
    fi
    
    ln -snf /data/flatpak ${D}${localstatedir}/lib/flatpak

    # Create persistent state directory at boot.
    install -d ${D}${nonarch_libdir}/tmpfiles.d
    install -m 0644 ${WORKDIR}/flatpak.conf ${D}${nonarch_libdir}/tmpfiles.d/flatpak.conf
}

FILES:${PN} += " \
    ${localstatedir}/lib/flatpak \
    ${nonarch_libdir}/tmpfiles.d/flatpak.conf \
"

USERADD_PARAM:${PN}:append = " ; --system --no-create-home --user-group --home-dir ${localstatedir}/lib/flatpak -c 'Flatpak system helper' flatpak"
