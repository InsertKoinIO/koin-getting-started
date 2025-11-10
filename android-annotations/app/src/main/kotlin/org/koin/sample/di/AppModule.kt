package org.koin.sample.di

import org.koin.core.annotation.ComponentScan
import org.koin.core.annotation.Configuration
import org.koin.core.annotation.Module

/**
 * Main Koin module for the application using annotation-based configuration.
 *
 * This module is configured with:
 * - [@Module] - Marks this class as a Koin module
 * - [@ComponentScan] - Automatically discovers and registers all classes annotated with
 *   Koin annotations (@Single, @Factory, @KoinViewModel) in the "org.koin.sample" package
 * - [@Configuration] - Enables advanced configuration features and automatic module discovery
 *
 * When combined with [@KoinApplication] on the Application class, modules are automatically
 * loaded without needing to manually call `modules(AppModule().module)`.
 */
@Module
@ComponentScan("org.koin.sample")
@Configuration
class AppModule