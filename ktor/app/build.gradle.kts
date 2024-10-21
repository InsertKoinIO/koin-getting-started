val koinVersion = "4.0.0"
val ktorVersion = "2.3.12"

plugins {
    val kotlinVersion = "2.0.20"
    // Apply the Kotlin JVM plugin
    kotlin("jvm") version kotlinVersion
    // Apply the application plugin for CLI application support
    application
}

repositories {
    mavenCentral()
    mavenLocal()
}

dependencies {
    implementation("io.ktor:ktor-server-netty:$ktorVersion")
    testImplementation("io.ktor:ktor-server-test-host:$ktorVersion")
    // Logging
    implementation("ch.qos.logback:logback-classic:1.4.12")
    // Koin dependencies
    implementation("io.insert-koin:koin-ktor:$koinVersion")
    implementation("io.insert-koin:koin-logger-slf4j:$koinVersion")
    // Koin testing
    testImplementation("io.insert-koin:koin-test:$koinVersion")
    testImplementation("io.insert-koin:koin-test-junit4:$koinVersion")
    testImplementation("org.mockito:mockito-inline:4.8.0")
}

application {
    // Define the main class for the application
    mainClass.set("org.koin.sample.UserApplication")
}

java {
    // Use Java 17 for compilation
    toolchain.languageVersion.set(JavaLanguageVersion.of(17))
}
