package th.ac.kku.cis.mobileapp.stuactivity.ViewAdmin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.WindowManager
import th.ac.kku.cis.mobileapp.stuactivity.R

class Listevent_Admin : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_listevent__admin)
        if (supportActionBar != null)
            supportActionBar?.hide()
        window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN)


    }
}
