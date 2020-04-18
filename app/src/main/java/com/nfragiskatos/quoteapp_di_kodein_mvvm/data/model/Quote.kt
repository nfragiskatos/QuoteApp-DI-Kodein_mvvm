package com.nfragiskatos.quoteapp_di_kodein_mvvm.data.model

/**
 * Created by Nicholas Fragiskatos on 4/18/2020.
 */
data class Quote(val text: String, val author: String) {

    override fun toString(): String {
        return "$text - $author"
    }
}