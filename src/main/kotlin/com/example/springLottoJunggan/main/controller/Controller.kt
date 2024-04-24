package com.example.springLottoJunggan.main.api.model.dto

import com.example.springLottoJunggan.main.api.model.dto.TestDto
import com.example.springLottoJunggan.main.api.model.dto.TestDtoRequest
import com.example.springLottoJunggan.main.api.model.dto.bbDTO
import com.example.springLottoJunggan.main.api.model.dto.bbDtoRequest
import io.swagger.v3.oas.annotations.Parameter
import jakarta.validation.Valid
import net.datafaker.Faker
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.time.LocalDateTime
import java.util.*

@RestController
class Controller {

    private val user = mutableListOf<userDTO>()
    //유저 리스트 생성

    @GetMapping("/getUsers")
    fun getAlluserDTO(
        @RequestBody userDTORequest : userDTORequest):
            ResponseEntity<List<userDTO>> {
            val response = user
            return ResponseEntity.ok().body(response)
    }

    @GetMapping("/LoginCheckUsers")
    fun checkAlluserDTO(
        @RequestBody userDTORequest : userDTORequest):
            Int {
        val response = user
        // 안드로이드에서 처리해줘야할 일
        // val id : String = "email": "{etLogin.text.toString()}"
        // val pw : String = "password": "{etPw.text.toString()}"
        val id : String = "\"email\": \"test\"" // 아이디 테스팅 코드
        val pw : String = "\"password\": \"q1w2e3r4\"" // 비밀번호 테스팅 코드
        if (response.toString().contentEquals(id) && response.toString().contentEquals(pw)){
            return 0 // 성공!
        }
        return -1 // 실패

        //안드로이드에서 0일시 다음 화면으로, -1이라면 에러를 띄움
    }


//    private val tests = mutableListOf<bbDTO>()
//
//    @GetMapping("/test")
//    fun getAllbbDto(
//        @RequestBody testDtoRequest: TestDtoRequest
//    ): ResponseEntity<List<bbDTO>> {
//        val response = tests
//        return ResponseEntity.ok().body(response)
//    }
//
//    @PostMapping("/test")
//    fun postWrite(
//        @RequestBody bbDTORe: bbDtoRequest //bbDtoRequest로는 4개를 받아올 수 있음
//    ) : ResponseEntity<bbDTO> {
//        val bbDTOwrite = bbDTO( // 5개의 요소 삽입
//            num = bbDTORe.num,
//            title = bbDTORe.title,
//            detail = bbDTORe.detail,
//            writer = bbDTORe.writer,
//            time = LocalDateTime.now().toString() //자동으로 지금 시간을 time에  집어넣음
//        )
//        tests.add(bbDTOwrite) //tests라는 mutableListOf<bbDTO> 에 집어넣음
//        return ResponseEntity.ok().body(bbDTOwrite)
//    }

}