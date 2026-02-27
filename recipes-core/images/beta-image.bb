
require recipes-core/images/core-image-base.bb


IMAGE_FEATURES += " \
    ssh-server-dropbear \
"

IMAGE_INSTALL += " \
    packagegroup-beta-essentials \
    packagegroup-beta-ota \
    packagegroup-beta-display \
    packagegroup-beta-python \
    packagegroup-beta-robotics \
"

# ROOTFS_POSTPROCESS_COMMAND += "create_update_marker;"

# create_update_marker() {
#     echo "System updated on $(date)" > ${IMAGE_ROOTFS}/etc/update-marker
# }
