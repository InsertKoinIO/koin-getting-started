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
}

rootProject.name = "KtorKoinApp"
include(":app")
