package org.koin.sample

import org.junit.Test
import org.junit.experimental.categories.Category
import org.koin.sample.di.appModule
import org.koin.test.KoinTest
import org.koin.test.category.CheckModuleTest
import org.koin.test.verify.verify

@Category(CheckModuleTest::class)
class CheckModulesTest : KoinTest {

    @Test
    fun checkAllModules(){
        appModule.verify()
    }
}