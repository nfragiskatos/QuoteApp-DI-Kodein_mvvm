package com.nfragiskatos.quoteapp_di_kodein_mvvm.ui.quotes

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.nfragiskatos.quoteapp_di_kodein_mvvm.R
import com.nfragiskatos.quoteapp_di_kodein_mvvm.data.model.Quote
import kotlinx.android.synthetic.main.activity_quotes.*
import org.kodein.di.KodeinAware
import org.kodein.di.android.closestKodein
import org.kodein.di.generic.instance

class QuotesActivity : AppCompatActivity(), KodeinAware {

    // closestKodein will get the Kodein we defined in QuotesApplication
    override val kodein by closestKodein()

    private val quotesViewModelFactory: QuotesViewModelFactory by instance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quotes)
        initializeUi()
    }

    private fun initializeUi() {
        /*
        Use the ViewModelProvider class to create or get the QuotesViewModel for this activity.
        It handles maintaining the ViewModel as a singleton.
         */
        val quotesViewModel =
            ViewModelProvider(this, quotesViewModelFactory).get(QuotesViewModel::class.java)

        /*
        Observe the LiveData quotes list from the QuotesViewModel, which in turn observes LiveData from
        the repository, which continues and observes LiveData from the DAO
         */
        quotesViewModel.getQuotes().observe(this, Observer { quotes ->
            val builder = StringBuilder()
            quotes.forEach { quote ->
                builder.append("$quote\n\n")
            }
            textView_quotes.text = builder.toString()
        })

        /*
        When the button is clicked to submit a quote, we need to create it and pass it down to the DB
        through the View Model
         */
        button_add_quote.setOnClickListener {
            val quote = Quote(editText_quote.text.toString(), editText_author.text.toString())
            quotesViewModel.addQuote(quote)
            editText_author.setText("")
            editText_quote.setText("")
        }
    }


}
