package com.kotlinstudy.bychkoanna.ui.list

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.kotlinstudy.bychkoanna.R
import kotlinx.android.synthetic.main.activity_main.*
import com.kotlinstudy.bychkoanna.ui.details.DetailsActivity
import com.kotlinstudy.bychkoanna.util.EventObserver
import com.kotlinstudy.bychkoanna.util.viewModelProvider

import android.widget.Button
import com.kotlinstudy.bychkoanna.ui.quote.Quote


class ListActivity : AppCompatActivity() {

    private val viewModel by viewModelProvider<ListScreenModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val startNextButton = findViewById<Button>(R.id.startNextButton)


        startNextButton.setOnClickListener {
            val intent = Intent(this, Quote::class.java)
            startActivity(intent)
        }


        // Initialize recyclerView.
        val adapter = AccountsAdapter(itemViewClick = { account ->
            viewModel.onAccountClick(account.contents)
        })
        recyclerView.adapter = adapter

        // Add view model observers.
        viewModel.accounts.observe(this) { accounts ->
            adapter.setItems(accounts)
        }

        viewModel.showDetailsScreenEvent.observe(this, EventObserver { accountId ->
            val intent = DetailsActivity.getIntent(this, accountId)
            startActivity(intent)
        })


    }
}