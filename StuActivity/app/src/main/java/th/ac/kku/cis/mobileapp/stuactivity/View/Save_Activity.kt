package th.ac.kku.cis.mobileapp.stuactivity.View

import android.content.Intent
import android.os.Bundle
import android.view.WindowManager
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import androidx.appcompat.app.AppCompatActivity
import th.ac.kku.cis.mobileapp.stuactivity.R

class Save_Activity : AppCompatActivity()  {
    var nameevent : EditText? = null
    var datestart : EditText? = null
    var timestart : EditText? = null
    var dateend : EditText? = null
    var timeend : EditText? = null
    var location : EditText? = null
    var detailevent : EditText? = null
    var credit : Spinner? = null
    var close : Button? = null
    var save : Button? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN
        )
        setContentView(R.layout.fragment_save_detail)

        nameevent = findViewById(R.id.editText2)
        datestart = findViewById(R.id.editText4)
        timestart = findViewById(R.id.editText3)
        dateend = findViewById(R.id.editText5)
        timeend = findViewById(R.id.editText6)
        location = findViewById(R.id.editText7)
        detailevent = findViewById(R.id.editText8)
        credit = findViewById(R.id.spinner2)
        close = findViewById(R.id.btn_close)
        save = findViewById(R.id.btn_save_act)


        }
    }