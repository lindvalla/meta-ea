SUMMARY = "A console-only image for testing and verifying functionality \
on the target device hardware."

CORE_IMAGE_EXTRA_INSTALL = " \
   i2c-tools-misc \
   i2c-tools \
   pciutils \
   can-utils \
   iproute2 \
   evtest \
   alsa-utils \
   python-subprocess \
   python-pyserial \
   python-argparse \
"

LICENSE = "MIT"

#KERNEL_DEVICETREE_append = ' ${@bb.utils.contains("MACHINE_ARCH", "imx6dlea_com", "imx6dlea-com-kit-mfg.dtb", "",d)}'
#KERNEL_DEVICETREE_append = ' ${@bb.utils.contains("MACHINE_ARCH", "imx6qea_com", "imx6qea-com-kit-mfg.dtb", "",d)}'
#KERNEL_DEVICETREE_append = ' ${@bb.utils.contains("MACHINE_ARCH", "imx6sxea_com", "imx6sxea-com-kit-mfg.dtb", "",d)}'
#KERNEL_DEVICETREE_append = ' ${@bb.utils.contains("MACHINE_ARCH", "imx6ulea_com", "imx6ulea-com-kit-mfg.dtb", "",d)}'
#KERNEL_DEVICETREE_append = ' ${@bb.utils.contains("MACHINE_ARCH", "imx7dea_com", "imx7dea-com-kit-mfg.dtb", "",d)}'
#KERNEL_DEVICETREE_append = ' ${@bb.utils.contains("MACHINE_ARCH", "imx7dea_ucom", "imx7dea-ucom-kit-mfg.dtb", "",d)}'


#UBOOT_SUFFIX = "imx"
#UBOOT_MAKE_TARGET = "all u-boot.imx"

inherit mfgtool-initramfs-image

FILESEXTRAPATHS_prepend := "${THISDIR}/files:"
FILES_TO_COPY := "${THISDIR}/files_mfg"

ROOTFS_POSTPROCESS_COMMAND += "add_my_own_files; "

add_my_own_files() {
        rsync -a ${FILES_TO_COPY}/*  ${WORKDIR}/rootfs
}

