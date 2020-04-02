package th.ac.kku.cis.mobileapp.stuactivity.Model

class modelsave {
    companion object Factory { // สร้างเมดทอนแบบย่อ ๆ
        fun create(): modelsave = modelsave()
    }
    var id:String?=null
    var nameEvent:String?=null
    //var btSave:String?=null
    var startDay:String?=null
    var startTime:String?=null
    var endDay:String?=null
    var endTime:String?=null
    var textAdress:String?=null
    var textDetail:String?=null
    var textUnit:String?=null
}