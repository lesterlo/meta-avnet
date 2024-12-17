SUMMARY = "Recipe for building an external wilc Linux kernel module"
SECTION = "PETALINUX/modules"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/GPL-2.0-only;md5=801f80980d171dd6425610833a22dbe6"

inherit module

COMPATIBLE_MACHINE = "u96v2-sbc"

SRCREV = "7b4f29c2562906444271aecb8ed622f3dce0cb0c"
BRANCH = "linux-6.6-mchp"

SRC_URI = "git://github.com/linux4sam/linux-at91.git;protocol=http;branch=${BRANCH};subpath=drivers/net/wireless/microchip/wilc1000 \
           "
#           file://0001-modifications-for-16.2.patch \
#



DEPENDS += "virtual/kernel"

S = "${WORKDIR}/wilc1000"

EXTRA_OEMAKE = 'CONFIG_WILC=y \
		WLAN_VENDOR_MCHP=y \
		CONFIG_WILC_SDIO=m \
		CONFIG_WILC_SPI=n \
		CONFIG_WILC1000_HW_OOB_INTR=n \
		KERNEL_SRC="${STAGING_KERNEL_DIR}" \
		O=${STAGING_KERNEL_BUILDDIR}'

