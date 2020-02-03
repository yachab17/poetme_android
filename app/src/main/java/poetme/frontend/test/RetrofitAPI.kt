package poetme.frontend.test

import com.google.gson.JsonObject
import poetme.frontend.test.DataObject.UserDataModel
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Path

interface RetrofitAPI {
    @GET("/user/{public_id}")//서버에 GET요청을 할 주소를 입력
    fun getUserInfo(@Path("public_id") public_id: Int) : Call<JsonObject> //MainActivity에서 사용할 json파일 가져오는 메서드
}