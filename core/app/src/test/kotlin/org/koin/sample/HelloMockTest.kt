package org.koin.sample

import org.junit.Rule
import org.junit.Test
import org.koin.core.logger.Level
import org.koin.sample.data.User
import org.koin.sample.di.userModule
import org.koin.sample.service.UserService
import org.koin.test.KoinTest
import org.koin.test.KoinTestRule
import org.koin.test.mock.MockProviderRule
import org.koin.test.mock.declareMock
import org.mockito.BDDMockito.given
import org.mockito.Mockito
import org.mockito.Mockito.times

class HelloMockTest : KoinTest {

    @get:Rule
    val koinTestRule = KoinTestRule.create {
        printLogger(Level.DEBUG)
        modules(userModule)
    }

    @get:Rule
    val mockProvider = MockProviderRule.create { clazz ->
        Mockito.mock(clazz.java)
    }

    @Test
    fun `mock test`() {
        val service = declareMock<UserService> {
            given(getDefaultUser()).willReturn(User("MOCK"))
        }

        UserApplication().sayHello()

        Mockito.verify(service,times(1)).getDefaultUser()
    }
}