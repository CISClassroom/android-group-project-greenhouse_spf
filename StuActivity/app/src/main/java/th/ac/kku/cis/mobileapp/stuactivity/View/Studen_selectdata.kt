package th.ac.kku.cis.mobileapp.stuactivity.View

import android.os.Bundle
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.database.*
import kotlinx.android.synthetic.main.activity_event.*
import kotlinx.android.synthetic.main.activity_listevent__admin.*
import kotlinx.android.synthetic.main.activity_user_select_detail_show.*
import kotlinx.android.synthetic.main.activity_user_select_detail_show.endDay
import kotlinx.android.synthetic.main.activity_user_select_detail_show.startDay
import th.ac.kku.cis.mobileapp.stuactivity.R

class Studen_selectdata : AppCompatActivity() {
    lateinit var ref: DatabaseReference


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user_select_detail_show)
        if (supportActionBar != null)
            supportActionBar?.hide()
        window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN
        )
        val intent = intent
        var sessionId = intent.getStringExtra("id")
        ref = FirebaseDatabase.getInstance().getReference("Data_item").child(sessionId)
        ref.addValueEventListener(object : ValueEventListener {
            override fun onCancelled(dataSnapshot: DatabaseError) {

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
        })
    }
}