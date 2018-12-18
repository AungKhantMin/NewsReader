package akm.hades.newsreader

import java.io.Serializable


class NewsVO (title : String?, source :String, date : String, img : String, contents : String) : Serializable{
    var title: String? = title
    var source: String? = source
    var date : String? = date
    var img: String? = img
    var contents : String? = contents
}
