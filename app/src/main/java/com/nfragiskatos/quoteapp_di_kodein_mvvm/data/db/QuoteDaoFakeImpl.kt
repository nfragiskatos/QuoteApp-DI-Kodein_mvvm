package com.nfragiskatos.quoteapp_di_kodein_mvvm.data.db

import androidx.lifecycle.LiveData
import com.nfragiskatos.quoteapp_di_kodein_mvvm.data.model.Quote

/**
 * Created by Nicholas Fragiskatos on 4/18/2020.
 */
class QuoteDaoFakeImpl : QuoteDao {

    private val quoteList = mutableListOf<Quote>()

    override fun addQuote(quote: Quote) {
        TODO("Not yet implemented")
    }

    override fun getQuotes(): LiveData<List<Quote>> {
        TODO("Not yet implemented")
    }

}