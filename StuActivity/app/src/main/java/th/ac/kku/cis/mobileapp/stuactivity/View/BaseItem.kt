package th.ac.kku.cis.mobileapp.stuactivity.View

class BaseItem {
    private var type = 0

    fun BaseItem(type: Int) {
        this.type = type
    }

    fun getType(): Int {
        return type
    }
}