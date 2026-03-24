DESCRIPTION = "Development tools for Humanoid Robot"

LICENSE = "MIT"
inherit packagegroup

RDEPENDS:${PN} = "\
    packagegroup-core-buildessential \
    cmake \
    git \
"