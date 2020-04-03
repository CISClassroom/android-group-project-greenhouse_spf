package th.ac.kku.cis.mobileapp.stuactivity.ViewAdmin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.WindowManager
import android.widget.ListView
import android.widget.Toast
import com.google.firebase.database.*
import kotlinx.android.synthetic.main.activity_event.*
import kotlinx.android.synthetic.main.activity_listevent__admin.*
import th.ac.kku.cis.mobileapp.stuactivity.Adapter.adapterSaveEven
import th.ac.kku.cis.mobileapp.stuactivity.Model.modelsave
import th.ac.kku.cis.mobileapp.stuactivity.R

class Event : AppCompatActivity() {
    lateinit var ref: DatabaseReference
    private val TAG = "adminview"


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_event)
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




    }
}
