package com.hungry.githubaacstudy.ui.networktest

import io.reactivex.Single
import retrofit2.http.Body
import retrofit2.http.POST

// 서버에서 호출할 메서드를 선언하는 인터페이스
// POST 방식으로 데이터를 주고 받을 때 넘기는 변수는 Field라고 해야한다.
interface SearchAPI {

//    @POST("/ajax/app_token_save")
//    fun requestSingle(@Body params: ReqVOAppTokenSave): Single<ResVOAppTokenSave>

    @POST("/search?q=title:DNA")
    fun requestSingle(): Single<ResVOApiPlos>

}