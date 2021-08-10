package com.circle.`in`.webcrawler

import com.circle.`in`.webcrawler.dto.SearchResultDto
import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.web.client.TestRestTemplate
import org.springframework.boot.web.server.LocalServerPort
import org.springframework.core.ParameterizedTypeReference
import org.springframework.http.HttpMethod
import org.springframework.http.ResponseEntity
import java.net.URI

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class WebCrawlerApplicationTests(
    @Autowired private val restTemplate: TestRestTemplate,
) {
    @LocalServerPort
    var randomServerPort = 0

    @Test
    fun `should return matching word count in response`() {
        val baseUrl = "http://localhost:$randomServerPort/api/mentions/count?word=tech&url=https%3A%2F%2Fmartinfowler.com%2F"

        val result: ResponseEntity<SearchResultDto> = restTemplate.exchange(
            URI(baseUrl),
            HttpMethod.GET,
            null,
            object : ParameterizedTypeReference<SearchResultDto>() {}
        )

        val body = result.body
        body!! shouldBe SearchResultDto(count = 11, word = "tech")

    }

}
