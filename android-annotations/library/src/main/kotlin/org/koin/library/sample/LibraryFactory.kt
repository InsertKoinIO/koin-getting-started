package org.koin.library.sample

import org.koin.core.annotation.Factory
import java.util.UUID

@Factory
class LibraryFactory {
    val id : String = UUID.randomUUID().toString()
}