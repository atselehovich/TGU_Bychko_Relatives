package com.kotlinstudy.bychkoanna.ui.details

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.content.Intent
import android.text.Editable
import com.kotlinstudy.bychkoanna.R
import com.kotlinstudy.bychkoanna.ui.TextWatcherAdapter
import com.kotlinstudy.bychkoanna.util.viewModelProvider
import kotlinx.android.synthetic.main.activity_details.*

class DetailsActivity : AppCompatActivity() {
    private val viewModel by viewModelProvider<DetailsScreenModel>()


    // R. - коорневой сгенерированный элемент, который позволяет обращаться ко всем xml-ресурсам
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)

        // Initialize view model
        val accountId = getAccountId(intent)
        /* первый вариант: accountIdView.text = accountId */
        if (accountId == null) {
            finish()
        } else {
            viewModel.initialize(accountId)
        }

        //add observres
        viewModel.account.observe(this) { account ->
            accountIdView.text = accountId
        }

        // add view listeners
        myEditText.addTextChangedListener(object: TextWatcherAdapter() {
            override fun afterTextChanged(s: Editable?) {
                //TODO
                val number = s?.toString()?.toIntOrNull()

            }
        })
    }

    companion object {
        private const val EXTRA_ACCOUNT_ID = "DetailsActivity:accountId"

        fun getIntent(activity: AppCompatActivity, accountId: String): Intent {
            return Intent(activity, DetailsActivity::class.java).apply {
                putExtra(EXTRA_ACCOUNT_ID, accountId)
            }
        }

        fun getAccountId(intent: Intent): String? = intent.getStringExtra(EXTRA_ACCOUNT_ID)




    }
}