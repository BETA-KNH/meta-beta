DESCRIPTION = "Package group for Python related tools"
LICENSE = "MIT"
inherit packagegroup

RDEPENDS:${PN} = "\
    python3-core \
    python3-pip \
    python3-virtualenv \
    python3-setuptools \
    python3-wheel \
    python3-numpy \
    python3-pyserial \
    python3-tomllib \
    python3-multiprocessing \
    python3-json \
    python3-logging \
    python3-datetime \
    python3-crypt \
    python3-io \
    python3-netclient \
    python3-math \
    python3-numbers \
    python3-threading \
    python3-asyncio \
    python3-pickle \
    python3-xml \
    python3-sqlite3 \
    python3-stringold \
    python3-shell \
    opencv \
"
