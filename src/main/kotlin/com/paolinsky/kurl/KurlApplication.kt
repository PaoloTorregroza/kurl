package com.paolinsky.kurl

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class KurlApplication

fun main(args: Array<String>) {
	runApplication<KurlApplication>(*args)
}
