package com.example.flippymind.app

import android.app.Application
import com.example.data.database.MainDatabase
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class App : Application() {

    val database by lazy {
         MainDatabase.createDatabase(this)
    }
}