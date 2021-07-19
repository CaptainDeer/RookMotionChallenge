package com.captaindeer.rookmotionchallenge.utils

import android.text.TextUtils
import android.util.Patterns

object ValidEmail {
    fun isEmailValid(email: String): Boolean {
        return TextUtils.isEmpty(email) && Patterns.EMAIL_ADDRESS.matcher(email).matches()
    }
}