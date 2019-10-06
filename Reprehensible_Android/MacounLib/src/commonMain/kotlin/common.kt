package com.vonbelow.reprehensible

expect fun platformHello(): String

fun helloMacoun(): String {
    return "Hello ${platformHello()}"
}