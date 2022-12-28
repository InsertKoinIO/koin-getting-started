package org.koin.sample

import androidx.lifecycle.SavedStateHandle
import org.junit.Test
import org.junit.experimental.categories.Category
import org.koin.test.KoinTest
import org.koin.test.category.CheckModuleTest
// generated
import org.koin.ksp.generated.*
import org.koin.sample.di.AppModule
import org.koin.test.verify.verify

@Category(CheckModuleTest::class)
class CheckModulesTest : KoinTest {
    @Test
    fun checkAllModules() {
        AppModule().module.verify(extraTypes = listOf(
            SavedStateHandle::class
        ))
    }
}