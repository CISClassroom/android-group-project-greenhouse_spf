package th.ac.kku.cis.mobileapp.stuactivity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.WindowManager
import android.widget.ListView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.*
import kotlinx.android.synthetic.main.activity_addstudent.*
import kotlinx.android.synthetic.main.activity_event.*
import kotlinx.android.synthetic.main.activity_event.Adress
import kotlinx.android.synthetic.main.activity_event.Eday
import kotlinx.android.synthetic.main.activity_event.Etime
import kotlinx.android.synthetic.main.activity_event.NameActivity
import kotlinx.android.synthetic.main.activity_event.Sday
import kotlinx.android.synthetic.main.activity_event.Stime
import kotlinx.android.synthetic.main.activity_event.Unitgroup
import kotlinx.android.synthetic.main.activity_event.detail
import kotlinx.android.synthetic.main.activity_namestudent.*
import th.ac.kku.cis.mobileapp.stuactivity.Adapter.adapterAdd
import th.ac.kku.cis.mobileapp.stuactivity.Adapter.adapterSaveEven
import th.ac.kku.cis.mobileapp.stuactivity.Model.modelsave

class Addstudent : AppCompatActivity() {
    lateinit var ref: DatabaseReference
    lateinit var mDB: DatabaseReference
    lateinit var listview: ListView
    lateinit var items:MutableList<modelsave>
    lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_addstudent)
        if (supportActionBar != null)
            supportActionBar?.hide()
        window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN
        )
        var sessionId = getIntent().getStringExtra("id");
        ref = FirebaseDatabase.getInstance().getReference("Data_item").child(sessionId)
        ref.addValueEventListener(object : ValueEventListener {
            override fun onCancelled(p0: DatabaseError) {

            }
            override fun onDataChange(p0: DataSnapshot) {
                if(p0!!.exists()){
                    NameActivity.text = p0.child("nameEvent").value.toString()
                    Sday.text = p0.child("startDay").value.toString()
                    Stime.text = p0.child("startTime").value.toString()
                    Eday.text = p0.child("endDay").value.toString()
                    Etime.text = p0.child("endTime").value.toString()
                    Adress.text = p0.child("textAdress").value.toString()
                    Unitgroup.text = p0.child("textUnit").value.toString()
                    detail.text = p0.child("textDetail").value.toString()


                }
            }
        }
        )
        mDB = FirebaseDatabase.getInstance().reference

        btSave2.setOnClickListener {
            val builder = AlertDialog.Builder(this@Addstudent)
            builder.setTitle("ยืนยันการเข้าร่วมกิจกรรม")
            builder.setMessage("คุณต้องการเข้าร่วมกิจกรรมหรือไม่ ?")

            builder.setNegativeButton("ยกเลิก") { dialog, which ->
                dialog.dismiss()
            }
            builder.setPositiveButton("ยืนยัน") { dialog, which ->
                var newData: modelsave = modelsave.create()
                val obj = mDB.child("Data_item").push()
                newData.textNamestudent = textNamestudent.text.toString()
                newData.textNumberstudent = textNumberstudent.text.toString()



                newData.id = obj.key
                obj.setValue(newData)
                Toast.makeText(applicationContext, "เข้าร่วมกิจกรรมเรียบร้อยแล้ว", Toast.LENGTH_SHORT)
                    .show()


              //  var i = Intent(this, AdminMain::class.java)
              //  i.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
              //  startActivity(i)

            }



            val dialog: AlertDialog = builder.create()
            dialog.show()

        }

        listview = findViewById(R.id.listviewEnter)
        items = mutableListOf()
        ref = FirebaseDatabase.getInstance().getReference("Data_item")
        ref.addValueEventListener(object : ValueEventListener {
            override fun onCancelled(p0: DatabaseError) {

            }

            override fun onDataChange(p0: DataSnapshot) {
                if(p0!!.exists()){
                    items.clear()
                    for (e in p0.children){
                        val rec = e.getValue(modelsave::class.java)
                        items.add(rec!!)
                    }
                    val adapter = adapterAdd(this@Addstudent,R.layout.activity_namestudent ,items)
                    listview.adapter = adapter
                }


            }
        }
        )


    }
}