package com.nfragiskatos.quoteapp_di_kodein_mvvm.ui.quotes

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.nfragiskatos.quoteapp_di_kodein_mvvm.data.repository.QuoteRepository

/**
 * Created by Nicholas Fragiskatos on 4/18/2020.
 */
class QuotesViewModelFactory(private val quotesRepository: QuoteRepository) : ViewModelProvider.NewInstanceFactory() {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return QuotesViewModel(quotesRepository) as T
    }
}