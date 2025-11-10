package org.koin.sample.di

import org.koin.core.annotation.ComponentScan
import org.koin.core.annotation.Configuration
import org.koin.core.annotation.KoinApplication
import org.koin.core.annotation.Module

/**
 * Main Koin dependency injection configuration module.
 *
 * This module uses component scanning to automatically discover and register
 * all components annotated with Koin annotations (e.g., @Singleton) within
 * the "org.koin.sample" package and its subpackages.
 *
 * The [@Module] annotation marks this as a Koin module.
 * The [@ComponentScan] annotation enables automatic discovery of dependencies.
 * The [@Configuration] annotation indicates this is a configuration class.
 */
@Module
@ComponentScan("org.koin.sample")
@Configuration
class AppModule