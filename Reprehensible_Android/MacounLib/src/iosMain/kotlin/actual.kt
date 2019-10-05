package com.vonbelow.reprehensible

import platform.UIKit.UIDevice

actual fun platformSpecific(): String {
    return UIDevice.currentDevice.systemName() + " " + UIDevice.currentDevice.systemVersion
}