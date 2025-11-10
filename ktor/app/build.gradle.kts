plugins {
    alias(libs.plugins.kotlinJvm)
    application
}

dependencies {
    implementation(libs.ktor.server)
    implementation(libs.logback)
    implementation(libs.koin.ktor)
    implementation(libs.koin.ktor.slf4j)

    testImplementation(libs.ktor.test)
    testImplementation(libs.koin.test)
    testImplementation(libs.koin.test.junit)
    testImplementation(libs.mockito)
}

application {
    mainClass.set("org.koin.sample.UserApplicationKt")
}

java {
    toolchain.languageVersion.set(JavaLanguageVersion.of(17))
}
