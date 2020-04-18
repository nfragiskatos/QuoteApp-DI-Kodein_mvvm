package com.nfragiskatos.quoteapp_di_kodein_mvvm.data.repository

import androidx.lifecycle.LiveData
import com.nfragiskatos.quoteapp_di_kodein_mvvm.data.db.QuoteDao
import com.nfragiskatos.quoteapp_di_kodein_mvvm.data.model.Quote

/**
 * Created by Nicholas Fragiskatos on 4/18/2020.
 */
class QuoteRepositoryImpl(private val quoteDao: QuoteDao) : QuoteRepository {
    override fun addQuote(quote: Quote) {
        quoteDao.addQuote(quote)
    }

    override fun getQuotes() = quoteDao.getQuotes()
}