package th.ac.kku.cis.mobileapp.stuactivity.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.list_item.view.*
import th.ac.kku.cis.mobileapp.stuactivity.Model.Event
import th.ac.kku.cis.mobileapp.stuactivity.R

class Events_Adapter(private val eventslist:List<Event>): RecyclerView.Adapter<Events_Adapter.EventViewHolder>(){
    private val TAG = "Comic"
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EventViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.list_item,
        parent,false)
        return EventViewHolder(itemView)
    }

    override fun getItemCount() = eventslist.size


    override fun onBindViewHolder(holder: EventViewHolder, position: Int) {
        val currentItem = eventslist[position]
        holder.Event_name.text = currentItem.Event_name
        holder.Time_Start.text = currentItem.Time_Start
        holder.Time_End.text = currentItem.Time_End
        holder.Unit_Activity.text = currentItem.Unit_Activity

        holder.itemView.setOnClickListener{

        }

    }


    class EventViewHolder(itemView : View):RecyclerView.ViewHolder(itemView) {
        val Event_name:TextView = itemView.Activity_name
        val Time_Start:TextView = itemView.time_start
        val Time_End:TextView = itemView.time_end
        val Unit_Activity:TextView = itemView.Unit_Activity
    }

}
