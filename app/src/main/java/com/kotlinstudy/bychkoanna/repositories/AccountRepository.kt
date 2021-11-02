package com.kotlinstudy.bychkoanna.repositories

import com.kotlinstudy.bychkoanna.repositories.Account
import com.kotlinstudy.bychkoanna.repositories.ConstAccountSource

/* один репозиторий (repository) может работать с несколькими источниками (source)
* задача репозитория - переадресовать запрос какому-то из источников
* для получения из него данных */

class AccountRepository {
    private val source = ConstAccountSource()

    fun getAccounts(): List<Account> {
        return source.getAccounts()
    }

    fun getAccount(id: String): Account? {
        return source.getAccount(id)
    }


}