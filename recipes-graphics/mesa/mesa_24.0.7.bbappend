FILESEXTRAPATHS:prepend := "${THISDIR}/files:"

SRC_URI:append = " file://0001-c11-threads-fix-build-on-c23.patch"
