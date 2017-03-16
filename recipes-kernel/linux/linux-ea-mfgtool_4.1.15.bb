
SUMMARY = "Produces a Manufacturing Tool compatible Linux Kernel"

require recipes-kernel/linux/linux-imx.inc
require recipes-kernel/linux/linux-dtb.inc

DEFCONFIG_FILE := "${THISDIR}/${PN}-${PV}/defconfig"

FILESEXTRAPATHS_prepend := "${THISDIR}/linux-ea-mfgtool-4.1.15:"

SRC_URI = "git://github.com/embeddedartists/linux-imx.git;protocol=git;branch=${SRCBRANCH} \
           file://0001_add_mfgtool_dtb_files.patch;patch=1"

LOCALVERSION = "-1.2.0"
SRCBRANCH = "ea_imx_4.1.15_1.0.0"
SRCREV = "e1189216a536068b2ebedd74f7f4c66d984204cd"
DEPENDS += "lzop-native bc-native"

COMPATIBLE_MACHINE = "(mx6|mx6ul|mx7)"

KERNEL_DEVICETREE_append = ' ${@bb.utils.contains("MACHINE_ARCH", "imx6dlea_com", "imx6dlea-com-kit-mfg.dtb", "",d)}'
KERNEL_DEVICETREE_append = ' ${@bb.utils.contains("MACHINE_ARCH", "imx6qea_com", "imx6qea-com-kit-mfg.dtb", "",d)}'
KERNEL_DEVICETREE_append = ' ${@bb.utils.contains("MACHINE_ARCH", "imx6sxea_com", "imx6sxea-com-kit-mfg.dtb", "",d)}'
KERNEL_DEVICETREE_append = ' ${@bb.utils.contains("MACHINE_ARCH", "imx6ulea_com", "imx6ulea-com-kit-mfg.dtb", "",d)}'
KERNEL_DEVICETREE_append = ' ${@bb.utils.contains("MACHINE_ARCH", "imx7dea_com", "imx7dea-com-kit-mfg.dtb", "",d)}'
KERNEL_DEVICETREE_append = ' ${@bb.utils.contains("MACHINE_ARCH", "imx7dea_ucom", "imx7dea-ucom-kit-mfg.dtb", "",d)}'

do_configure_prepend() {
    cp ${DEFCONFIG_FILE} ${B}/../defconfig
    #echo "EA: In do_configure_prepend: ${DEFCONFIG_FILE}"
}

require recipes-kernel/linux/linux-mfgtool.inc

do_deploy () {
    install -d ${DEPLOY_DIR_IMAGE}
    install  arch/arm/boot/zImage ${DEPLOY_DIR_IMAGE}/zImage_mfgtool
}

