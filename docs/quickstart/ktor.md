---
title: Ktor
---

> Ktor is a framework for building asynchronous servers and clients in connected systems using the powerful Kotlin programming language. We will use Ktor here, to build a simple web application.

Let's go with the following components to chain : a Controller, a Service and a Repository.

```kotlin
Ktor Controller (http) -> Service (business) -> Repository (data)
```

- a Ktor Controller (routing function) to handle http route and return result from the service
- a Service to *handle business* and take data from repository
- a Repository to provide data

Let's go 🚀

## Get the code

:::info
[The source code is available at on Github](https://github.com/InsertKoinIO/koin/tree/3.0.1/quickstart/getting-started-koin-ktor)
:::

## Gradle Setup

First, add the Koin dependency like below:

```kotlin
// Add Maven Central to your repositories if needed
repositories {
	mavenCentral()    
}
dependencies {
    // Koin for Kotlin apps
    compile "io.insert-koin:koin-ktor:$koin_version"
}
```

## Service & Repository

Let's write our Service, a component that will ask Repository for data:

```kotlin
interface HelloService {
    fun sayHello(): String
}

class HelloServiceImpl(val helloRepository: HelloRepository) : HelloService {
    override fun sayHello() = "Hello ${helloRepository.getHello()} !"
}
```

and our Repository, which provide data:

```kotlin
class HelloRepository {
    override fun getHello(): String = "Ktor & Koin"
}
```

## HTTP Controller

Finally, we need an HTTP Controller to create the HTTP Route. In Ktor is will be expressed through an Ktor extension function:

```kotlin
fun Application.main() {
    // Install Ktor features
    install(DefaultHeaders)
    install(CallLogging)

    // Lazy inject HelloService
    val service: HelloService by inject()

    // Routing section
    routing {
        get("/hello") {
            call.respondText(service.sayHello())
        }
    }
}
```

Check that your `application.conf` is configured like below, to help start the `Application.main` function:

```kotlin
ktor {
    deployment {
        port = 8080

        // For dev purpose
        //autoreload = true
        //watch = [org.koin.sample]
    }

    application {
        modules = [ org.koin.sample.HelloApplicationKt.main ]
    }
}
```

## Declare your dependencies

Let's assemble our components with a Koin module:

```kotlin
val helloAppModule = module {
    single<HelloService> { HelloServiceImpl(get()) } // get() Will resolve HelloRepository
    single { HelloRepository() }
}
```

## Start and Inject

Finally, let's start Koin from Ktor:

```kotlin
fun Application.main() {
    // Install Ktor features
    install(DefaultHeaders)
    install(CallLogging)
    // Declare Koin
    install(Koin) {
        SLF4JLogger()
        modules(helloAppModule)
    }

    // Lazy inject HelloService
    val service: HelloService by inject()

    // Routing section
    routing {
        get("/hello") {
            call.respondText(service.sayHello())
        }
    }
}
```

Let's start Ktor:

```kotlin
fun main(args: Array<String>) {
    // Start Ktor
    embeddedServer(Netty, commandLineEnvironment(args)).start()
}
```

That's it! You're ready to go. Check the `http://localhost:8080/hello` url!
