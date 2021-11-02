package com.kotlinstudy.bychkoanna.ui.details

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.kotlinstudy.bychkoanna.MyApplication
import com.kotlinstudy.bychkoanna.ui.AccountPresentation


class DetailsScreenModel(app: Application) : AndroidViewModel(app) {

    private val accountRepository = MyApplication.instance.accountRepository

    val account = MutableLiveData<AccountPresentation>()

    fun initialize(accountId: String) {
        val modelAccount = accountRepository.getAccount(accountId)
        modelAccount?.let { account.value = AccountPresentation(it) }
    }
}