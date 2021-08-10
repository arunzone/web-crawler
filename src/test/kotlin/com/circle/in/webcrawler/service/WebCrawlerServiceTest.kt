package com.circle.`in`.webcrawler.service

import com.circle.`in`.webcrawler.dto.SearchDto
import com.circle.`in`.webcrawler.dto.SearchResultDto
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

internal class WebCrawlerServiceTest : StringSpec({
    val webCrawlerService = WebCrawlerService()

    "should return count of complete word 'agile' as 9" {
        val search = SearchDto(url = "https://martinfowler.com/", word = "agile")
        val count = webCrawlerService mentionedCountFor search
        count shouldBe SearchResultDto(count = 9, word = "agile")
    }

    "should return count of word contains 'tech' as 11" {
        val search = SearchDto(url = "https://martinfowler.com/", word = "tech")
        val count = webCrawlerService mentionedCountFor search
        count shouldBe SearchResultDto(count = 11, word = "tech")
    }
})