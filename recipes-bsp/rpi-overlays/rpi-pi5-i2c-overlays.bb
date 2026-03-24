SUMMARY = "Raspberry Pi 5 I2C 2 and 3 overlays"
LICENSE = "Proprietary"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/Proprietary;md5=0557f9d92cf58f2ccdd50f62f8ac0b28"
inherit deploy

SRC_URI = " \
    https://raw.githubusercontent.com/raspberrypi/firmware/63ad7e7980b030cb4649ecedf2255c9226e5a1e8/boot/overlays/i2c2-pi5.dtbo;name=i2c2;downloadfilename=i2c2-pi5.dtbo \
    https://raw.githubusercontent.com/raspberrypi/firmware/63ad7e7980b030cb4649ecedf2255c9226e5a1e8/boot/overlays/i2c3-pi5.dtbo;name=i2c3;downloadfilename=i2c3-pi5.dtbo \
"

SRC_URI[i2c2.sha256sum] = "000c55473979abebd6f2168a50d8cca04f9d9038c67d22eaab75d1c15e832c23"
SRC_URI[i2c3.sha256sum] = "454be8a322ce840483666c5bfd8349df305f0f831d560222fa90ae320370443b"

S = "${WORKDIR}"

COMPATIBLE_MACHINE = "^rpi$|^raspberrypi.*$"

do_compile[noexec] = "1"

do_install() {
    install -d ${D}${nonarch_base_libdir}/firmware/overlays
    install -m 0644 ${WORKDIR}/i2c2-pi5.dtbo ${D}${nonarch_base_libdir}/firmware/overlays/
    install -m 0644 ${WORKDIR}/i2c3-pi5.dtbo ${D}${nonarch_base_libdir}/firmware/overlays/
}

do_deploy() {
    install -d ${DEPLOYDIR}
    install -m 0644 ${WORKDIR}/i2c2-pi5.dtbo ${DEPLOYDIR}/
    install -m 0644 ${WORKDIR}/i2c3-pi5.dtbo ${DEPLOYDIR}/
}

addtask deploy after do_install

FILES:${PN} += " \
    ${nonarch_base_libdir}/firmware/overlays/i2c2-pi5.dtbo \
    ${nonarch_base_libdir}/firmware/overlays/i2c3-pi5.dtbo \
"
