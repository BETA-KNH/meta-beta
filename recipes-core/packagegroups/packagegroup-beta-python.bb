DESCRIPTION = "Package group for Python related tools"
LICENSE = "MIT"
inherit packagegroup

RDEPENDS:${PN} = "\
    python3-core \
    python3-pip \
    python3-virtualenv \
    python3-setuptools \
    python3-wheel \
    python3-numpy \
    python3-pyserial \
    opencv \
"
