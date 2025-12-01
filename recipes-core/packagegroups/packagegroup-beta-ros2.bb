DESCRIPTION = "Package group for ROS 2"
LICENSE = "CLOSED"
inherit packagegroup

RDEPENDS:${PN} = "\
    ros-core \
    rclcpp \
    rclpy \
"
