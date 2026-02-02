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
        maven("https://maven.pkg.jetbrains.space/public/p/ktor/eap") {
            mavenContent {
                includeGroupAndSubgroups("io.ktor")
            }
        }
    }
    versionCatalogs {
        create("sharedLibs") {
            from(files("../gradle/libs.versions.toml"))
        }
    }
}

rootProject.name = "KtorKoinApp"
include(":app")
