plugins {
    alias(libs.plugins.kotlinJvm)
    alias(libs.plugins.ksp)
    application
}

dependencies {
    // Koin dependencies
    implementation(libs.koin.core)
    implementation(libs.koin.annotations)
    implementation(libs.koin.jsr330)
    ksp(libs.koin.ksp)

    // Koin testing
    testImplementation(libs.koin.test)
    testImplementation(libs.koin.test.junit)
    testImplementation(libs.mockito)
}

application {
    // Define the main class for the application
    mainClass.set("org.koin.sample.UserApplicationKt")
}

ksp {
    arg("KOIN_CONFIG_CHECK", "true")
}

java {
    // Use Java 17 for compilation
    toolchain.languageVersion.set(JavaLanguageVersion.of(17))
}
