package com.ali.ayn.healthcare.db

import android.content.Context
import android.content.Context.MODE_PRIVATE
import android.content.SharedPreferences
import javax.inject.Inject

class SharePrefManager @Inject constructor(private val context: Context) {

    private val USER_LOGGED_SHARED_PREF_LOGIN = "app_shared_pref_login"
    private val KEY_USER_LOGIN = "user_login"

    private var sharedPreferencesLogin: SharedPreferences

    init {
        sharedPreferencesLogin = context.getSharedPreferences(USER_LOGGED_SHARED_PREF_LOGIN, MODE_PRIVATE)
    }

    fun setLogin(b: Boolean) {
        val editor = sharedPreferencesLogin.edit()
        editor.putBoolean(KEY_USER_LOGIN, b)
        editor.apply()
    }

    fun isLogin(): Boolean {
        val sharedPrefManagerLogged = context.getSharedPreferences(USER_LOGGED_SHARED_PREF_LOGIN, MODE_PRIVATE)
        return sharedPrefManagerLogged.getBoolean(KEY_USER_LOGIN, false)
    }

}