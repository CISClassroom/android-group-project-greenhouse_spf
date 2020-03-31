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
        val tvnameEvent : TextView = v.findViewById(R.id.nameEvent )
       // val tvbtSave : TextView = v.findViewById(R.id.btSave)
        val tvstartDay : TextView = v.findViewById(R.id.startDay)
        val tvstartTime : TextView = v.findViewById(R.id.startTime)
        val tvendDay : TextView = v.findViewById(R.id.endDay)
        val tvendTime : TextView = v.findViewById(R.id.endTime)
        val tvtextAdress : TextView = v.findViewById(R.id.textAdress)
        val tvtextDetail : TextView = v.findViewById(R.id.textDetail)
        val tvtextUnit : TextView = v.findViewById(R.id.textUnit)

        val modeldata :modelsave = items[position]

        tvnameEvent.text = modeldata.nameEvent
        //tvbtSave.text = modeldata.btSave
        tvstartDay.text = modeldata.startDay
        tvstartTime.text = modeldata.startTime
        tvendDay.text = modeldata.endDay
        tvendTime.text = modeldata.endTime
        tvtextAdress.text = modeldata.textAdress
        tvtextDetail.text = modeldata.textDetail
        tvtextUnit.text = modeldata.textUnit

        return v
    }
}

