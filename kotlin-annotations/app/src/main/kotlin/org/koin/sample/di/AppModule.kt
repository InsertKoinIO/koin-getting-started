package org.koin.sample.di

import org.koin.core.annotation.ComponentScan
import org.koin.core.annotation.Module
import org.koin.core.module.dsl.bind
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module
import org.koin.sample.service.UserService
import org.koin.sample.data.UserRepository
import org.koin.sample.data.UserRepositoryImpl

@Module
@ComponentScan("org.koin.sample")
class AppModule