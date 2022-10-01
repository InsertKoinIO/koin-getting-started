package org.koin.sample

import org.koin.core.module.dsl.bind
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module

val helloAppModule = module {
    singleOf(::HelloServiceImpl) { bind<HelloService>() }
    singleOf(::HelloRepository)
}
