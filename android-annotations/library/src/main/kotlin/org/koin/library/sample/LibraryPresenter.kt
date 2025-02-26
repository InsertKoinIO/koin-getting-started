package org.koin.library.sample

import org.koin.core.annotation.Factory

@Factory
class LibraryPresenter(
    val libraryFactory: LibraryFactory,
    val libraryContextHolder : LibraryContextHolder
) {

    fun getSharedIds() : String = "libraryFactory:${libraryFactory.id} with $libraryContextHolder"

}