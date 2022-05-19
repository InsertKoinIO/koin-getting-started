package org.koin.sample

import io.ktor.client.request.*
import io.ktor.client.statement.*
import io.ktor.http.HttpStatusCode
import io.ktor.server.testing.*
import org.junit.Test
import org.koin.test.AutoCloseKoinTest
import kotlin.test.assertEquals

class ApplicationJobRoutesTest : AutoCloseKoinTest() {

    @Test
    fun testHelloRequest() = testApplication {
        val response = client.get("/hello")
        assertEquals(HttpStatusCode.OK, response.status)
        assert(response.bodyAsText().contains("Hello Ktor & Koin!"))

        assertEquals(HttpStatusCode.NotFound, client.get("/").status)
    }
}
