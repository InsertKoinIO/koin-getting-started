package org.koin.sample

import org.koin.core.module.dsl.bind
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module

// Constructor DSL
val helloModule = module {
    singleOf(::HelloMessageData)
    singleOf(::HelloServiceImpl) { bind<HelloService>() }
}

// Classic DSL
//val helloModule = module {
//    single { HelloMessageData() }
//    single<HelloService> { HelloServiceImpl(get()) }
//}