package th.ac.kku.cis.mobileapp.stuactivity.View

import android.os.Bundle
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity
import th.ac.kku.cis.mobileapp.stuactivity.R

class Save_Activity : AppCompatActivity()  {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN
        )
        setContentView(R.layout.fragment_save_detail)
    }

}