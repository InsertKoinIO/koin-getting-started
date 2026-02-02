plugins {
    alias(sharedLibs.plugins.android.application)
    alias(sharedLibs.plugins.kotlin.android)
    alias(sharedLibs.plugins.kotlin.compose)
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
//    kotlinOptions {
//        jvmTarget = "17"
//    }
    buildFeatures {
        compose = true
    }
}

dependencies {
    implementation(libs.android.appcompat)
    implementation(sharedLibs.koin.android)
    implementation(sharedLibs.koin.androidx.compose)

    // Compose BOM
    implementation(platform(libs.compose.bom))
    implementation(libs.compose.ui)
    implementation(libs.compose.ui.tooling.preview)
    implementation(libs.compose.material3)
    implementation(libs.compose.activity)
    implementation(libs.compose.lifecycle.viewmodel)
    implementation(libs.compose.lifecycle.runtime)

    // Debug
    debugImplementation(libs.compose.ui.tooling)

    testImplementation(sharedLibs.koin.test.junit4)
    testImplementation(sharedLibs.koin.android.test)
    testImplementation(libs.mockito)
}