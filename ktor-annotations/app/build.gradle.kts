val koinVersion = "4.0.2"
val koinAnnotationsVersion = "2.0.0"
val ktorVersion = "2.3.12"

plugins {
    val kotlinVersion = "2.0.21"
    val kspVersion = "2.0.21-1.0.28"
    // Apply the Kotlin JVM plugin
    kotlin("jvm") version kotlinVersion
    // Apply the application plugin for CLI application support
    application

    id("com.google.devtools.ksp") version kspVersion
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
    implementation("io.insert-koin:koin-annotations:$koinAnnotationsVersion")
    ksp("io.insert-koin:koin-ksp-compiler:$koinAnnotationsVersion")
    // Koin testing
    testImplementation("io.insert-koin:koin-test:$koinVersion")
    testImplementation("io.insert-koin:koin-test-junit4:$koinVersion")
    testImplementation("org.mockito:mockito-inline:4.8.0")
}

// Compile time check
ksp {
    arg("KOIN_CONFIG_CHECK","true")
}

application {
    // Define the main class for the application
    mainClass.set("org.koin.sample.UserApplication")
}

java {
    // Use Java 17 for compilation
    toolchain.languageVersion.set(JavaLanguageVersion.of(17))
}
