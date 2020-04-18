package com.nfragiskatos.quoteapp_di_kodein_mvvm.ui.quotes

import androidx.lifecycle.ViewModel
import com.nfragiskatos.quoteapp_di_kodein_mvvm.data.model.Quote
import com.nfragiskatos.quoteapp_di_kodein_mvvm.data.repository.QuoteRepository

/**
 * Created by Nicholas Fragiskatos on 4/18/2020.
 */
class QuotesViewModel(private val quoteRepository: QuoteRepository) : ViewModel() {

    fun addQuote(quote: Quote) = quoteRepository.addQuote(quote)
    fun getQuotes() = quoteRepository.getQuotes()
}