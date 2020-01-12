package poetme.frontend.test.PrefData

import android.content.Context
import androidx.security.crypto.EncryptedSharedPreferences
import poetme.frontend.test.SharedPrefCommon.*
import poetme.frontend.test.Temp.SharedPref

class ConfigStorage(context: Context) {
    companion object {
        const val PREFERENCE_NAME = "user_config.pref"
    }

    private val storage = EncryptedSharedPreferences.create(
        PREFERENCE_NAME,
        PrefMasterKey.getMasterKeyAlias(),
        context,
        EncryptedSharedPreferences.PrefKeyEncryptionScheme.AES256_SIV,
        EncryptedSharedPreferences.PrefValueEncryptionScheme.AES256_GCM
    ).toStorage()

    var firstApp by StorageChannel<Boolean>() boundTo storage withDefault true
    var autoLogin by StorageChannel<Boolean>() boundTo storage withDefault true


//    var fontSize by StorageChannel<Float>() boundTo storage withDefault 10f
//    var periodicSyncEnabled by StorageChannel<Boolean>() boundTo storage
//    var syncPeriodInMills by StorageChannel<Long>() boundTo storage withDefault 100_000 // 100s
//    var syncPageSize by StorageChannel<Int>() boundTo storage withDefault 10
//    var defaultSignature by StorageChannel<String>() boundTo storage withDefault "Written by ..."
}