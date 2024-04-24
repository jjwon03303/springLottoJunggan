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
import java.util.Random

@RestController
class Controller {

    private val user = mutableListOf<userDTO>()
    //유저 리스트 생성

    private val lotto = mutableListOf<lottoDTO>()
    //로또번호 리스트 생성

    @PostMapping("/registerUsers")
    fun registerUsers(
        @RequestBody userDTORe: userDTORequest
    ) : ResponseEntity<userDTO> {
        val userDTO = userDTO( // 5개의 요소 삽입
            //안드로이드에서 3개의 editText에서 값 받아오기 필요
            fullname = userDTORe.fullname,
            email = userDTORe.email,
            password = userDTORe.password,
        )
        user.add(userDTO)
        return ResponseEntity.ok().body(userDTO)
    }

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
        val email : String = "\"email\": \"test\"" // 아이디 테스팅 코드
        val pw : String = "\"password\": \"q1w2e3r4\"" // 비밀번호 테스팅 코드
        if (response.toString().contentEquals(email) && response.toString().contentEquals(pw)){
            return 0 // 성공!
        }
        return -1 // 실패

        //안드로이드에서 0일시 다음 화면으로, -1이라면 에러를 띄움
    }

    @PostMapping("/makelottoNumber")
    fun registerUsers(
        @RequestBody lottoDTO: lottoDTOReqeust
    ) : ResponseEntity<lottoDTO> {
        val lottoDTO = lottoDTO( //
            n1 = makeLottoNumber(),
            n2 = makeLottoNumber(),
            n3 = makeLottoNumber(),
            n4 = makeLottoNumber(),
            n5 = makeLottoNumber(),
            n6 = makeLottoNumber(),
            n7b = makeLottoNumber(),

            // ##### 각각 함수돌려서 중복인지 아닌지 알아보는건 귀찮으니까 그냥 7개중 중복이 있다면
            //7개 전부 다 그냥 다시한번 돌리는 함수 있어야 함
            //n1~n7을 리스트화시키고 그중 같은것이 있다면 while문을 빠져나가지 못하고
            //다시 한번 makeLottoNumber()을 7번 돌리는 구조

        )
        lotto.add(lottoDTO)
        return ResponseEntity.ok().body(lottoDTO)
    }

    fun makeLottoNumber() : Int { //45번으로 뽑는 로또번호 만들기 함수
        return kotlin.random.Random(45).toString().toInt()
    }

    @GetMapping("/getLottoNumber")
    fun getAllLottoDTO(
        @RequestBody lottoDTORe: lottoDTOReqeust):
            ResponseEntity<List<lottoDTO>> {
        val response = lotto
        return ResponseEntity.ok().body(response)
    }

    //https://lotto.minq.work/lotto/check
    // #####2 index마다 체크박스를 만들어야함. index+"회차" 로 생성됨
    // inder의 winningNumbers 내부의 number는 그 회차의 당첨번호이니 그 번호들을 뷰로 띄워야함
    // result가 각 6개의 열로 되어있음. 6개의 열을 전부 뿌려야 함
    // result의 내부의 7개 넘버를 각 열마다 뿌림.
    //만약 correctNumbers 내부의 numbers에 번호가 존재한다면 그 열의 그 번호는 색깔처리
    //각 열의 왼쪽 TextView는 result 내부로 tv.text = result 해줄것 (ex : "낙첨")


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