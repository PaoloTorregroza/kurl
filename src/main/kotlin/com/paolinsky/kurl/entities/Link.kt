package com.paolinsky.kurl.entities

import javax.persistence.*

@Entity
data class Link (
    @Id
    @Column(unique = true)
    var slug: String? = null,
    @Column(nullable = false)
    var url: String? = null
)