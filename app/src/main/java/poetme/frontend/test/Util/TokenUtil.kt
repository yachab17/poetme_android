package poetme.frontend.test.Util

import android.util.Base64
import android.util.Log
import com.google.gson.Gson
import poetme.frontend.test.DataObject.TokenData
import java.io.UnsupportedEncodingException
import java.lang.Exception

class TokenUtil {
    companion object{

        fun isExpiredToken(encodedToken: String): Boolean{
            val jsonStr = decodeToken(encodedToken)
            try{
                val tokenData = Gson().fromJson(jsonStr, TokenData::class.java)
                return(tokenData.exp < System.currentTimeMillis())
            }catch (e: Exception){
                return true
            }
        }
        
        @Throws(UnsupportedEncodingException::class)
        private fun decodeToken(encodedToken: String): String{
            try {
                val split = encodedToken.split("\\.")
                Log.d("JWT_DECODED", "Header: " + getJson(split[0]))
                Log.d("JWT_DECODED", "Body: " + getJson(split[1]))
                return getJson(split[1])
            } catch (e: UnsupportedEncodingException) {
                //Error
                return ""
            }
        }

        @Throws(UnsupportedEncodingException::class)
        private fun getJson(strEncoded: String): String {
            val decodedBytes = Base64.decode(strEncoded, Base64.URL_SAFE)
            return String(decodedBytes, Charsets.UTF_8)
        }

    }


}