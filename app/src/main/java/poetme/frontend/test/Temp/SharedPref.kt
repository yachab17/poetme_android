package poetme.frontend.test.Temp

import android.content.SharedPreferences

class SharedPref {
    companion object{
        lateinit var masterKeyAlias: String
        lateinit var prefToken: SharedPreferences
        lateinit var prefConfig: SharedPreferences

        fun isInitApp(): Boolean{
            return prefConfig.getBoolean("init_app",true)
        }

        fun setInitPrefConfig(){
            prefConfig.edit().apply{
                putBoolean("init_app", false)
                putBoolean("auto_login", true)
            }.apply()
        }

        fun isAutoLogin(): Boolean{
            return prefConfig.getBoolean("auto_login", false)
        }


        fun isAuthOk(): Boolean{
            val idToken = prefToken.getString("id_token", "")
            if(idToken != ""){
                val accessToken = prefToken.getString("access_token", "")
                val refreshToken = prefToken.getString("refresh_token", "")

            }
            return false
        }

    }


}