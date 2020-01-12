package poetme.frontend.test.SharedPrefStorage

import android.content.Context

class TokenStorage(context: Context) {
    companion object {
        const val PREFERENCE_NAME = "user_token.pref"
    }

    private val storage =
        context.getSharedPreferences(PREFERENCE_NAME, Context.MODE_PRIVATE).toStorage()

    var idToken by StorageChannel<String>() boundTo storage withDefault ""
    var accessToken by StorageChannel<String>() boundTo storage withDefault ""
    var refreshToken by StorageChannel<String>() boundTo storage withDefault ""

//    var fontSize by StorageChannel<Float>() boundTo storage withDefault 10f
//    var periodicSyncEnabled by StorageChannel<Boolean>() boundTo storage
//    var syncPeriodInMills by StorageChannel<Long>() boundTo storage withDefault 100_000 // 100s
//    var syncPageSize by StorageChannel<Int>() boundTo storage withDefault 10
//    var defaultSignature by StorageChannel<String>() boundTo storage withDefault "Written by ..."
}