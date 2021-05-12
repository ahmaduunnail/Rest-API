package com.lleans.restapi.retrofit


import retrofit2.http.GET


interface RetrofitInterface {

    @GET("top-headlines?country=id&apiKey=8f214228fb344eb6b52433517bb761f5")
    suspend fun getArticle(): RetrofitResponse
}