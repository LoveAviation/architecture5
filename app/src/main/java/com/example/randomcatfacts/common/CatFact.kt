package com.example.randomcatfacts.common

data class CatFact(
    val photo: String, // это мы получим от модуля list, должен быть url
    val fact: String // это мы получим от модуля details, просто факт, как текст
)