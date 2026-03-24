GPU_MEM = "128"

VC4DTBO = "vc4-kms-v3d"
VC4GRAPHICS = "1"
DISABLE_FW_KMS_SETUP = "1"

ENABLE_UART = "1"
RPI_USE_U_BOOT = "1"

# DFR0550 5" DSI panel + FT5406 touch (CM5 MIPI0)
RPI_EXTRA_CONFIG:append = "\n\
dtoverlay=vc4-kms-dsi-7inch,dsi0\n\
dtparam=i2c_vc=on\n\
dtoverlay=ft5406-polling\n\
dtparam=i2c_arm=on\n\
dtoverlay=i2c2-pi5\n\
dtoverlay=i2c3-pi5\n\
"
