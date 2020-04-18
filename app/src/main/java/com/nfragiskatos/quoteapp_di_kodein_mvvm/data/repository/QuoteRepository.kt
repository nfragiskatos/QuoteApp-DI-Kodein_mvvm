package com.nfragiskatos.quoteapp_di_kodein_mvvm.data.repository

import androidx.lifecycle.LiveData
import com.nfragiskatos.quoteapp_di_kodein_mvvm.data.model.Quote

/**
 * Created by Nicholas Fragiskatos on 4/18/2020.
 */
interface QuoteRepository {
    fun addQuote(quote: Quote)
    fun getQuotes(): LiveData<List<Quote>>
}