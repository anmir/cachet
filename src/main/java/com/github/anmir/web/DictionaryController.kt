package com.github.anmir.web

import com.github.anmir.cache.api.DictionaryItem
import com.github.anmir.cache.api.DictionaryService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/dictionaries")
class DictionaryController {

    @Autowired
    lateinit var dictionaryService: DictionaryService

    @GetMapping("/{id}")
    fun getById(@PathVariable id: Int): DictionaryItem? {
        return dictionaryService.getById(id)
    }

    @GetMapping("/all")
    fun getAll(): List<DictionaryItem> {
        return dictionaryService.getAll()
    }

    @PostMapping("/clearCache")
    fun clearCache() {
        return dictionaryService.clearCache()
    }

}