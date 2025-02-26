package org.koin.library.sample

import android.content.Context
import org.koin.core.annotation.ComponentScan
import org.koin.core.annotation.Module
import org.koin.core.annotation.Single

@Module
@ComponentScan
class LibraryModule {

    @Single
    fun libraryContextHolder(context: Context) = LibraryContextHolder(context)
}