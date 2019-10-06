package com.vonbelow.reprehensible

import platform.CoreGraphics.CGRectGetHeight
import platform.CoreGraphics.CGRectGetWidth
import platform.UIKit.*
import platform.Foundation.*

actual fun platformSpecific(): String {
    val date = NSDate()
    val dateFormatter = NSDateFormatter()
    dateFormatter.dateStyle = NSDateFormatterMediumStyle
    dateFormatter.timeStyle = NSDateFormatterMediumStyle
    val dateString = dateFormatter.stringFromDate(date)


    return UIDevice.currentDevice.systemName() + " " + UIDevice.currentDevice.systemVersion
}