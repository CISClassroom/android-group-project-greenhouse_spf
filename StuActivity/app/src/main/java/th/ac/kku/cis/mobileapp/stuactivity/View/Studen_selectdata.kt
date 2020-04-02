package th.ac.kku.cis.mobileapp.stuactivity.View

import android.os.Bundle
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.database.*
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
        var sessionId = intent.getStringExtra("id");
        ref = FirebaseDatabase.getInstance().getReference("Data_item").child(sessionId)
        ref.addValueEventListener(object : ValueEventListener {
            override fun onCancelled(p0: DatabaseError) {

            }
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                if(dataSnapshot!!.exists()){
                    nameEvent.text = dataSnapshot.child("nameEvent").value.toString()
                    startDay.text = dataSnapshot.child("startDay").value.toString()
                    startTime.text = dataSnapshot.child("startTime").value.toString()
                    endDay.text = dataSnapshot.child("endDay").value.toString()
                    endTime.text = dataSnapshot.child("endTime").value.toString()
                    textAdress.text = dataSnapshot.child("textAdress").value.toString()
                    textDetail.text = dataSnapshot.child("textUnit").value.toString()
                    Unittext.text = dataSnapshot.child("textDetail").value.toString()
                }
            }
        })
    }
}