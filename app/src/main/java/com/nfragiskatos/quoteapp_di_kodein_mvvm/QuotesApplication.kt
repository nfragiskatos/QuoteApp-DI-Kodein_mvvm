package com.nfragiskatos.quoteapp_di_kodein_mvvm

import android.app.Application
import com.nfragiskatos.quoteapp_di_kodein_mvvm.data.db.Database
import com.nfragiskatos.quoteapp_di_kodein_mvvm.data.db.DatabaseFakeImpl
import com.nfragiskatos.quoteapp_di_kodein_mvvm.data.db.QuoteDao
import com.nfragiskatos.quoteapp_di_kodein_mvvm.data.repository.QuoteRepository
import com.nfragiskatos.quoteapp_di_kodein_mvvm.data.repository.QuoteRepositoryImpl
import com.nfragiskatos.quoteapp_di_kodein_mvvm.ui.quotes.QuotesViewModelFactory
import org.kodein.di.Kodein
import org.kodein.di.KodeinAware
import org.kodein.di.generic.bind
import org.kodein.di.generic.instance
import org.kodein.di.generic.provider
import org.kodein.di.generic.singleton

/**
 * Created by Nicholas Fragiskatos on 4/18/2020.
 */
class QuotesApplication : Application(), KodeinAware {
    override val kodein = Kodein.lazy {
        bind<Database>() with singleton { DatabaseFakeImpl() }
        bind<QuoteDao>() with singleton { instance<Database>().quoteDao }
        bind<QuoteRepository>() with singleton { QuoteRepositoryImpl(instance<QuoteDao>()) }
        bind() from provider { QuotesViewModelFactory(instance()) }
    }
}