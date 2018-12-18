package akm.hades.newsreader

import android.content.Context
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.app.ActionBar
import android.view.View
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.activity_main.view.*
import kotlinx.android.synthetic.main.activity_read_articles.*

class ReadArticles : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_read_articles)
        val data = intent.extras.get("data") as NewsVO

        tv_read_title.text = data.title
        tv_read_contents.text = data.contents
        Glide.with(this).load(data.img).into(this.iv_read_image)
        title = data.title
       
    }

    companion object {
        fun newIntent(context: Context, newsVO: NewsVO): Intent{
            val intent =  Intent(context, ReadArticles::class.java)
            intent.putExtra("data",newsVO)
            return intent
        }
    }
}
