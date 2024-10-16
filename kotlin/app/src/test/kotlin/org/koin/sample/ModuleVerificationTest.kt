package org.koin.sample

import org.junit.Test
import org.koin.sample.di.appModule
import org.koin.test.AutoCloseKoinTest
import org.koin.test.verify.verify

/**
 * Dry run configuration
 */
class ModuleVerificationTest : AutoCloseKoinTest() {

    @Test
    fun verifyModules() {
        appModule.verify()
    }
}