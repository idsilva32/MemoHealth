package br.com.fiap.memo.service

import br.com.fiap.memo.model.Memo
import br.com.fiap.memo.model.MemoAPI
import retrofit2.Call
import retrofit2.http.GET

interface MemoService {
    @GET("memo")
    fun getMemo(): Call<List<MemoAPI>>
}