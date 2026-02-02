enableFeaturePreview("TYPESAFE_PROJECT_ACCESSORS")
pluginManagement {
    repositories {
        mavenLocal()
        google()
        gradlePluginPortal()
        mavenCentral()
    }
}

dependencyResolutionManagement {
    repositories {
        mavenLocal()
        google()
        mavenCentral()
    }
    versionCatalogs {
        create("sharedLibs") {
            from(files("../gradle/libs.versions.toml"))
        }
    }
}

rootProject.name = "KoinAndroidAnnotationsApp"
include(":app")
