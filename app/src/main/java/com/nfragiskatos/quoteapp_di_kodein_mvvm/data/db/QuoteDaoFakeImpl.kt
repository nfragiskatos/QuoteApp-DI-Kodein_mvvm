package com.nfragiskatos.quoteapp_di_kodein_mvvm.data.db

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.nfragiskatos.quoteapp_di_kodein_mvvm.data.model.Quote

/**
 * Created by Nicholas Fragiskatos on 4/18/2020.
 */
class QuoteDaoFakeImpl : QuoteDao {

    // Fake DB table
    private val quoteList = mutableListOf<Quote>()

    private val quotes = MutableLiveData<List<Quote>>()

    init {
        quotes.value = quoteList
    }


    override fun addQuote(quote: Quote) {
        quoteList.add(quote)
        // Need to reset this so quotes knows to notify its observers.
        quotes.value = quoteList
    }

    override fun getQuotes(): LiveData<List<Quote>> = quotes as LiveData<List<Quote>>

}