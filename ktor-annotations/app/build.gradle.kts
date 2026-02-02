plugins {
    alias(sharedLibs.plugins.kotlin.jvm)
    alias(sharedLibs.plugins.koin)
    application
}

dependencies {
    implementation(libs.ktor.server)
    implementation(libs.logback)
    implementation(sharedLibs.koin.ktor)
    implementation(sharedLibs.koin.annotations)
    implementation(sharedLibs.koin.logger.slf4j)

    testImplementation(libs.ktor.test)
    testImplementation(sharedLibs.koin.test)
    testImplementation(sharedLibs.koin.test.junit4)
    testImplementation(libs.mockito)
}

application {
    mainClass.set("org.koin.sample.UserApplicationKt")
}

java {
    toolchain.languageVersion.set(JavaLanguageVersion.of(17))
}
