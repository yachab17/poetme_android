package poetme.frontend.test

import android.content.res.Resources
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object SearchRetrofit {
    // 위에서 만든 RetrofitService를 연결해줍니다.
    fun getService(): RetrofitAPI = retrofit.create(RetrofitAPI::class.java)

    private val retrofit =
        Retrofit.Builder()
            .baseUrl("https://api.poetme.com") // 도메인 주소
            .addConverterFactory(GsonConverterFactory.create()) // GSON을 사요아기 위해 ConverterFactory에 GSON 지정
            .build()
}