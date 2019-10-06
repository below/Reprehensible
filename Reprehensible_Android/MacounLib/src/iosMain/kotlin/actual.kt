package com.vonbelow.reprehensible

import platform.UIKit.*

actual fun platformHello(): String {
    return "${UIDevice.currentDevice.systemName} ${UIDevice.currentDevice.systemVersion}"
}