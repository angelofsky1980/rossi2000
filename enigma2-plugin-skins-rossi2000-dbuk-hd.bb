MODULE = "dbuk-hd"
DESCRIPTION = "DreamboxUK HD Skin"
HOMEPAGE = https://github.com/rossi2000/rossi2000-dbuk-hd

inherit gitpkgv
PV = "0.1+git${SRCPV}"
PKGV = "0.1+git${GITPKGV}"
PR = "r0.1"

require rossi2000.inc

PLUGINPATH = "/usr/"
do_install() {
	install -d ${D}${PLUGINPATH}
	cp -rp ${S}/plugin/* ${D}${PLUGINPATH}
}

FILES_${PN} = "${PLUGINPATH}"
