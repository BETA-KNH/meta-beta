DESCRIPTION = "Essential packages for Humanoid Robot"

LICENSE = "MIT"
inherit packagegroup

RDEPENDS:${PN} = "\
    packagegroup-beta-python \
    networkmanager \
"
