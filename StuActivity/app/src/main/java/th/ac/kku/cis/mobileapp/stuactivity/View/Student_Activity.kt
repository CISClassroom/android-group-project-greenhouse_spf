package th.ac.kku.cis.mobileapp.stuactivity.View

import android.content.Intent
import android.os.Bundle
import android.view.WindowManager
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.database.*
import kotlinx.android.synthetic.main.activity_listview_event.*
import th.ac.kku.cis.mobileapp.stuactivity.Adapter.adapterSaveEven
import th.ac.kku.cis.mobileapp.stuactivity.Model.modelsave
import th.ac.kku.cis.mobileapp.stuactivity.R
import th.ac.kku.cis.mobileapp.stuactivity.ViewAdmin.AdminMain
import th.ac.kku.cis.mobileapp.stuactivity.ViewAdmin.Event


class Student_Activity : AppCompatActivity() {

    private val TAG = "logcat_status"
    private lateinit var mRecyclerView : RecyclerView
    private lateinit var  mDatabaseRef : DatabaseReference
    private lateinit var  mEventDatabaseRef : DatabaseReference
    private lateinit var linearLayoutManager: LinearLayoutManager
    private lateinit var mFirebaseDatabase: FirebaseDatabase
    lateinit var items:MutableList<modelsave>




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN)
        setContentView(R.layout.activity_student)

        mRecyclerView = findViewById(R.id.list_recycler_view)
        items = mutableListOf()

        //Dummy
//        val excamplelist = generateDammyList(10)
//        list_recycler_view.adapter = Events_Adapter(excamplelist)
//        list_recycler_view.layoutManager = LinearLayoutManager(this)
//        list_recycler_view.setHasFixedSize(true)


//        mRecyclerView.layoutManager = LinearLayoutManager(this)




        bindingData()

//        loadFirebaseData()

//        val excamplelist = generateDammyList(10)
//        Log.i(TAG,"excamplelist$excamplelist")


////        //getting the recyclerview from xml
//        list_recycler_view.adapter = Events_Adapter(excamplelist)
//        Log.i(TAG,"list_recycler_view$list_recycler_view")
//        list_recycler_view.layoutManager = LinearLayoutManager(this)
//        list_recycler_view.setHasFixedSize(true)


    }

    private fun bindingData() {
        var sessionId = getIntent().getStringExtra("id");
        mEventDatabaseRef = FirebaseDatabase.getInstance().getReference("Data_item").child(sessionId)
        mEventDatabaseRef!!.addValueEventListener(object :ValueEventListener{

            override fun onCancelled(p0: DatabaseError) {
                Toast.makeText(this@Student_Activity, "Opsss.... Something is wrong", Toast.LENGTH_SHORT).show();
            }

            override fun onDataChange(p0: DataSnapshot) {
                if(p0!!.exists()){
                    items.clear()
                    for (e in p0.children){
                        val rec = e.getValue(modelsave::class.java)
                        items.add(rec!!)
                    }
                    val adapter = adapterSaveEven(this@Student_Activity,R.layout.list_item,items)
                    mRecyclerView.adapter = adapter
                }
            }

        })
//        mRecyclerView.setOnItemClickListener{ parent, view, position, id ->
//            var i = Intent(this, Event::class.java)
//            i.putExtra("id",items[position].id)
//            i.setFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP)
//            startActivity(i)
//
//        }

        btback.setOnClickListener {

            var i = Intent(this, AdminMain::class.java)
            i.setFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP)
            startActivity(i)
        }

    }
}
















/*
    private fun bindingData() {
        Log.i(TAG,"bindingData")

        mEventDatabaseRef.addValueEventListener(object : ValueEventListener{
            override fun onDataChange(p0: DataSnapshot) {
                val post = p0.getValue<Event>()

//                if(p0!!.exists()) {
//                    for (h in p0.children) {
//
//
//                    }
//                }


//                    mRecyclerView?.setAdapter(adapter)
//                for (datasnapshot:DataSnapshot in p0.children){
//                     val event = datasnapshot.getValue(Event::class.java)
//                    Toast.makeText(this@Student_Activity, "Client$event", Toast.LENGTH_SHORT).show()
//                }

//                if(p0!!.exists()){
//                    NameActivity.text = p0.child("nameEvent").value.toString()
//                    Sday.text = p0.child("startDay").value.toString()
//                    Stime.text = p0.child("startTime").value.toString()
//                    Eday.text = p0.child("endDay").value.toString()
//                    Etime.text = p0.child("endTime").value.toString()
//                    Adress.text = p0.child("textAdress").value.toString()
//                    Unitgroup.text = p0.child("textUnit").value.toString()
//                    detail.text = p0.child("textDetail").value.toString()
//                }
            }
            override fun onCancelled(p0: DatabaseError) {
                Log.i(TAG,"ERROR ${p0.message}")
            }

        })
    }
    */




//    private fun generateDammyList(size:Int):List<Event>{
//        val list = ArrayList<Event>()
//
//        for (i in 0 until  size){
//            val Unit_Activity = when (i%5){
//                0 -> 1.toString()
//                1 -> 2.toString()
//                2 -> 3.toString()
//                3 -> 4.toString()
//                else -> 5.toString()
//            }
//            val item = Event("เชียร์ ASE","01/05/2562","02/05/2562","0800","1800","อคร.1","หน่วยกิตกรรม 5 หน่วย ช่วยงาน",Unit_Activity)
//            list += item
//        }
//        return list
//    }


