package poetme.frontend.test

import android.app.Application
import poetme.frontend.test.PrefData.ConfigStorage
import poetme.frontend.test.PrefData.TokenStorage

class App : Application() {

    companion object {
        lateinit var userToken : TokenStorage
        lateinit var userConfig : ConfigStorage
    }
    /* App 실행시 Token 및 Config Preference 불러옴. */

    override fun onCreate() {
        userToken = TokenStorage(applicationContext)
        userConfig = ConfigStorage(applicationContext)
        super.onCreate()
    }

}