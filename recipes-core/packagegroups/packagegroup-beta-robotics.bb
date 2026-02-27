DESCRIPTION = "Package group for robotics software"
LICENSE = "MIT"
inherit packagegroup

RDEPENDS:${PN} = "\
    yarp \
    servo-sensei \
"
