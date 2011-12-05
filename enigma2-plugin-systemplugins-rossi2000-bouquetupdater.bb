MODULE = "BouquetUpdater"
DESCRIPTION = "update your bouquets from dreambox"
HOMEPAGE = https://github.com/rossi2000/BouquetUpdater

inherit gitpkgv
PV = "0.1+git${SRCPV}"
PKGV = "0.1+git${GITPKGV}"
PR = "r0.2"

require rossi2000.inc

# Just a quick hack to "compile" it
do_compile() {
	python -O -m compileall ${S}
}

PLUGINPATH = "/usr/lib/enigma2/python/Plugins/SystemPlugins/${MODULE}"
do_install() {
	install -d ${D}${PLUGINPATH}
	cp -rp ${S}/plugin/* ${D}${PLUGINPATH}
	chmod 755 ${PLUGINPATH}/bouquetupdate.sh
}

FILES_${PN} = "${PLUGINPATH}"