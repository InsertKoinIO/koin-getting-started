plugins {
    alias(libs.plugins.kotlinJvm)
    application
}

dependencies {
    // Koin dependencies
    implementation(libs.koin.core)
    // Koin testing
    testImplementation(libs.koin.test)
    testImplementation(libs.koin.test.junit)
    testImplementation(libs.mockito)
}

application {
    // Define the main class for the application
    mainClass.set("org.koin.sample.UserApplicationKt")
}

java {
    // Use Java 17 for compilation
    toolchain.languageVersion.set(JavaLanguageVersion.of(17))
}
