plugins {
    alias(sharedLibs.plugins.kotlin.jvm)
    application
    alias(sharedLibs.plugins.koin)
}

dependencies {
    // Koin dependencies
    implementation(sharedLibs.koin.core)
    implementation(sharedLibs.koin.annotations)

    // Koin testing
    testImplementation(sharedLibs.koin.test)
    testImplementation(sharedLibs.koin.test.junit4)
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
