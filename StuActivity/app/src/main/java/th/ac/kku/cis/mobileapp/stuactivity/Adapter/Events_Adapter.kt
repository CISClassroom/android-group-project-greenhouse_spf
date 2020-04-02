package th.ac.kku.cis.mobileapp.stuactivity.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.list_item.view.*
import th.ac.kku.cis.mobileapp.stuactivity.Model.Event
import th.ac.kku.cis.mobileapp.stuactivity.Model.modelsave
import th.ac.kku.cis.mobileapp.stuactivity.R

class Events_Adapter(val mCtx: Context,var resource:Int,private val items:List<Event>): RecyclerView.Adapter<Events_Adapter.EventViewHolder>(){
    private val TAG = "Comic"
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EventViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.list_item,
        parent,false)
        return EventViewHolder(itemView)
    }

    override fun getItemCount() = items.size


    override fun onBindViewHolder(holder: EventViewHolder, position: Int) {
        val currentItem = items[position]
        holder.nameEvent.text = currentItem.nameEvent
        holder.startDay.text = currentItem.startDay
        holder.endDay.text = currentItem.endDay
        holder.textUnit.text = currentItem.textUnit

        holder.itemView.setOnClickListener{

        }

    }



    class EventViewHolder(itemView : View):RecyclerView.ViewHolder(itemView) {
        val nameEvent:TextView = itemView.nameEvent
        val startDay:TextView = itemView.startDay
        val endDay:TextView = itemView.endDay
        val textUnit:TextView = itemView.textUnit
    }

}
