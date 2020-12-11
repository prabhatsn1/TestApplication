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
    /* No need for these variables */
//    public lateinit var appName : TextView
//    public lateinit var appVrsn : TextView
//    public lateinit var appIcn : ImageView


    /* These are methods used by system for calculation purpose
    *   This method tells the listview, how many items there are.
    * */

    override fun getCount(): Int {
        return arrayList.size
    }

    /*
    * This method is used to get an item at given position
    * */
    override fun getItem(position: Int): Any {
        return arrayList[position]
    }

    /*
    * Returns a unique id for each child. This id is used to uniquely identify
    * each data. App Name is not supposed to be unique, therefore you should add
    * package name to AppInfo. Otherwise if anyone has more than one app with same
    * name, listview will not render correctly
    * */
    override fun getItemId(position: Int): Long {
        return arrayList[position].appName.hashCode().toLong()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        // Listview tries to minimise the active number of inflated views. Suppose there
        // is 100 items, in such case listview does not create 100 childviews, because only
        // a part of views will be visible at one time on screen, say 10 views. Initially listview
        // creates some 10+ child views, then these views are recycled for different items.
        // convertView is provided by the listView, you need to check whether it is already valid.
        // If it is not null, you need not inflate a new view. Otherwise you need to inflate one.
        var inflatedView = convertView ?: LayoutInflater.from(context).inflate(R.layout.app_item_layout, parent, false)

        // get data of item at given position
        val data = getItem(position) as AppInfo

        // set view fields according to data at given position
        inflatedView.findViewById<TextView>(R.id.nameTextView).text = data.appName
        inflatedView.findViewById<TextView>(R.id.versionTextView).text = data.appVer
        inflatedView.findViewById<ImageView>(R.id.iconImageView).setImageDrawable(data.appIcon)
        return inflatedView
    }
}