package poetme.frontend.test.SharedPrefStorage

import android.content.SharedPreferences

fun SharedPreferences.toStorage(): Storage {
    return SharedPrefStorage(this)
}