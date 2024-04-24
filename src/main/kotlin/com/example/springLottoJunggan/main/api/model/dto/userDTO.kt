package com.example.springLottoJunggan.main.api.model.dto

data class userDTO(
    val fullname : String,
    val email: String,
    val password: String,

    )

data class userDTORequest(
    val fullname : String,
    val email: String,
    val password: String,
)
