package org.koin.sample.presentation

import androidx.lifecycle.ViewModel
import org.koin.sample.service.UserService

/**
 * ViewModel for managing user-related UI state and presentation logic.
 *
 * This ViewModel is injected via Koin and follows Android's ViewModel lifecycle,
 * surviving configuration changes such as screen rotations.
 *
 * @property userService The service layer for user operations
 */
class UserViewModel(
    private val userService: UserService
) : ViewModel() {

    /**
     * Generates a greeting message for a user by their name.
     * Prefixes the message with "[UserViewModel]" to identify the source.
     *
     * @param name The name of the user to greet
     * @return A formatted greeting message with the ViewModel identifier
     */
    fun sayHello(name : String) : String{
        val user = userService.getUserOrNull(name)
        val message = userService.prepareHelloMessage(user)
        return "[UserViewModel] $message"
    }
}