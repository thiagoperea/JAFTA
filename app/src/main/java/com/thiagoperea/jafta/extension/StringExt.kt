package com.thiagoperea.jafta.extension

fun String?.containsAny(vararg toValidate: String): Boolean {
    if (this == null) return false

    toValidate.forEach {
        if (this.contains(it)) return true
    }

    return false
}