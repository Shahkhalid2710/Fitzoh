package com.applocum.fitzoh.ui.home.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import com.applocum.fitzoh.Dbhelper
import com.applocum.fitzoh.R
import com.applocum.fitzoh.ui.home.adapters.RecyclerAdapterBlog
import com.applocum.fitzoh.ui.home.models.Blog
import kotlinx.android.synthetic.main.activity_blogs.*

class BlogsActivity : AppCompatActivity() {
    private var mListBlogs:ArrayList<Blog> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_blogs)
        val dbhelper=Dbhelper(this)
        ivBack.setOnClickListener {
            finish()
        }

        mListBlogs=dbhelper.getblog()
        val blog=Blog()
        rvBlog.layoutManager=LinearLayoutManager(this)
        rvBlog.adapter=RecyclerAdapterBlog(this,mListBlogs,object:RecyclerAdapterBlog.CellClickListener{
            override fun onCellClickistener(myobject: Blog, position: Int) {
                val intent= Intent(this@BlogsActivity,BlogActivity::class.java)
                intent.putExtra("blog",myobject)
                intent.putExtra("position",position)
                startActivity(intent)
            }
        })
    }
}