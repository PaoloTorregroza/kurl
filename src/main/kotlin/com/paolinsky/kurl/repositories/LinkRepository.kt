package com.paolinsky.kurl.repositories

import com.paolinsky.kurl.entities.Link
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface LinkRepository : CrudRepository<Link, String>