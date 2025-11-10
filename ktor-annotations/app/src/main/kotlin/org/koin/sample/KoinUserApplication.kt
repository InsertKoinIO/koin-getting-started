package org.koin.sample

import io.ktor.server.application.*
import io.ktor.server.engine.embeddedServer
import io.ktor.server.netty.Netty
import io.ktor.server.response.*
import io.ktor.server.routing.*
import org.koin.core.annotation.KoinApplication
import org.koin.dsl.includes
import org.koin.ksp.generated.koinConfiguration
import org.koin.ksp.generated.startKoin
import org.koin.ktor.ext.inject
import org.koin.ktor.plugin.Koin
import org.koin.sample.service.UserService

/**
 * Koin application configuration object.
 *
 * This object is annotated with [@KoinApplication] to mark it as the entry point
 * for Koin's annotation-based configuration. The Koin KSP (Kotlin Symbol Processing)
 * processor generates a [startKoin] extension function for this object, which
 * initializes the Koin dependency injection container with all discovered components.
 */
@KoinApplication
object KoinUserApplication

/**
 * Application entry point that starts the Ktor server.
 *
 * Configures and starts an embedded Netty server on port 8080 with the main application module.
 * The server runs in blocking mode (wait = true) to keep the application alive.
 *
 * @param args Command line arguments (not currently used)
 */
fun main(args: Array<String>) {
    embeddedServer(Netty, port = 8080) {
        main()
    }.start(wait = true)
}

/**
 * Main application module that configures Koin dependency injection and application routing.
 *
 * This extension function sets up:
 * - Koin DI framework with SLF4J logging
 * - Application module with all dependencies
 * - User data initialization
 * - HTTP routing endpoints
 */
fun Application.main() {

    // Configure Koin dependency injection
    install(Koin){
        includes(KoinUserApplication.koinConfiguration())
    }

    // Inject UserService and initialize with default users
    val service by inject<UserService>()
    service.loadUsers()

    // Define application routes
    routing {
        /**
         * GET /hello endpoint that returns a personalized greeting.
         * Query parameter: name (optional, defaults to "Alice")
         * Response: Greeting message with user details or error if user not found
         */
        get("/hello") {
            val userName = this.call.queryParameters["name"] ?: "Alice"
            val user = service.getUserOrNull(userName)
            val message = service.prepareHelloMessage(user)
            call.respondText(message)
        }
    }
}