package com.vonbelow.reprehensible

expect fun platformSpecific(): String

fun helloMacoun(): String {
    val spec = platformSpecific()
    return "Let's rock ${spec}"
}
