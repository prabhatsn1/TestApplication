package com.collabcode.myapplication.arrayAdapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import com.collabcode.myapplication.Model.AppInfo
import com.collabcode.myapplication.R
import java.util.ArrayList

class MyAdapter(public val context: Context, public val arrayList: ArrayList<AppInfo>) : BaseAdapter()  {

    public lateinit var appName : TextView
    public lateinit var appVrsn : TextView
    public lateinit var appIcn : ImageView

    override fun getCount(): Int {
        TODO("Not yet implemented")
    }

    override fun getItem(position: Int): Any {
        TODO("Not yet implemented")
    }

    override fun getItemId(position: Int): Long {
        TODO("Not yet implemented")
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        var convertView = convertView
        convertView = LayoutInflater.from(context).inflate(R.layout.app_item_layout, parent, false)
        appName = convertView.findViewById(R.id.nameTextView)
        appVrsn = convertView.findViewById(R.id.versionTextView)
        appIcn = convertView.findViewById(R.id.iconImageView)
        return convertView
    }

}