DESCRIPTION = "Package group for display related packages"
LICENSE = "MIT"
inherit packagegroup

RDEPENDS:${PN} = "\
    packagegroup-qt6-essentials \
    qtwayland \
    chromium-ozone-wayland \
    weston \
    weston-init \
    cage \
"
