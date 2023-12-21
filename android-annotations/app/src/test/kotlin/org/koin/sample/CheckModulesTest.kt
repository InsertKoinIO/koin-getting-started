package org.koin.sample

// generated
import org.junit.Test
import org.junit.experimental.categories.Category
import org.koin.android.test.verify.androidVerify
import org.koin.ksp.generated.*
import org.koin.sample.di.AppModule
import org.koin.test.KoinTest
import org.koin.test.category.CheckModuleTest

@Category(CheckModuleTest::class)
class CheckModulesTest : KoinTest {

    // Not needed with KOIN_CONFIG_CHECK
//    @Test
    fun checkAllModules() {
        AppModule().module.androidVerify()
    }
}