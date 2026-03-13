
require recipes-core/images/core-image-base.bb

inherit extrausers
EXTRA_USERS_PARAMS = "usermod -p '\$6\$2QleNSSNKe5VUhuq\$JwllvN6hj6xBOmn5mFyxrEc01boiUP0ow45BVGQChEQ2W8GNXqMJEqczrsWnT9dDRVtHG2gdiPIIHQtMs.9ZQ.' root;"


IMAGE_FEATURES += " \
    ssh-server-dropbear \
    package-management \
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
