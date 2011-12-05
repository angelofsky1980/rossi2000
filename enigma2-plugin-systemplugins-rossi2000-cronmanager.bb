MODULE = "Cronmanager"
DESCRIPTION = "update your bouquets from dreambox"
HOMEPAGE = https://github.com/rossi2000/Cronmanager

inherit gitpkgv
PV = "0.1+git${SRCPV}"
PKGV = "0.1+git${GITPKGV}"
PR = "r0.1"

require rossi2000.inc

# Just a quick hack to "compile" it
do_compile() {
	python -O -m compileall ${S}
}

PLUGINPATH = "/usr/lib/enigma2/python/Plugins/SystemPlugins/${MODULE}"
CRONPATH = "/etc/cron"
CRONSCRIPTPATH = "/etc/cron/scripts"
do_install() {
	install -d ${D}${PLUGINPATH}
	cp -rp ${S}/plugin/* ${D}${PLUGINPATH}
	install -d ${D}${CRONPATH}
	cp -rp ${S}/cronmanager.sh ${D}${CRONPATH}
	cp -rp ${S}/timezone.sh ${D}${CRONPATH}	
	install -d ${D}${CRONSCRIPTPATH}
	cp -rp ${S}/script/* ${D}${CRONSCRIPTPATH}
}

FILES_${PN} = "${PLUGINPATH} ${CRONPATH} ${CRONSCRIPTPATH}"