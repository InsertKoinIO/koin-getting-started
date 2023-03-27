package org.koin.sample

import org.junit.Test
import org.junit.experimental.categories.Category
import org.koin.core.annotation.KoinExperimentalAPI
import org.koin.sample.di.appModule
import org.koin.test.AutoCloseKoinTest
import org.koin.test.category.CheckModuleTest
import org.koin.test.verify.verify

/**
 * Dry run configuration
 */
@Category(CheckModuleTest::class)
@OptIn(KoinExperimentalAPI::class)
class ModuleVerificationTest : AutoCloseKoinTest() {

    @Test
    fun verifyModules() {
        appModule.verify()
    }
}