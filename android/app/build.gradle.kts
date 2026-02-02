plugins {
    alias(sharedLibs.plugins.android.application)
    alias(sharedLibs.plugins.kotlin.android)
    alias(sharedLibs.plugins.koin)
}

android {
    namespace = "org.koin.sample"
    compileSdk = 36
    defaultConfig {
        applicationId = "org.koin.sample"
        minSdk = 24
        versionCode = 1
        versionName = "1.0"
    }
    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
}

koinCompiler {
    userLogs = true
}

dependencies {
    implementation(libs.android.appcompat)
    implementation(sharedLibs.koin.android)

    testImplementation(sharedLibs.koin.test.junit4)
    testImplementation(sharedLibs.koin.android.test)
    testImplementation(libs.mockito)
}