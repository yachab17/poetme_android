package poetme.frontend.test.SharedPrefCommon

import android.content.SharedPreferences
import androidx.security.crypto.EncryptedSharedPreferences

fun SharedPreferences.toStorage(): Storage {
    return SharedPrefStorage(this)
}

