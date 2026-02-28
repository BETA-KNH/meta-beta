SUMMARY = "The easiest, most secure way to use WireGuard and 2FA"
DESCRIPTION = "Tailscale is a zero-config VPN built on WireGuard. \
    Uses pre-built upstream binaries for arm64."
HOMEPAGE = "https://tailscale.com"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

# Only compatible with aarch64 (Raspberry Pi 5)
COMPATIBLE_HOST = "aarch64.*-linux"

SRC_URI = "https://pkgs.tailscale.com/stable/tailscale_${PV}_arm64.tgz;subdir=${BP}"
SRC_URI[sha256sum] = "76300e808c57eb7853090d69c8bd8806e86341862e244183f6611f9105799bba"

S = "${WORKDIR}/${BP}/tailscale_${PV}_arm64"

inherit systemd

SYSTEMD_SERVICE:${PN} = "tailscaled.service"
SYSTEMD_AUTO_ENABLE:${PN} = "enable"

# Skip QA errors for pre-built binaries (already stripped, foreign elf, etc.)
INSANE_SKIP:${PN} = "already-stripped ldflags file-rdeps"

do_configure[noexec] = "1"
do_compile[noexec] = "1"

do_install() {
    # Binaries
    install -d ${D}${sbindir}
    install -d ${D}${bindir}
    install -m 0755 ${S}/tailscaled ${D}${sbindir}/tailscaled
    install -m 0755 ${S}/tailscale  ${D}${bindir}/tailscale

    # systemd service
    install -d ${D}${systemd_system_unitdir}
    install -m 0644 ${S}/systemd/tailscaled.service ${D}${systemd_system_unitdir}/tailscaled.service

    # Default config
    install -d ${D}${sysconfdir}/default
    install -m 0644 ${S}/systemd/tailscaled.defaults ${D}${sysconfdir}/default/tailscaled

    # State directory
    install -d ${D}${localstatedir}/lib/tailscale
}

FILES:${PN} = " \
    ${sbindir}/tailscaled \
    ${bindir}/tailscale \
    ${systemd_system_unitdir}/tailscaled.service \
    ${sysconfdir}/default/tailscaled \
    ${localstatedir}/lib/tailscale \
"
