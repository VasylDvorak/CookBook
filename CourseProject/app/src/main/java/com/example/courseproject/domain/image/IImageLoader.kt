package com.example.courseproject.domain.image

interface IImageLoader<T> {
    fun loadInto(url: String, container: T)
}
