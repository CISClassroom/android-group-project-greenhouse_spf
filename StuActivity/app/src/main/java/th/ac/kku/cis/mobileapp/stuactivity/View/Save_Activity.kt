package th.ac.kku.cis.mobileapp.stuactivity.View

import android.app.AlertDialog
import android.content.Intent
import android.os.Bundle
import android.view.WindowManager
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import kotlinx.android.synthetic.main.activity_save_detail.*
import th.ac.kku.cis.mobileapp.stuactivity.Model.modelsave
import th.ac.kku.cis.mobileapp.stuactivity.R

class Save_Activity : AppCompatActivity() {
    lateinit var mDB: DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN
        )
        setContentView(R.layout.activity_save_detail)
        mDB = FirebaseDatabase.getInstance().reference

        btn_close.setOnClickListener{
            onBackPressed()
        }

        btSave.setOnClickListener {
            val builder = AlertDialog.Builder(this@Save_Activity)
            builder.setTitle("ยืนยันการเพิ่มกิจกรรม")
            builder.setMessage("คุณต้องการเพิ่มกิจกรรมหรือไม่ ?")

            builder.setNegativeButton("ยกเลิก") { dialog, which ->
                dialog.dismiss()
            }
            builder.setPositiveButton("ยืนยัน") { dialog, which ->
                var newData: modelsave = modelsave.create()
                val obj = mDB.child("Data_item").push()
                newData.nameEvent = nameEvent.text.toString()
                // newData.btSave = btSave.text.toString()
                newData.startDay = startDay.text.toString()
                newData.startTime = startTime.text.toString()
                newData.endDay = endDay.text.toString()
                newData.endTime = endTime.text.toString()
                newData.textAdress = textAdress.text.toString()
                newData.textDetail = textDetail.text.toString()


                newData.id = obj.key
                obj.setValue(newData)
                Toast.makeText(applicationContext, "เพิ่มกิจกรรมเรียบร้อยแล้ว", Toast.LENGTH_SHORT)
                    .show()

                btn_close.setOnClickListener {
                    var i = Intent(this, AdminMain::class.java)
                    i.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
                    startActivity(i)
                    builder.setPositiveButton("ยกเลิก") { dialog, which ->
                        dialog.dismiss()
                    }
                }

                val dialog: AlertDialog = builder.create()
                dialog.show()


            }
        }
        /*nameevent = findViewById(R.id.editText2)
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
    }*/
    }
}