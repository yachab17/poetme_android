package poetme.frontend.test.View.test

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import com.google.gson.Gson
import com.google.gson.JsonObject
import kotlinx.android.synthetic.main.activity_test.*
import poetme.frontend.test.DataObject.UserDataModel
import poetme.frontend.test.R
import poetme.frontend.test.SearchRetrofit
import retrofit2.Call
import retrofit2.Response

class TestActivity : AppCompatActivity() {

    lateinit var mCallTodoList : retrofit2.Call<JsonObject>

    val TAG = "TAG_MainActivity"//로그를 분류할 태그입니다.

    //http요청을 보냈고 이건 응답을 받을 콜벡메서드
    private val mRetrofitCallback  = (object : retrofit2.Callback<JsonObject>{//Json객체를 응답받는 콜백 객체

        //응답을 가져오는데 실패
        override fun onFailure(call: Call<JsonObject>, t: Throwable) {
            t.printStackTrace()
            Log.d(TAG, "에러입니다. => ${t.message.toString()}")
            txtViewResult.text = "에러\n" + t.message.toString()

            progressBar.visibility = View.GONE
            btnUserApi.visibility = View.VISIBLE
        }
        //응답을 가져오는데 성공 -> 성공한 반응 처리
        override fun onResponse(call: Call<JsonObject>, response: Response<JsonObject>) {
            val result = response.body()
            Log.d(TAG, "결과는 => $result")

            var mGson = Gson()
            val dataParsed1 = mGson.fromJson(result, UserDataModel.DataUserSimple::class.java)

            txtViewResult.text = "해야할 일\n" + dataParsed1.data.id+"\n" +dataParsed1.data.username +"\n"+dataParsed1.data.login_type+"\n"+dataParsed1.data.login_social_id

            progressBar.visibility = View.GONE
            btnUserApi.visibility = View.VISIBLE
        }
    })

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_test)


        btnUserApi.setOnClickListener {
            btnUserApi.visibility = View.INVISIBLE
            progressBar.visibility = View.VISIBLE
            txtViewResult.text = txtInput.text.toString()
            callUserInfo()
        }


    }

    private fun callUserInfo() {
        mCallTodoList = SearchRetrofit.getService().getUserInfo(Integer.parseInt(txtInput.text.toString()))
        mCallTodoList.enqueue(mRetrofitCallback)//응답을 큐 대기열에 넣는다.
    }


}
