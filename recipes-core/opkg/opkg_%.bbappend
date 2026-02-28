FILESEXTRAPATHS:prepend := "${THISDIR}/files:"

SRC_URI += "file://beta-feed.conf"

do_install:append() {
    install -d ${D}${sysconfdir}/opkg/
    install -m 0644 ${WORKDIR}/beta-feed.conf ${D}${sysconfdir}/opkg/
}
