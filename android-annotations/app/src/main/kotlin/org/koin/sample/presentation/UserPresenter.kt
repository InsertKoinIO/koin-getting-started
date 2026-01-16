package org.koin.sample.presentation

import org.koin.core.annotation.ViewModelScope
import org.koin.sample.service.UserService

/**
 * Presenter for managing user-related presentation logic using the MVP pattern.
 *
 * This presenter is injected via Koin using factory scope, meaning a new instance
 * is created each time it's requested. This is different from the singleton-scoped
 * services and repository.
 *
 * @property userService The service layer for user operations
 */
@ViewModelScope
class UserPresenter(
    private val userService: UserService
)  {

    /**
     * Generates a greeting message for a user by their name.
     * Prefixes the message with "[UserPresenter]" to identify the source.
     *
     * @param name The name of the user to greet
     * @return A formatted greeting message with the Presenter identifier
     */
    fun sayHello(name : String) : String{
        val user = userService.getUserOrNull(name)
        val message = userService.prepareHelloMessage(user)
        return "[UserPresenter] $message"
    }
}