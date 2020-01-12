package poetme.frontend.test.SharedPrefCommon

import android.content.SharedPreferences
import androidx.core.content.edit
import androidx.security.crypto.EncryptedSharedPreferences

class SharedPrefStorage (private val preferences: SharedPreferences) : Storage {

    override fun getString(key: String, default: String): String =
        preferences.getString(key, default) ?: default

    override fun putString(key: String, value: String) = preferences.edit {
        putString(key, value)
    }

    override fun getInt(key: String, default: Int): Int = preferences.getInt(key, default)

    override fun putInt(key: String, value: Int) = preferences.edit {
        putInt(key, value)
    }

    override fun getFloat(key: String, default: Float): Float = preferences.getFloat(key, default)

    override fun putFloat(key: String, value: Float) = preferences.edit {
        putFloat(key, value)
    }

    override fun getLong(key: String, default: Long): Long = preferences.getLong(key, default)

    override fun putLong(key: String, value: Long) = preferences.edit {
        putLong(key, value)
    }

    override fun getBoolean(key: String, default: Boolean): Boolean =
        preferences.getBoolean(key, default)

    override fun putBoolean(key: String, value: Boolean) = preferences.edit {
        putBoolean(key, value)
    }
}

