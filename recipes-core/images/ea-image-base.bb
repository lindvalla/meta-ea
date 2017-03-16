SUMMARY = "A console-only image for testing and verifying functionality \
on the target device hardware."

IMAGE_FEATURES = " splash"

CORE_IMAGE_EXTRA_INSTALL = " \
   i2c-tools-misc \
   i2c-tools \
   pciutils \
   can-utils \
   iproute2 \
   evtest \
   alsa-utils \
   fbida \
   wget \
   nano \
   python-subprocess \
   python-pyserial \
   python-argparse \
   python-pip \
"

LICENSE = "MIT"

inherit core-image
