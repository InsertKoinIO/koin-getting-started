package org.koin.sample

import org.junit.Test
import org.junit.experimental.categories.Category
import org.koin.test.AutoCloseKoinTest
import org.koin.test.category.CheckModuleTest
// generated
import org.koin.ksp.generated.*
import org.koin.sample.di.AppModule
import org.koin.test.verify.verify

/**
 * Dry run configuration
 */
@Category(CheckModuleTest::class)
class ModuleCheckTest : AutoCloseKoinTest() {

    // Not needed if KOIN_CONFIG_CHECK is activated
//    @Test
    fun checkModules(){
        AppModule().module.verify()
    }
}