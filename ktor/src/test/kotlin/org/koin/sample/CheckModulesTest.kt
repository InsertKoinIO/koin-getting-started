package org.koin.sample

import org.junit.Test
import org.koin.sample.di.appModule
import org.koin.test.verify.verify

class CheckModulesTest {

    @Test
    fun `check modules`(){
        appModule.verify()
    }
}