SUMMARY = "ST bus servo driver and CLI tools"
DESCRIPTION = "C++ driver and utilities for controlling ST-series bus servos \
over a UART/RS-485 interface. Provides scan_servos, servo_cli, and \
servo_controller binaries."
HOMEPAGE = "https://github.com/BETA-KNH/beta-servo-sensei"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=86d3f3a95c324c9479bd8986968f4327"

SRC_URI = "git://github.com/BETA-KNH/beta-servo-sensei.git;protocol=https;nobranch=1"
SRCREV  = "b589932393d72129c2a9f0496c48a8a7f9fafb0f"
S = "${WORKDIR}/git"

inherit cmake

EXTRA_OECMAKE = "-DBUILD_TESTING=OFF"

do_install:append() {
    install -d ${D}${sysconfdir}/servo_sensei
    if [ -f ${D}${sysconfdir}/servo_sensei/servo.env.sample ]; then
        install -m 0644 \
            ${D}${sysconfdir}/servo_sensei/servo.env.sample \
            ${D}${sysconfdir}/servo_sensei/servo.env
    else
        install -m 0644 \
            ${S}/conf/servo.env \
            ${D}${sysconfdir}/servo_sensei/servo.env
    fi
}

FILES:${PN} = " \
    ${bindir}/scan_servos \
    ${bindir}/servo_cli \
    ${bindir}/servo_controller \
    ${sysconfdir}/servo_sensei/servo.env \
    ${sysconfdir}/servo_sensei/servo.env.sample \
"

CONFFILES:${PN} = "${sysconfdir}/servo_sensei/servo.env"
