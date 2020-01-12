package poetme.frontend.test

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.Button
import android.widget.Toast

import kotlinx.android.synthetic.main.activity_start.*
import java.util.*


class StartActivity : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_start)
        loadUniqueId()

        //
        firstApp()


        // Add Loading Animation

        if(checkAutoLogin()){
            // Pass Activity. Go to Main activity
            return
        }

        // Remove Loading Animation
        // Show Login Page

        setBtnLogin(btnLogin, false)
        txtEmail.addTextChangedListener(checkTxtEmail())
        btnLogin.setOnClickListener{clickBtnEmail()}

    }


    private fun loadUniqueId(): String{

        //val id = Secure.getString(contentResolver, Secure.ANDROID_ID);
        val id = UUID.randomUUID().toString()

        //Toast.makeText(applicationContext, guid, Toast.LENGTH_SHORT).show()

        return id

    }

    private fun firstApp(){
        if(App.userConfig.firstApp) {
            Toast.makeText(
                applicationContext,
                "firstApp: ${App.userConfig.firstApp}",
                Toast.LENGTH_SHORT
            ).show()
            App.userConfig.firstApp = false
            return
        }
    }

    private fun checkAutoLogin() : Boolean{

        // Check Config in Local Storage (Shared Preference)
        // Check TokenPref in Local Storage (Shared Preference)
        // Compare TokenPref Check in Local with Server DB

        // If all Condition is OK, Return Yes
        if(App.userToken.idToken == "")
            return false

        if(App.userConfig.autoLogin){

            return true
        }

        return false
    }


    private fun checkTxtEmail() : TextWatcher{
        return object : TextWatcher{
            override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {
            }

            override fun afterTextChanged(s: Editable) {
                val strEmail: String = txtEmail.text.toString() ?: ""
                if (isEmailValid(strEmail)) {
                    setBtnLogin(btnLogin, true)
                } else {
                    setBtnLogin(btnLogin, false)
                }
            }
        }
    }

    private fun clickBtnEmail(){
        val strEmail: String = txtEmail.text.toString() ?: ""
        if(isEmailValid(strEmail)){
            val intent = Intent(this@StartActivity, SignupActivity::class.java)
            intent.putExtra("email", strEmail)
            startActivity(intent)
        }else{
            setBtnLogin(btnLogin, false)
            Toast.makeText(applicationContext, "이메일이 유효하지 않습니다.", Toast.LENGTH_SHORT).show()
            txtEmail.isFocusableInTouchMode = true
            txtEmail.setText("")
            txtEmail.requestFocus()
        }
    }

    fun setBtnLogin(button: Button, setting: Boolean){
        if(setting){
            button.isEnabled = true
            button.isClickable = true
        }else{
            button.isEnabled = false
            button.isClickable = false
        }

    }


}
