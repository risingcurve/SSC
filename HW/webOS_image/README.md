// webOS img built by AhnChangYong.
// ver. webOS OSE 2.19.1
// 64bit, normal version, deleted all test apps by AhnChangYong...

// IMG file size is over 1GB, 
// Google Drive Link Below.

//https://drive.google.com/file/d/1IRtQj__NsnzLXtitWZhi62oDLPxWEBJl/view?usp=share_link


// full dev version is about 6GB, if you need this version, msg me erican613@gmail.com
// if you want to build your own img, plz visit my blog.
// https://ssafy.tistory.com/4




// webOS raspberry pi 4B flashing GUIDE

// 1. format your SD card with raspberrypi imager. (+ 8GB )
// 2. 
// Windows : Flash the image using Win32DiskImager.
// https://sourceforge.net/projects/win32diskimager/
// LINUX :

First, change directory to where the image is located.

$ cd <path where the image is located>
Check the device name of the microSD card using the following command.

$ sudo fdisk -l
To flash the image to the microSD card, run the following commands.

$ sudo umount /dev/sd<xN>
$ sudo dd bs=4M if=./<webOS OSE image> of=/dev/sd<x>
$ sudo umount /dev/sd<xN>
sd<xN> denotes the device name of the microSD card, where N is a number suffix.
For dd command, you must pass sd<x> (without the suffix number) to the of operand. sd<x> indicates the mass storage device, not the partition.



// 3. connect Display with Raspberry board which supports 1080p or higher.

// 4. if your Display module having smaller than 1920*1080, (just supporting 1080p)
overwrite my config.txt


// 5. mount Sd card to rpi[raspberrypi] and boot.

// 6. open setting App, set Wifi, time.

