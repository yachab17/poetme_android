package poetme.frontend.test.DataObject

class UserDataModel {
    data class DataUserSimple(val data: UserSimple)
    data class UserSimple(val id: Int, val username: String, val login_type: Int, val login_social_id: String)
}