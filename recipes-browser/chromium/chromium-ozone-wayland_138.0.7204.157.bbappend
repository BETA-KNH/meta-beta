FILESEXTRAPATHS:prepend := "${THISDIR}/files:"

SRC_URI += " \
    file://0001-rust-qr_code-fix-mismatched-lifetime-syntaxes.patch \
    file://0002-rust-crabbyavif-fix-no_sanitize-removed-in-rust-1.91.patch \
    file://0003-rust-allocator-export-v2-alloc-shim-symbols.patch \
"
