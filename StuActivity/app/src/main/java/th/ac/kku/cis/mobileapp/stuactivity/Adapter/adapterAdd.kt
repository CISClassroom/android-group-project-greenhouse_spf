package th.ac.kku.cis.mobileapp.stuactivity.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView
import th.ac.kku.cis.mobileapp.stuactivity.Model.modelsave
import th.ac.kku.cis.mobileapp.stuactivity.R

public class adapterAdd (val mCtx: Context,
                         var resource:Int,
                         var items:List<modelsave>): ArrayAdapter<modelsave>(mCtx,resource,items) {
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        //return super.getView(position, convertView, parent)
        val layout: LayoutInflater = LayoutInflater.from(mCtx)

        val v: View = layout.inflate(resource,null)

        val tvNamestudent : TextView = v.findViewById(R.id.Namestudent)
        val tvNumberstudent : TextView = v.findViewById(R.id.Numberstudent)


        val modeldata :modelsave = items[position]

        tvNamestudent.text = modeldata.textNamestudent
        tvNumberstudent.text = modeldata.textNumberstudent

        return v
    }
}
