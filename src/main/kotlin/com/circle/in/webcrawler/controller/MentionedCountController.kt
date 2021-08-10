package com.circle.`in`.webcrawler.controller

import com.circle.`in`.webcrawler.dto.SearchDto
import com.circle.`in`.webcrawler.dto.SearchResultDto
import com.circle.`in`.webcrawler.service.WebCrawlerService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
class MentionedCountController(@Autowired private val webCrawlerService: WebCrawlerService) {
    @GetMapping("/api/mentions/count")
    private fun countFor(
        @RequestParam url: String,
        @RequestParam word: String): SearchResultDto{
        return webCrawlerService mentionedCountFor SearchDto(url=url, word=word)
    }
}