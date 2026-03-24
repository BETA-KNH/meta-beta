DESCRIPTION = "Package group for robotics software"
LICENSE = "MIT"
inherit packagegroup

RDEPENDS:${PN} = "\
    ros-base \
    python3-colcon-common-extensions \
    yarp \
"
