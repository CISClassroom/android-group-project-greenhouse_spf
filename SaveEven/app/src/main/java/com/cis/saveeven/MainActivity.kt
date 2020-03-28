package com.cis.saveeven

import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInAccount
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.android.gms.common.api.ApiException
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.auth.GoogleAuthProvider
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    lateinit var auth: FirebaseAuth
    lateinit var googleClient: GoogleSignInClient
    var boo:Boolean = false
    private val PERMISSION_CODE = 1000;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        if (supportActionBar != null)
            supportActionBar?.hide()

        auth = FirebaseAuth.getInstance()

        login.setOnClickListener({ v -> singIn() })

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M){
            if (checkSelfPermission(Manifest.permission.WRITE_EXTERNAL_STORAGE) == PackageManager.PERMISSION_DENIED){
                //permission was not enabled
                val permission = arrayOf( Manifest.permission.WRITE_EXTERNAL_STORAGE)
                //show popup to request permission
                requestPermissions(permission, PERMISSION_CODE)
            }
            else{

            }
        }

        var gso = GoogleSignInOptions.Builder(
            GoogleSignInOptions.DEFAULT_SIGN_IN
        )
            .requestIdToken(getString(R.string.default_web_client_id))
            .requestEmail()
            .build()
        googleClient = GoogleSignIn.getClient(this, gso)
        auth = FirebaseAuth.getInstance()


    }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
        //called when user presses ALLOW or DENY from Permission Request Popup
        when(requestCode){
            PERMISSION_CODE -> {
                if (grantResults.size > 0 && grantResults[0] ==
                    PackageManager.PERMISSION_GRANTED){

                }
                else {
                    //permission from popup was denied
                    Toast.makeText(this, "Permission denied", Toast.LENGTH_SHORT).show()
                    finish();

                }
            }
        }
    }

    private fun checklogin() {
        if(boo) {
            if(auth!!.currentUser?.email =="phaicblack55@gmail.com" ){
                var i = Intent(this, AdminMain::class.java)
                i.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
                startActivity(i)
            }
            else{
                var i = Intent(this, StudentMain::class.java)
                i.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
                startActivity(i)
            }

        }
    }

    private fun singOut() {
        auth.signOut()
        googleClient.signOut().addOnCompleteListener(this) {
            updateUI(null)
        }
    }

    private fun updateUI(user: FirebaseUser?) {
        if (user == null) {
            // show.text = "No User"
        } else {
            //  show.text = user.email.toString()
            checklogin()
        }

    }

    private fun singIn() {
        singOut()

        if(boo){
            checklogin()
        }
        else {
            var signInInent = googleClient.signInIntent
            startActivityForResult(signInInent, 101)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == 101) {
            val task = GoogleSignIn.getSignedInAccountFromIntent(data)
            try {
                val account = task.getResult(ApiException::class.java)
                firebaseAuth(account!!)
                //FirebaseAuth(account)
            } catch (e: ApiException) {
                boo = false
                updateUI(null)
            }
        }
    }

    private fun firebaseAuth(account: GoogleSignInAccount) {
        val credential = GoogleAuthProvider.getCredential(account.idToken, null)
        auth.signInWithCredential(credential)
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {
                    val user = auth.currentUser
                    boo = true
                    updateUI(user)
                } else {
                    boo = false
                    updateUI(null)
                }
            }


    }


}






