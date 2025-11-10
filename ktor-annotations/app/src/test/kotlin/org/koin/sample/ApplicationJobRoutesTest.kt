package org.koin.sample

import io.ktor.client.request.*
import io.ktor.client.statement.*
import io.ktor.http.HttpStatusCode
import io.ktor.server.testing.*
import org.junit.Test
import org.koin.test.AutoCloseKoinTest
import kotlin.test.assertEquals

/**
 * Integration test class for application routing endpoints.
 *
 * Extends [AutoCloseKoinTest] to ensure proper cleanup of Koin context after each test.
 * Tests the HTTP endpoints using Ktor's test application framework with full DI setup.
 */
class ApplicationJobRoutesTest : AutoCloseKoinTest() {

    /**
     * Tests the /hello endpoint with a query parameter.
     *
     * Verifies that:
     * - The /hello endpoint returns HTTP 200 OK
     * - The response body contains "Hello" text
     * - The root path (/) returns HTTP 404 Not Found (not configured)
     *
     * Uses the full application setup with Koin DI to ensure realistic testing conditions.
     */
    @Test
    fun testHelloRequest() = testApplication {
        application {
            main()
        }
        val response = client.get("/hello?name=Alice")
        assertEquals(HttpStatusCode.OK, response.status)
        assert(response.bodyAsText().contains("Hello"))

        assertEquals(HttpStatusCode.NotFound, client.get("/").status)
    }
}
