package com.example.a8x302.qllistphonggym.Utils

import android.content.Context
import android.content.SharedPreferences
import android.preference.PreferenceManager

class PreferenceUtils{
     fun PreferenceUtils() {

     }

    fun saveEmail(email: String, context: Context): Boolean {
        val prefs = PreferenceManager.getDefaultSharedPreferences(context)
        val prefsEditor = prefs.edit()
        prefsEditor.putString(Constants.KEY_EMAIL, email)
        prefsEditor.apply()
        return true
    }
    fun deleteEmail(context: Context): Boolean {
        val prefs = PreferenceManager.getDefaultSharedPreferences(context)
        val prefsEditor = prefs.edit()
        prefsEditor.remove(Constants.KEY_EMAIL)
        prefsEditor.apply()
        return true
    }

    fun getEmail(context: Context): String? {
        val prefs = PreferenceManager.getDefaultSharedPreferences(context)
        return prefs.getString(Constants.KEY_EMAIL, null)
    }

    fun savePassword(password: String, context: Context): Boolean {
        val prefs = PreferenceManager.getDefaultSharedPreferences(context)
        val prefsEditor = prefs.edit()
        prefsEditor.putString(Constants.KEY_PASSWORD, password)
        prefsEditor.apply()
        return true
    }
    fun deletePassword(context: Context): Boolean {
        val prefs = PreferenceManager.getDefaultSharedPreferences(context)
        val prefsEditor = prefs.edit()
        prefsEditor.remove(Constants.KEY_PASSWORD)
        prefsEditor.apply()
        return true
    }
    fun getPassword(context: Context): String? {
        val prefs = PreferenceManager.getDefaultSharedPreferences(context)
        return prefs.getString(Constants.KEY_PASSWORD, null)
    }
 }