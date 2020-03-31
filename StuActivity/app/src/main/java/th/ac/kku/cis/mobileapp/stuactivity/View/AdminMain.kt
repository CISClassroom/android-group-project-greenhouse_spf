package th.ac.kku.cis.mobileapp.stuactivity.View

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.WindowManager
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInAccount
import com.google.android.gms.common.api.ApiException
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.GoogleAuthProvider
import kotlinx.android.synthetic.main.activity_admin.*
import th.ac.kku.cis.mobileapp.stuactivity.R

class AdminMain : AppCompatActivity() {
    lateinit var auth: FirebaseAuth
    lateinit var googleClient: GoogleSignInClient
    var boo: Boolean = false
    private val PERMISSION_CODE = 1000;
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN
        )
        setContentView(R.layout.activity_admin_main)


        var gso = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
            .requestIdToken(getString(R.string.default_web_client_id))
            .requestEmail()
            .build()
        googleClient = GoogleSignIn.getClient(this, gso)
        auth = FirebaseAuth.getInstance()

        val btn_signoutt: Button = findViewById(R.id.btn_signoutt)
        btn_signoutt.setOnClickListener({ v -> singOut() })
        btsave.setOnClickListener {

            var i = Intent(this, Save_Activity::class.java)
            i.setFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP)
            startActivity(i)
        }
        val btlogout: Button = findViewById(R.id.btlogout)
        btlogout.setOnClickListener({ v -> singOut() })
    }

    private fun checklogin() {
        if (boo) {
            var i = Intent(this, MainActivity::class.java)
            i.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
            startActivity(i)

        }
    }
    private fun passproject() {
        if (boo) {
            var i = Intent(this, MainActivity::class.java)
            i.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
            startActivity(i)
        }
    }
        private fun singOut() {

            auth.signOut()
            boo = true
            passproject()
        }
    }
