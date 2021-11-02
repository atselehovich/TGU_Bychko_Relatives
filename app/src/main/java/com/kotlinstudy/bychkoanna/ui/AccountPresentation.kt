package com.kotlinstudy.bychkoanna.ui

import com.kotlinstudy.bychkoanna.repositories.*

// отображение данных
class AccountPresentation(val id: String, var name: String, var contents: String) {

    constructor(account: Account) : this(account.id, account.name, account.contents)

}