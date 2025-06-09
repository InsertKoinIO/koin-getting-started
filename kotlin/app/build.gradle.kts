val koinVersion = "4.1.0"

plugins {
    val kotlinVersion = "2.1.20"
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
    // Koin dependencies
    implementation("io.insert-koin:koin-core:$koinVersion")
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
