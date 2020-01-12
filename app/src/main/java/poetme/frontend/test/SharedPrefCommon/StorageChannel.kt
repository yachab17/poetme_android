package poetme.frontend.test.SharedPrefCommon

import kotlin.reflect.KProperty

class StorageChannel<T>(var storage: Storage? = null, var default: T? = null)

inline operator fun <reified T> StorageChannel<T>.getValue(
    thisRef: Any?,
    property: KProperty<*>
): T {
    storage?.let {
        return when (T::class) {
            String::class -> it.getString(property.name, default as? String ?: "") as T
            Int::class -> it.getInt(property.name, default as? Int ?: 0) as T
            Float::class -> it.getFloat(property.name, default as? Float ?: 0f) as T
            Long::class -> it.getLong(property.name, default as? Long ?: 0L) as T
            Boolean::class -> it.getBoolean(property.name, default as? Boolean ?: false) as T
            else -> throw UnsupportedOperationException()
        }
    }
    throw IllegalStateException()
}

inline operator fun <reified T> StorageChannel<T>.setValue(
    thisRef: Any?,
    property: KProperty<*>,
    value: T
) {
    storage?.let {
        when (T::class) {
            String::class -> it.putString(property.name, value as String)
            Int::class -> it.putInt(property.name, value as Int)
            Float::class -> it.putFloat(property.name, value as Float)
            Long::class -> it.putLong(property.name, value as Long)
            Boolean::class -> it.putBoolean(property.name, value as Boolean)
            else -> throw UnsupportedOperationException()
        }
    }
}

inline infix fun <reified T> StorageChannel<T>.boundTo(storage: Storage): StorageChannel<T> =
    apply {
        this.storage = storage
    }

inline infix fun <reified T> StorageChannel<T>.withDefault(default: T): StorageChannel<T> = apply {
    this.default = default
}
