package org.koin.sample

import org.junit.Assert.assertEquals
import org.junit.Rule
import org.junit.Test
import org.koin.sample.di.userModule
import org.koin.sample.service.UserService
import org.koin.test.KoinTest
import org.koin.test.KoinTestRule
import org.koin.test.inject

class HelloAppTest : KoinTest {

    val service by inject<UserService>()

    @get:Rule
    val koinTestRule = KoinTestRule.create {
        printLogger()
        modules(userModule)
    }

    @Test
    fun `unit test`() {
        val helloApp = UserApplication()
        helloApp.sayHello()

        assertEquals(service, helloApp.userService)
    }
}