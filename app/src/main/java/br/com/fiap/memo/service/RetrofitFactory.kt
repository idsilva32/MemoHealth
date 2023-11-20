package br.com.fiap.memo.service

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitFactory {

    //private val URL = "apimemo.azurewebsites.net"
    private val URL = "http://192.168.15.51:8080"

    private val retrofitFactory = Retrofit
        .Builder()
        .baseUrl(URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    fun getMemoService(): MemoService {
        return retrofitFactory.create(MemoService::class.java)
    }

}