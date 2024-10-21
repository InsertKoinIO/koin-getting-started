package org.koin.sample

import org.junit.Test
import org.koin.android.test.verify.androidVerify
import org.koin.sample.di.appModule
import org.koin.test.KoinTest

class CheckModulesTest : KoinTest {

    @Test
    fun checkAllModules(){
        appModule.androidVerify()
    }
}