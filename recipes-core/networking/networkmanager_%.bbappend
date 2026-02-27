FILESEXTRAPATHS:prepend := "${THISDIR}/files:"

SRC_URI += "file://my-wifi-dhcp.nmconnection \
           file://pixel-4627.nmconnection \
           file://androidapkhg.nmconnection"

hostname:pn-base-files = "beta-robot"

# Enable nmtui text interface and systemd integration
PACKAGECONFIG:append = " nmcli nmtui systemd"

do_install:append() {
    # Install globally managed devices config
    install -d ${D}${sysconfdir}/NetworkManager/conf.d
    cat > ${D}${sysconfdir}/NetworkManager/conf.d/10-globally-managed-devices.conf <<EOF
[keyfile]
unmanaged-devices=none
EOF

    # Install WiFi connection profile
    install -d ${D}${sysconfdir}/NetworkManager/system-connections
    install -m 0600 ${WORKDIR}/my-wifi-dhcp.nmconnection ${D}${sysconfdir}/NetworkManager/system-connections/my-wifi-dhcp.nmconnection
    install -m 0600 ${WORKDIR}/pixel-4627.nmconnection ${D}${sysconfdir}/NetworkManager/system-connections/pixel-4627.nmconnection
    install -m 0600 ${WORKDIR}/androidapkhg.nmconnection ${D}${sysconfdir}/NetworkManager/system-connections/androidapkhg.nmconnection

    # Additional NetworkManager configuration for WiFi stability
    cat > ${D}${sysconfdir}/NetworkManager/conf.d/20-wifi.conf <<EOF
[device]
wifi.scan-rand-mac-address=no

[connection]
wifi.powersave=2
EOF
}

FILES:${PN} += " \
    ${sysconfdir}/NetworkManager/system-connections/my-wifi-dhcp.nmconnection \
    ${sysconfdir}/NetworkManager/system-connections/pixel-4627.nmconnection \
    ${sysconfdir}/NetworkManager/system-connections/androidapkhg.nmconnection \
    ${sysconfdir}/NetworkManager/conf.d/10-globally-managed-devices.conf \
    ${sysconfdir}/NetworkManager/conf.d/20-wifi.conf \
"
