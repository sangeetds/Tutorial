package com.example.login

import android.media.Image
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.method.HideReturnsTransformationMethod
import android.text.method.PasswordTransformationMethod
import android.util.Patterns
import android.view.View
import android.widget.*
import androidx.annotation.RequiresApi
import com.google.android.material.floatingactionbutton.FloatingActionButton
import kotlin.reflect.jvm.internal.impl.util.Check

class LoginActivity : AppCompatActivity() {
    private lateinit var userNameText: EditText
    private lateinit var passwordText: EditText
    private lateinit var loginButton: FloatingActionButton
    private lateinit var backButton: ImageButton
    private lateinit var showPasswordButton: CheckBox

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        userNameText = findViewById(R.id.input_username)
        passwordText = findViewById(R.id.input_password)
        loginButton = findViewById(R.id.btn_login)
        backButton = findViewById(R.id.backToMain)
        showPasswordButton = findViewById(R.id.checkPasswordLogin)

        userNameText.setAutofillHints(View.AUTOFILL_HINT_EMAIL_ADDRESS)
        passwordText.setAutofillHints(View.AUTOFILL_HINT_PASSWORD)

        loginButton.setOnClickListener {
            login()
        }

        backButton.setOnClickListener {
            onBackPressed()
        }

        showPasswordButton.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                passwordText.transformationMethod = HideReturnsTransformationMethod.getInstance()
            }
            else passwordText.transformationMethod = PasswordTransformationMethod.getInstance()
        }
    }

    private fun login() {
        if (!validate()) {
            onLoginFailed()
            return
        }

        loginButton.isEnabled = false

        val username = userNameText.text.toString()
        val password = passwordText.text.toString()
        val user = User(username = username, password = password)

        val progressDialog = LoadDialog(this, user, getString(R.string.url), Log.LOGIN)
        progressDialog.show()
    }

    override fun onBackPressed() {
        super.onBackPressed()
        finish()
    }

    private fun onLoginFailed() {
        Toast.makeText(baseContext, "Check credentials", Toast.LENGTH_LONG).show()
        loginButton.isEnabled = true
    }

    private fun validate(): Boolean {
        var valid = true
        val email = userNameText.text.toString()
        val password = passwordText.text.toString()

        if (email.isEmpty() || !Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            userNameText.error = "enter a valid email address"
            valid = false
        } else {
            userNameText.error = null
        }
        if (password.isEmpty() || password.length < 4 || password.length > 10) {
            passwordText.error = "between 4 and 10 alphanumeric characters"
            valid = false
        } else {
            passwordText.error = null
        }

        return valid
    }
}