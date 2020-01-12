package poetme.frontend.test.DataObject

import com.google.gson.annotations.SerializedName

data class TokenData(
    @SerializedName("iss") val iss: String,
    @SerializedName("exp") val exp: Long,
    @SerializedName("id") val id: Long,
    @SerializedName("des") val des: String
)