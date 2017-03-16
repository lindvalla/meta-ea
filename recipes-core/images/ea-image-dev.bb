SUMMARY = "A console-only image for testing and verifying functionality \
on the target device hardware."

IMAGE_FEATURES = " \
   splash \
   ssh-server-openssh \
   dev-pkgs \
   dbg-pkgs \
"

ONLY_FOR_X11 = ' ${@bb.utils.contains("DISTRO_FEATURES", "X11", "gtk+3 gtk+3-dev", "",d)}'

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
   packagegroup-core-buildessential \
   python-smbus \
   python-imaging \
   python-numpy \
   python-pyusb \
   python-cython \
   nodejs \
   nodejs-npm \
   sysfsutils \
   git \
   fsl-rc-local \
   cairo \
   cairo-perf-utils \
   cairo-script-interpreter \
   cairo-gobject \
   cairo-dev \
   mtdev \
   tslib-conf \
   tslib-tests \
   tslib-calibrate \
   tslib \
   tslib-dev \
   openssh-sftp-server \
   gdbserver \
   ${ONLY_FOR_X11} \
"


# User/Group modifications
# - Adding user 'tester' without password
# - Setting password for user 'root' to 'pass'
# - For more options see extrausers.bbclass
INHERIT += " extrausers"
EXTRA_USERS_PARAMS = " \
  useradd -p '' tester; \
  usermod -s /bin/sh tester; \
  usermod -P 'pass' root \
"

LICENSE = "MIT"

inherit core-image
