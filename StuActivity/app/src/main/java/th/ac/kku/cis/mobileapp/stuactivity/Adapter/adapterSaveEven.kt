package th.ac.kku.cis.mobileapp.stuactivity.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView
import th.ac.kku.cis.mobileapp.stuactivity.Model.modelsave
import th.ac.kku.cis.mobileapp.stuactivity.R

public class adapterSaveEven (val mCtx: Context,
                              var resource:Int,
                              var items:List<modelsave>): ArrayAdapter<modelsave>(mCtx,resource,items) {
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        //return super.getView(position, convertView, parent)
        val layout: LayoutInflater = LayoutInflater.from(mCtx)

        val v: View = layout.inflate(resource,null)
        val tvnameEvent : TextView = v.findViewById(R.id.nameEvent1 )
       // val tvbtSave : TextView = v.findViewById(R.id.btSave)
        val tvstartDay : TextView = v.findViewById(R.id.startDay1)
        val tvstartTime : TextView = v.findViewById(R.id.startTime1)
        val tvendDay : TextView = v.findViewById(R.id.endDay1)
        val tvendTime : TextView = v.findViewById(R.id.endTime1)
        //val tvtextAdress : TextView = v.findViewById(R.id.textAdress1)
       // val tvtextDetail : TextView = v.findViewById(R.id.textDetail1)
        val tvtextUnit : TextView = v.findViewById(R.id.textUnit1)

        val modeldata :modelsave = items[position]

        tvnameEvent.text = modeldata.nameEvent
        //tvbtSave.text = modeldata.btSave
        tvstartDay.text = modeldata.startDay
        tvstartTime.text = modeldata.startTime
        tvendDay.text = modeldata.endDay
        tvendTime.text = modeldata.endTime
       // tvtextAdress.text = modeldata.textAdress
       // tvtextDetail.text = modeldata.textDetail
        tvtextUnit.text = modeldata.textUnit

        return v
    }
}

