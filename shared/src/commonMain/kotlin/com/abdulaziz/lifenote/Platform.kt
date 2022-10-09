package com.abdulaziz.lifenote

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform