package com.kotlinstudy.bychkoanna.ui.list

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.kotlinstudy.bychkoanna.ui.AccountPresentation
import com.kotlinstudy.bychkoanna.MyApplication
import com.kotlinstudy.bychkoanna.util.Event

class ListScreenModel(app: Application) : AndroidViewModel(app) {

    private val accountRepository = MyApplication.instance.accountRepository

    val accounts = MutableLiveData<List<AccountPresentation>>()

    val showDetailsScreenEvent = MutableLiveData<Event<String>>()

    init {
        accounts.value = accountRepository.getAccounts().map { account -> AccountPresentation(account) }
    }

    fun onAccountClick(accountId: String) {
        showDetailsScreenEvent.value = Event(accountId)
    }
}