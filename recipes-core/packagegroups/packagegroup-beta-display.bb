DESCRIPTION = "Package group for display related packages"
LICENSE = "MIT"
inherit packagegroup

RDEPENDS:${PN} = "\
    packagegroup-qt6-essentials \
    qtwayland \
    weston \
    weston-init \
    cage \
    cog \
    wpewebkit \
    wpebackend-fdo \
    gstreamer1.0-plugins-base \
    gstreamer1.0-plugins-good \
    gstreamer1.0-plugins-bad \
"
