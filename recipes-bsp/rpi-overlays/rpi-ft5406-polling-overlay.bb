SUMMARY = "DFR0550 FT5406 touchscreen polling overlay for CM5"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

inherit deploy

DEPENDS += "dtc-native"

SRC_URI = "file://ft5406-polling-overlay.dts"

S = "${WORKDIR}"

COMPATIBLE_MACHINE = "^rpi$|^raspberrypi.*$"


do_compile() {
    ${STAGING_BINDIR_NATIVE}/dtc -@ -I dts -O dtb \
        -o ${WORKDIR}/ft5406-polling.dtbo \
        ${WORKDIR}/ft5406-polling-overlay.dts
}


do_install() {
    install -d ${D}${nonarch_base_libdir}/firmware/overlays
    install -m 0644 ${WORKDIR}/ft5406-polling.dtbo ${D}${nonarch_base_libdir}/firmware/overlays/
}


do_deploy() {
    install -d ${DEPLOYDIR}
    install -m 0644 ${WORKDIR}/ft5406-polling.dtbo ${DEPLOYDIR}/
}

addtask deploy after do_compile

FILES:${PN} += "${nonarch_base_libdir}/firmware/overlays/ft5406-polling.dtbo"
