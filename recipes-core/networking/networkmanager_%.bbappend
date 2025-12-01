do_install:append() {
    install -d ${D}${sysconfdir}/NetworkManager/system-connections/
    cat > ${D}${sysconfdir}/NetworkManager/system-connections/my-wifi-dhcp.nmconnection <<EOF
[connection]
id=my-wifi-dhcp
type=wifi
interface-name=wlan0  # or remove for auto-detection

[wifi]
mode=infrastructure
ssid=EkolineNet_D57F-5G

[wifi-security]
key-mgmt=wpa-psk
psk=LwMhPdDc

[ipv4]
method=auto  # DHCP (default)

[ipv6]
method=auto  # or "ignore" if IPv6 is not needed
EOF
    chmod 600 ${D}${sysconfdir}/NetworkManager/system-connections/my-wifi-dhcp.nmconnection
}
