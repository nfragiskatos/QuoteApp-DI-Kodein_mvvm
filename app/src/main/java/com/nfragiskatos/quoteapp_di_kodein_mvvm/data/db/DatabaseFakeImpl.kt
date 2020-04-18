package com.nfragiskatos.quoteapp_di_kodein_mvvm.data.db

/**
 * Created by Nicholas Fragiskatos on 4/18/2020.
 */
class DatabaseFakeImpl : Database {
    override val quoteDao: QuoteDao = QuoteDaoFakeImpl()
}