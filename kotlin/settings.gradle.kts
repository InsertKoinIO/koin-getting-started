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

rootProject.name = "KotlinKoinApp"
include(":app")
