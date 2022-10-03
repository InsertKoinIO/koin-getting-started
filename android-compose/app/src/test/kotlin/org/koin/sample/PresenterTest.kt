package org.koin.sample

import org.junit.After
import org.junit.Assert.assertTrue
import org.junit.Rule
import org.junit.Test
import org.koin.core.context.stopKoin
import org.koin.core.logger.Level
import org.koin.sample.data.DefaultData
import org.koin.sample.data.UserRepository
import org.koin.test.KoinTest
import org.koin.test.KoinTestRule
import org.koin.test.get
import org.koin.test.inject
import org.koin.test.mock.MockProviderRule
import org.koin.test.mock.declareMock
import org.mockito.Mockito
import org.mockito.Mockito.times
import org.mockito.Mockito.verify
import org.koin.sample.di.appModule

class PresenterTest : KoinTest {

    val userRepository : UserRepository by inject()

    @get:Rule
    val mockProvider = MockProviderRule.create { clazz ->
        Mockito.mock(clazz.java)
    }

    @get:Rule
    val koinTestRule = KoinTestRule.create {
        printLogger(Level.DEBUG)
        modules(appModule)
    }

    val presenter: UserStateHolder by inject()

    @After
    fun after() {
        stopKoin()
    }

    @Test
    fun `say hello`() {
        userRepository.addUsers(DefaultData.DEFAULT_USERS)
        // reuse the lazy injected presenter
        assertTrue(presenter.sayHello(DefaultData.DEFAULT_USER.name).contains("Hello"))
    }

    @Test
    fun `say hello with mock`() {
        val mock = declareMock<UserRepository>()

        // retrieve actual presenter (injected with mock)
        val presenter = get<UserStateHolder>()
        val name = DefaultData.DEFAULT_USER.name
        presenter.sayHello(name)
        verify(mock, times(1)).findUser(name)
    }
}