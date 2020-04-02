package th.ac.kku.cis.mobileapp.stuactivity.ViewAdmin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.WindowManager
import android.widget.ListView
import android.widget.Toast
import com.google.firebase.database.*
import kotlinx.android.synthetic.main.activity_listview_event.*
import th.ac.kku.cis.mobileapp.stuactivity.Adapter.adapterSaveEven
import th.ac.kku.cis.mobileapp.stuactivity.Model.modelsave
import th.ac.kku.cis.mobileapp.stuactivity.R
import th.ac.kku.cis.mobileapp.stuactivity.View.u_select_detail_show

class ListviewEvent : AppCompatActivity() {
    lateinit var listview: ListView
    lateinit var ref: DatabaseReference
    lateinit var items:MutableList<modelsave>
    private val TAG = "logcat_status"



    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_listview_event)
        if (supportActionBar != null)
            supportActionBar?.hide()
        window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN)


        listview = findViewById(R.id.listviewAdmin)
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
                    val adapter = adapterSaveEven(this@ListviewEvent,R.layout.activity_listevent__admin ,items)
                    listview.adapter = adapter

                }


            }
        }
        )
        listview.setOnItemClickListener { parent, view, position, id ->
            var i = Intent(this, u_select_detail_show::class.java)
            i.putExtra("id",items[position].id)
            i.setFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP)
            startActivity(i)
               // Toast.makeText(this,items[position].textDetail,Toast.LENGTH_LONG).show()

            }

        btback.setOnClickListener {

            var i = Intent(this, AdminMain::class.java)
            i.setFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP)
            startActivity(i)
        }
    }

    }

