package th.ac.kku.cis.mobileapp.stuactivity.ViewAdmin

import android.app.AlertDialog
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.WindowManager
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import kotlinx.android.synthetic.main.activity_save_detail.*
import th.ac.kku.cis.mobileapp.stuactivity.Model.modelsave
import th.ac.kku.cis.mobileapp.stuactivity.R

class Save_Activity : AppCompatActivity()  {
    private val TAG = "logcat_status"
    lateinit var mDB: DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN
        )
        setContentView(R.layout.activity_save_detail)
        mDB = FirebaseDatabase.getInstance().reference

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
                newData.startDay = startDay.text.toString()
                newData.startTime = startTime.text.toString()
                newData.endDay = endDay.text.toString()
                newData.endTime = endTime.text.toString()
                newData.textAdress = textAdress.text.toString()
                newData.textDetail = textDetail.text.toString()
                newData.textUnit = textUnit.text.toString()


                newData.id = obj.key
                obj.setValue(newData)
                Toast.makeText(applicationContext, "เพิ่มกิจกรรมเรียบร้อยแล้ว", Toast.LENGTH_SHORT)
                    .show()


                var i = Intent(this, AdminMain::class.java)
                i.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
                startActivity(i)

            }



            val dialog: AlertDialog = builder.create()
            dialog.show()

        }

        btn_close.setOnClickListener {
            Log.i(TAG,"Close_add_activity")
            var i = Intent(this, AdminMain::class.java)
            i.setFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP)
            startActivity(i)
        }


    }

}