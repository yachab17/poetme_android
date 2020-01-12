package poetme.frontend.test.SharedPrefCommon

interface Storage {
    fun getString(key: String, default: String = ""): String
    fun putString(key: String, value: String)

    fun getInt(key: String, default: Int = 0): Int
    fun putInt(key: String, value: Int)

    fun getFloat(key: String, default: Float = 0f): Float
    fun putFloat(key: String, value: Float)

    fun getLong(key: String, default: Long = 0L): Long
    fun putLong(key: String, value: Long)

    fun getBoolean(key: String, default: Boolean = false): Boolean
    fun putBoolean(key: String, value: Boolean)
}