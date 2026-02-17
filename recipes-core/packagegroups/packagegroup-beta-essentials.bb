DESCRIPTION = "Essential packages for Humanoid Robot"

LICENSE = "MIT"
inherit packagegroup

RDEPENDS:${PN} = "\
    networkmanager \
    linux-firmware-rpidistro-bcm43455 \
    i2c-tools \
    tmux \
    espeak \
    ncurses-terminfo-base \
"
