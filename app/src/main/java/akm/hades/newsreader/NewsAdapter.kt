package akm.hades.newsreader

import android.os.StrictMode
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.activity_main.view.*

class NewsAdapter(list : List<NewsVO>?, size : Int, mainActivity: MainActivity) : RecyclerView.Adapter<NewsViewHolder>() {
    private var data = list
    private var size = size
    private var mainActivity = mainActivity

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): NewsViewHolder {
        StrictMode.enableDefaults()
        val view = LayoutInflater.from(p0.context).inflate(R.layout.activity_main,p0,false)
        return NewsViewHolder(view)
    }

    override fun getItemCount(): Int {
           return size
    }

    override fun onBindViewHolder(p0: NewsViewHolder, p1: Int) {
        p0.itemView.tv_titles.setOnClickListener{
            mainActivity.startActivity(ReadArticles.newIntent(mainActivity,data!![p1]))
        }
        p0.bind(data!![p1])
    }
}

class NewsViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
    fun bind(data : NewsVO){
        itemView.tv_source.text = data.source
        itemView.tv_release_date.text = data.date
        itemView.tv_titles.text = data.title
        Glide.with(itemView).load(data.img).into(itemView.iv_news_image)


    }
}



