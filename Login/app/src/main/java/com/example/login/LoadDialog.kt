package com.example.login

import android.app.Dialog
import android.content.Context
import android.os.Bundle
import android.view.animation.AnimationUtils
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import kotlinx.coroutines.*

class LoadDialog(context: Context, private val user: User, private val url: String, private val type: Log) : Dialog(context) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_loading)

        val statusText = findViewById<TextView>(R.id.statusText)
        val cancelButton = findViewById<ImageView>(R.id.cancelButton)
        cancelButton.setOnClickListener {
            dismiss()
        }

        val retrofitService = Retrofit.getRetrofitClient("http://10.0.2.2:8080")

        update(statusText!!, retrofitService)
    }

    private fun update(statusText: TextView, retrofitService: LoginService) {
        GlobalScope.launch {
            val text = if (type == Log.LOGIN) logIn(retrofitService, user).body() else createAccount(retrofitService, user).body()

            when(text) {
                Status.SUCCESS -> {
                    statusText.text = if (type == Log.LOGIN)context.getString(R.string.loggedIn)
                        else context.getString(R.string.created)
                }
                Status.FAILURE -> statusText.text = context.getString(R.string.logInError)
                else -> statusText.text = context.getString(R.string.existAlready)
            }
        }
    }
}
