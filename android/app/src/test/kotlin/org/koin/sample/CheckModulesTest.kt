package org.koin.sample

import org.junit.Test
import org.koin.android.test.verify.androidVerify
import org.koin.sample.di.appModule
import org.koin.test.KoinTest

/**
 * Test class for verifying Koin module configurations.
 *
 * This test ensures that all dependencies defined in the Koin modules
 * can be properly instantiated and resolved without runtime errors.
 */
class CheckModulesTest : KoinTest {

    /**
     * Verifies that the application module is correctly configured.
     *
     * Uses Koin's [androidVerify] to check that all definitions in [appModule]
     * can be resolved and instantiated without circular dependencies or missing definitions.
     * This test helps catch configuration issues early in the development cycle.
     */
    @Test
    fun checkAllModules() {
        appModule.androidVerify()
    }
}