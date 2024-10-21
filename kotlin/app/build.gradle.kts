val koinVersion = "4.0.0"

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
    // Align versions of all Kotlin components
    implementation(platform("org.jetbrains.kotlin:kotlin-bom"))
    // Use the Kotlin JDK 8 standard library
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")

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
