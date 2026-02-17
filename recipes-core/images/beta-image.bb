
require recipes-core/images/core-image-base.bb


IMAGE_FEATURES += " \
    ssh-server-dropbear \
"

IMAGE_INSTALL += " \
    packagegroup-beta-essentials \
    packagegroup-beta-ota \
    packagegroup-beta-display \
    packagegroup-beta-python \
    yarp \
"
