enableFeaturePreview("TYPESAFE_PROJECT_ACCESSORS")
pluginManagement {
    repositories {
        google()
        gradlePluginPortal()
        mavenCentral()
        mavenLocal()
    }
}

dependencyResolutionManagement {
    repositories {
        google()
        mavenCentral()
        mavenLocal()
    }
    versionCatalogs {
        create("sharedLibs") {
            from(files("../gradle/libs.versions.toml"))
        }
    }
}

rootProject.name = "KoinAndroidApp"
include(":app")
