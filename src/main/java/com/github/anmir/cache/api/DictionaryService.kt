package com.github.anmir.cache.api

interface DictionaryService {

    fun getById(id: Int): DictionaryItem?

    fun getAll(): List<DictionaryItem>

    fun clearCache()

}