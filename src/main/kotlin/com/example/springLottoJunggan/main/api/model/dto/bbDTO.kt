package com.example.springLottoJunggan.main.api.model.dto

data class bbDTO (
    val num: Int,
    val title: String,
    val detail: String,
    val writer: String? = null,
    val time: String,
)


data class bbDtoRequest(
    val num: Int,
    val title: String,
    val detail: String,
    val writer: String? = null,
)