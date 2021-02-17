package com.example.login

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.amplifyframework.AmplifyException
import com.amplifyframework.auth.options.AuthSignOutOptions
import com.amplifyframework.core.Amplify

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        try {

            Amplify.Auth.signIn(
                "shubhamjha",
                "Password123",
                { result -> Log.i("AuthQuickstart", if (result.isSignInComplete) "Sign in succeeded" else "Sign in not complete") },
                { error -> Log.e("AuthQuickstart", error.toString()) }
            )
            Amplify.Auth.signOut(
                AuthSignOutOptions.builder().globalSignOut(true).build(),
                { Log.i("AuthQuickstart", "Signed out globally") },
                { error -> Log.e("AuthQuickstart", error.toString()) }
            )

        } catch (error: AmplifyException) {
            Log.e("Login", "Could not initialize Amplify", error)
        }
        Amplify.Auth.fetchAuthSession(
            { result -> Log.i("AmplifyQuickstart", result.toString()) },
            { error -> Log.e("AmplifyQuickstart", error.toString()) }
        )
    }
    }