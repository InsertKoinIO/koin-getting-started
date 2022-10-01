package org.koin.sample

import org.junit.Test
import org.koin.sample.di.appModule
import org.koin.test.check.checkModules

class CheckModulesTest {

    @Test
    fun `check modules`() = checkModules {
        modules(appModule)
    }
}