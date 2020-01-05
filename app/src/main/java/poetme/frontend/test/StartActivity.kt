package poetme.frontend.test

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.Toast

import kotlinx.android.synthetic.main.activity_start.*



class StartActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_start)

        btnLogin.isEnabled = false
        btnLogin.isClickable = false

        txtEmail.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {
            }
            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {
            }
            override fun afterTextChanged(s: Editable) {
                val strEmail: String = txtEmail.text.toString() ?: ""
                if(isEmailValid(strEmail)){
                    btnLogin.isEnabled = true
                    btnLogin.isClickable = true
                }else{
                    btnLogin.isEnabled = false
                    btnLogin.isClickable = false
                }
            }
        })

        btnLogin.setOnClickListener {
            val strEmail: String = txtEmail.text.toString() ?: ""
            if(isEmailValid(strEmail)){
                val intent = Intent(this@StartActivity, SignupActivity::class.java)
                intent.putExtra("email", strEmail)
                startActivity(intent)
            }else{
                btnLogin.isEnabled = false
                btnLogin.isClickable = false
                Toast.makeText(applicationContext, "이메일이 유효하지 않습니다.", Toast.LENGTH_SHORT).show()
                txtEmail.isFocusableInTouchMode = true
                txtEmail.setText("")
                txtEmail.requestFocus()
            }
        }
    }
}
