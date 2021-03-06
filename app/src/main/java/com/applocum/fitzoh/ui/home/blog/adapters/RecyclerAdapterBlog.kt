package com.applocum.fitzoh.ui.home.blog.adapters

import android.content.Context
import android.content.Intent
import android.os.Build
import android.text.SpannableString
import android.text.Spanned
import android.text.TextPaint
import android.text.method.LinkMovementMethod
import android.text.style.ClickableSpan
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.annotation.RequiresApi
import androidx.recyclerview.widget.RecyclerView
import com.applocum.fitzoh.R
import com.applocum.fitzoh.ui.home.blog.activities.BlogActivity
import com.applocum.fitzoh.ui.home.blog.models.Blog
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.raw_blog_xml.view.*

class RecyclerAdapterBlog(context: Context, list: ArrayList<Blog>, private var cellClickListener: CellClickListener) :RecyclerView.Adapter<RecyclerAdapterBlog.BlogHolder>(){
    var mContext=context
    private var mList=list

    inner class BlogHolder(itemView: View):RecyclerView.ViewHolder(itemView){}
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BlogHolder {
      val v = LayoutInflater.from(mContext).inflate(R.layout.raw_blog_xml,parent,false)
        return BlogHolder(v)
    }

    override fun getItemCount(): Int {
        return mList.size
    }

    override fun onBindViewHolder(holder: BlogHolder, position: Int) {
        val blog= mList[position]
        holder.itemView.tvLevel.text=blog.bLevel
        holder.itemView.tvDescription.text=blog.bDescription
        holder.itemView.ivNext.visibility=View.GONE
        Glide.with(mContext).load(blog.bImage).into(holder.itemView.ivLevel)

        holder.itemView.setOnClickListener {
            val intent=Intent(mContext,
                BlogActivity::class.java)
            mContext.startActivity(intent)
        }
        holder.itemView.setOnClickListener{

            cellClickListener.onCellClickistener(blog,position)
        }
        addReadMore("Lorem ipsum dolor sit amet, consectetur adipiscing elit. Quisque vitae pellentesque lacus, sagittis interdum???",holder.itemView.tvDescription)
    }
    interface CellClickListener
    {
        fun onCellClickistener(myobject: Blog, position: Int)
    }
    private fun addReadMore(text: String, textView: TextView) {
        val ss = SpannableString(text.substring(0,70) + "... Read more")
        val clickableSpan: ClickableSpan = object : ClickableSpan() {
            override fun onClick(view: View) {
                addReadLess(text, textView)
            }

            @RequiresApi(Build.VERSION_CODES.M)
            override fun updateDrawState(ds: TextPaint) {
                super.updateDrawState(ds)
                ds.isUnderlineText = false
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                    ds.color = mContext.resources.getColor(R.color.bluee,mContext.theme)
                } else {
                    ds.color = mContext.resources.getColor(R.color.bluee,mContext.theme)
                }
            }
        }
        ss.setSpan(clickableSpan, ss.length - 10, ss.length, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE)
        textView.text = ss
        textView.movementMethod = LinkMovementMethod.getInstance()
    }

    private fun addReadLess(text: String, textView: TextView) {
        val ss = SpannableString("$text Read less")
        val clickableSpan: ClickableSpan = object : ClickableSpan() {
            override fun onClick(view: View) {
                addReadMore(text, textView)
            }

            @RequiresApi(Build.VERSION_CODES.M)
            override fun updateDrawState(ds: TextPaint) {
                super.updateDrawState(ds)
                ds.isUnderlineText = false
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                    ds.color = mContext.resources.getColor(R.color.bluee,mContext.theme)
                } else {
                    ds.color = mContext.resources.getColor(R.color.bluee,mContext.theme)
                }
            }
        }
        ss.setSpan(clickableSpan, ss.length - 10, ss.length, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE)
        textView.text = ss
        textView.movementMethod = LinkMovementMethod.getInstance()
    }
}