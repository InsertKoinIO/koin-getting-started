plugins {
    //trick: for the same plugin versions in all sub-modules
    alias(sharedLibs.plugins.android.application) apply false
    alias(sharedLibs.plugins.android.library) apply false
    alias(sharedLibs.plugins.kotlin.android) apply false
    alias(sharedLibs.plugins.koin) apply false
}