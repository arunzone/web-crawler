package com.circle.`in`.webcrawler.service

import com.circle.`in`.webcrawler.dto.SearchDto
import com.circle.`in`.webcrawler.dto.SearchResultDto
import org.jsoup.Jsoup
import org.springframework.stereotype.Service

@Service
class WebCrawlerService {
    infix fun mentionedCountFor(search: SearchDto): SearchResultDto {
        val document = Jsoup.connect(search.url).get()
        val count = document
            .text()
            .split(" ")
            .count { it.contains(search.word, ignoreCase = true) }
        return SearchResultDto(count = count, word = search.word)
    }

}