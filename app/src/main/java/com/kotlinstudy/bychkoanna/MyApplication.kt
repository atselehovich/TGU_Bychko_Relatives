package com.kotlinstudy.bychkoanna

import android.app.Application
import com.kotlinstudy.bychkoanna.repositories.AccountRepository

class MyApplication : Application() {

    lateinit var accountRepository: AccountRepository
        private set

    override fun onCreate() {
        super.onCreate()

        instance = this
        accountRepository = AccountRepository()
    }

    companion object {
        lateinit var instance: MyApplication
            private set
    }
}