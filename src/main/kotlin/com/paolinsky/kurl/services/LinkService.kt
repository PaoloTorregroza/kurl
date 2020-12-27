package com.paolinsky.kurl.services

import com.paolinsky.kurl.entities.Link
import com.paolinsky.kurl.repositories.LinkRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.util.*

@Service
class LinkService(
    @Autowired
    private val linkRepository: LinkRepository
) : ILinkService {
    override fun fiById(id: String): Optional<Link> {
        return linkRepository.findById(id)
    }

    override fun save(link: Link): Link {
        return linkRepository.save(link)
    }

    override fun getAll(): MutableIterable<Link> {
        return linkRepository.findAll()
    }
}