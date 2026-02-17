SUMMARY = "YARP - Yet Another Robot Platform"
DESCRIPTION = "YARP is a library and toolkit for communication and device interfaces for robot software"
HOMEPAGE = "https://www.yarp.it/"
LICENSE = "BSD-3-Clause"
LIC_FILES_CHKSUM = "file://COPYING;md5=9c7ba123b611bad038b4ef996fe3aae8"

SRC_URI = "git://github.com/robotology/yarp.git;protocol=https;nobranch=1"
SRCREV = "v${PV}"

S = "${WORKDIR}/git"

inherit cmake pkgconfig python3native

DEPENDS = " \
    ycm \
    zlib \
    sqlite3 \
    opencv \
    lua \
    python3 \
    swig-native \
"

EXTRA_OECMAKE = " \
    -DSKIP_ACE=ON \
    -DYARP_COMPILE_GUIS=OFF \
    -DYARP_COMPILE_TESTS=OFF \
    -DYARP_COMPILE_EXAMPLES=OFF \
    -DYARP_COMPILE_CARRIER_PLUGINS=ON \
    -DYARP_COMPILE_DEVICE_PLUGINS=ON \
    -DCREATE_PYTHON=ON \
    -DYARP_USE_PYTHON_VERSION=3 \
    -DYARP_PYTHON_INSTALL_DIR=${PYTHON_SITEPACKAGES_DIR} \
    -DYARP_FLOAT32_IS_IEC559=ON \
    -DYARP_FLOAT64_IS_IEC559=ON \
    -DYARP_FLOAT128_IS_IEC559=OFF \
    -DYARP_FLT_EXP_DIG=8 \
    -DYARP_DBL_EXP_DIG=11 \
    -DYARP_LDBL_EXP_DIG=15 \
"

RDEPENDS:${PN} += "python3-core"

# inherit systemd
# SYSTEMD_SERVICE:${PN} = "yarpserver.service"

FILES:${PN} += " \
    ${libdir}/yarp/* \
    ${datadir}/yarp/* \
    ${datadir}/bash-completion/* \
    ${libdir}/libyarpmod.so \
    ${libdir}/libyarpcar.so \
    ${libdir}/libyarppm.so \
    ${PYTHON_SITEPACKAGES_DIR}/* \
"

FILES:${PN}-dev += " \
    ${libdir}/cmake/YARP/* \
"

INSANE_SKIP:${PN}-dev += "dev-elf"
INSANE_SKIP:${PN}-src += "buildpaths"
INSANE_SKIP:${PN}-dev += "buildpaths"


BBCLASSEXTEND = "native nativesdk"
