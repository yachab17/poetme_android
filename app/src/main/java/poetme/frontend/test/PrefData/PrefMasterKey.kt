package poetme.frontend.test.PrefData

import androidx.security.crypto.MasterKeys

class PrefMasterKey{
    companion object{
        private val masterKeyAlias = MasterKeys.getOrCreate(MasterKeys.AES256_GCM_SPEC)
        fun getMasterKeyAlias(): String = masterKeyAlias
    }
}
