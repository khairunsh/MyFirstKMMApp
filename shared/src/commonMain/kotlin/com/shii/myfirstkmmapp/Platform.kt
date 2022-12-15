package com.shii.myfirstkmmapp

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform