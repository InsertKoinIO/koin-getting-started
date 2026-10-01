package org.koin.sample

import org.junit.Rule
import org.junit.Test
import org.koin.plugin.module.dsl.withConfiguration
import org.koin.sample.data.User
import org.koin.core.qualifier.TypeQualifier
import org.koin.sample.presentation.UserPresenter
import org.koin.sample.presentation.UserViewModel
import org.koin.sample.repository.UserRepository
import org.koin.test.KoinTest
import org.koin.test.KoinTestRule
import org.koin.test.mock.MockProviderRule
import org.koin.test.mock.declareMock
import org.mockito.ArgumentMatchers.anyString
import org.mockito.BDDMockito.given
import org.mockito.Mockito
import org.mockito.Mockito.times
import org.koin.viewmodel.scope.ViewModelScopeArchetype
import kotlin.jvm.java

/**
 * Test class for [UserPresenter] demonstrating Koin testing capabilities.
 *
 * This test class showcases:
 * - Using [KoinTestRule] to initialize Koin for testing
 * - Mocking dependencies with [MockProviderRule] and Mockito
 * - Testing dependency injection with mocked repositories
 */
class PresenterTest : KoinTest {

    /**
     * Koin test rule that initializes the Koin context for testing.
     * Configures debug logging and loads the application module.
     */
    @get:Rule
    val koinTestRule = KoinTestRule.create {
        withConfiguration<MainApplication>()
    }

    /**
     * Mock provider rule that configures Mockito as the mocking framework.
     * This rule enables Koin to create mock instances using Mockito.
     */
    @get:Rule
    val mockProvider = MockProviderRule.create { clazz -> Mockito.mock(clazz.java) }

    /**
     * Tests the application with a mocked UserRepository.
     *
     * This test demonstrates:
     * - Declaring a mock for [UserRepository] with stubbed behavior
     * - Running the application with the mocked dependency
     * - Verifying that the mocked repository method was called exactly once
     *
     * The test verifies that [UserRepository.findUserOrNull] is called when
     * [UserPresenter.sayHello] is invoked, as the call flows through UserService to UserRepository.
     */
    @Test
    fun `mock test`() {
        val service = declareMock<UserRepository> {
            given(findUserOrNull(anyString())).willReturn(User("Mock","mock@example.com"))
        }

        // UserPresenter is @ViewModelScope: resolve it from a ViewModel-archetype scope
        val viewModelScope = getKoin().createScope("test", TypeQualifier(UserViewModel::class), null, ViewModelScopeArchetype)
        viewModelScope.get<UserPresenter>().sayHello("Mock")
        Mockito.verify(service,times(1)).findUserOrNull(anyString())
    }
}