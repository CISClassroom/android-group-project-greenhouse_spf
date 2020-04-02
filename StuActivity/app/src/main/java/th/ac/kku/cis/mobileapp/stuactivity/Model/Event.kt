package th.ac.kku.cis.mobileapp.stuactivity.Model

data class Event(
    var Event_name:String,
    var Day_Start: String,
    var Day_End: String?="",
    var Time_Start: String,
    var Time_End: String,
    var location: String,
    var detail: String,
    var Unit_Activity: String){

    fun toMap(): Map<String, Any> {
        val result = HashMap<String, Any>()
        result.put("Event_name", Event_name!!)
        result.put("Day_Start", Day_Start!!)
        result.put("Day_End", Day_End!!)
        result.put("Time_Start", Time_Start!!)
        result.put("Time_End", Time_End!!)
        result.put("location", location!!)
        return result
    }
}



//java
//var Event_name:String?=null
//var Day_Start:String?=null
//var Day_End:String?=null
//var Time_Start:String?=null
//var Time_End:String?=null
//var location:String?=null
//var detail:String?=null
//var Unit_Activity:String?=null

//constructor(
//// Default constructor required for calls to DataSnapshot.getValue(Event.class)
//) {
//    this.Event_name = Event_name
//    this.Day_Start = Day_Start
//    this.Day_End = Day_End
//    this.Time_Start = Time_Start
//    this.Time_End = Time_End
//    this.location = location
//    this.detail = detail
//    this.Unit_Activity = Unit_Activity
//}