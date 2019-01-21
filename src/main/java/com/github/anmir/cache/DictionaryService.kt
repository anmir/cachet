package com.github.anmir.cache

import com.github.anmir.cache.api.DictionaryItem
import com.github.anmir.cache.api.DictionaryService
import mu.KLogging
import org.springframework.cache.annotation.CacheConfig
import org.springframework.cache.annotation.CacheEvict
import org.springframework.cache.annotation.Cacheable
import org.springframework.stereotype.Service


@Service
@CacheConfig(cacheNames = ["items"])
class DictionaryService : DictionaryService {

    @Cacheable(value = ["id"])
    override fun getById(id: Int): DictionaryItem? {
        logger.info { "getById: $id" }
        return dictionaryItemsStore.find { it.id == id }
    }

    @Cacheable
    override fun getAll(): List<DictionaryItem> {
        logger.info { "getAll" }
        return dictionaryItemsStore
    }

    @CacheEvict(allEntries = true)
    override fun clearCache() {
        //nothing
    }

    private val dictionaryItemsStore = IntRange(0, 100).map { DictionaryItem(it, it.toString()) }

    companion object : KLogging()
}