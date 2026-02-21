inherit bundle

RAUC_BUNDLE_COMPATIBLE ?= "raspberrypi5"
RAUC_BUNDLE_SLOTS ?= "rootfs"
RAUC_BUNDLE_FORMAT ?= "verity"
RAUC_SLOT_rootfs ?= "beta-image"

RAUC_KEY_FILE = "${THISDIR}/../../files/rauc-keys/development-1.key.pem"
RAUC_CERT_FILE = "${THISDIR}/../../files/rauc-keys/development-1.cert.pem"