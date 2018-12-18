package akm.hades.newsreader

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.StrictMode
import android.support.v7.widget.LinearLayoutManager
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.news_list.*
import org.json.JSONArray
import org.json.JSONObject

class MainActivity : AppCompatActivity() {

    private var total : Int = 0
    private  lateinit var articales : JSONArray
    private lateinit var newsVO: NewsVO
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        StrictMode.enableDefaults()
        setContentView(R.layout.news_list)
        val jsonParse = JsonParse()
        val res = jsonParse.getJson()
        if (res != null){
            val mAdapter = NewsAdapter(jsonToList(res), total,this)
            rv_news.layoutManager = LinearLayoutManager(applicationContext)
            rv_news.adapter = mAdapter
        }
        else{
            Toast.makeText(this,"Internet Connection Is Required",Toast.LENGTH_SHORT).show()
        }


    }

    fun jsonToList(jsonObject: JSONObject) : List<NewsVO>?{
        articales = jsonObject.getJSONArray("articles")
        total = articales.length()-1
        val list = ArrayList<NewsVO>()
        for ( x in 0 until articales.length()-1 ){
            val date = JSONObject(articales[x].toString()).getString("publishedAt")
            val title = JSONObject(articales[x].toString()).getString("title")
            val source = JSONObject(articales[x].toString()).getJSONObject("source").getString("name")
            val imgurl = JSONObject(articales[x].toString()).getString("urlToImage")
            val contents = JSONObject(articales[x].toString()).getString("content")
            newsVO = NewsVO(title,source,date,imgurl,contents)
            list.add(NewsVO(title,source,date,imgurl,contents))
        }
        return list
    }

}
