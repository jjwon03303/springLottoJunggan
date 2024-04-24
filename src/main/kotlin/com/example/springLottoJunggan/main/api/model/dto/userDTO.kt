package com.example.springLottoJunggan.main.api.model.dto

data class userDTO(
    val email: String,
    val password: String,

    )

data class userDTORequest(
    val email: String,
    val password: String,
)
