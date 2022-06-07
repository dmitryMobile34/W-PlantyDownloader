package com.newgenepsilumx.plantyoveralldownloader

import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.raw_vp_item.view.*



class ViewPagerAdapter: RecyclerView.Adapter<PagerVH>() {

    private val backs = intArrayOf(
        R.drawable.imgpreview,
        R.drawable.gifpreview
    )

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PagerVH =
        PagerVH(LayoutInflater.from(parent.context).inflate(R.layout.raw_vp_item, parent, false))


    override fun getItemCount(): Int = backs.size

    override fun onBindViewHolder(holder: PagerVH, position: Int) = holder.itemView.run {

        var testVar = backs[position]
        imageView.setBackgroundResource(backs[position])

        imageView.setOnClickListener {

            var mContext = it.context

            if (backs[position] == 2131165294) {
                val myIntent = Intent(mContext, ImgManager::class.java)
                mContext.startActivity(myIntent)
                Log.wtf("devx", "clicked 0")
            } else if (backs[position] == 2131165285) {
                val myIntent = Intent(mContext, GifManager::class.java)
                mContext.startActivity(myIntent)
                Log.wtf("devx", "clicked 1")
            }


        }
    }
}

class PagerVH(itemView: View) : RecyclerView.ViewHolder(itemView)

