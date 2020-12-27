package com.paolinsky.kurl.services

import com.paolinsky.kurl.entities.Link
import java.util.*

interface ILinkService {
    fun fiById(id: String): Optional<Link>
    fun save(link: Link): Link
    fun getAll(): MutableIterable<Link>
}