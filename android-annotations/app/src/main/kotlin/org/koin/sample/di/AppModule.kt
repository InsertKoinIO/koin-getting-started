package org.koin.sample.di

import org.koin.core.annotation.ComponentScan
import org.koin.core.annotation.Module
import org.koin.library.sample.LibraryModule

@Module(includes = [LibraryModule::class])
@ComponentScan("org.koin.sample")
class AppModule