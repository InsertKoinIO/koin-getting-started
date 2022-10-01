package org.koin.sample

import org.junit.Test
import org.junit.experimental.categories.Category
import org.koin.test.AutoCloseKoinTest
import org.koin.test.category.CheckModuleTest
import org.koin.test.check.checkModules
// generated
import org.koin.ksp.generated.*
import org.koin.sample.di.AppModule

/**
 * Dry run configuration
 */
@Category(CheckModuleTest::class)
class ModuleCheckTest : AutoCloseKoinTest() {

    @Test
    fun checkModules() = checkModules {
        modules(AppModule().module)
    }
}