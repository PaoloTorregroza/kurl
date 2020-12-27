package com.paolinsky.kurl.controllers

import com.paolinsky.kurl.entities.Link
import com.paolinsky.kurl.repositories.LinkRepository
import com.paolinsky.kurl.services.LinkService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.ModelAttribute
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import javax.servlet.http.HttpServletResponse
import kotlin.random.Random

@Controller
class UrlFormController(
    @Autowired
    private val linkService: LinkService
) {

    private val charPool = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890abcdefghijklmnopqrstuvwxyz"

    @GetMapping("/")
    fun urlForm(model: Model): String {
        model.addAttribute("link", Link())
        return "urlForm"
    }

    @GetMapping("/sl/{slug}")
    fun redirectToUrl(
        @PathVariable(value="slug")
        slug: String,
        httpServletResponse: HttpServletResponse
    ) {
        val redirectUrl = linkService.fiById(slug) .get().url
        httpServletResponse.setHeader("Location", redirectUrl)
        httpServletResponse.status = 302
    }

    @PostMapping("/")
    fun urlSubmit(@ModelAttribute("link") link: Link, model: Model): String {
        val slugs = mutableListOf<String>()
        linkService.getAll().forEach {
            slugs.add(it.slug ?: "")
        }

        if (link.slug.isNullOrBlank()) link.slug = generateSlug(slugs.toList())

        if (slugs.indexOf(link.slug) < 0) {
            linkService.save(link)
            model.addAttribute("url", link.url)
            model.addAttribute(
                "shortened",
                "http://localhost:8080/sl/${link.slug}"
            )
        }
        else
            model.addAttribute("errorMessage", "Slug already taken")

        model.addAttribute("link", Link())
        return "urlForm"
    }

    private fun generateSlug(takenSlugs: List<String>): String {
        var generated = false
        var slug = ""
        while (!generated) {
            slug = (1..6)
                .map { Random.nextInt(0, charPool.length) }
                .map(charPool::get)
                .joinToString("")

            if (takenSlugs.indexOf(slug) <= 0) generated = true
        }

        return slug
    }
}