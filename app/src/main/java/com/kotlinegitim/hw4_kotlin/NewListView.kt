package com.kotlinegitim.hw4_kotlin

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.view.View
import android.view.ViewGroup



import android.widget.ImageView
import android.widget.TextView
import android.widget.Adapter
import android.widget.ArrayAdapter
import androidx.constraintlayout.widget.ConstraintSet.Layout
import com.bumptech.glide.Glide

class NewListView( private val context: Activity, private val layout_int : Int, private val list:List<New> ) : ArrayAdapter<New>(context, layout_int,list) {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {


        //val view = super.getView(position, convertView, parent)
        val WebCustomLayout = context.layoutInflater.inflate(layout_int,null,true)

        val NewText = WebCustomLayout.findViewById<TextView>(R.id.newText)
        val NewImage = WebCustomLayout.findViewById<ImageView>(R.id.new_image)

        var new = list.get(position)

        NewText.text = new.title
        Glide.with(context).load(new.img).into(NewImage)


        //NewImage.setImageResource(R.drawable.ic_launcher_background)

        if (WebCustomLayout != null) {
            WebCustomLayout.setOnClickListener(object : View.OnClickListener {
                override fun onClick(v: View?) {
                    val intent = Intent(context,DetailNew::class.java)


                    intent.putExtra("href", new.href )

                    context.startActivity(intent)

                }
            })
        }





        return WebCustomLayout
    }


}