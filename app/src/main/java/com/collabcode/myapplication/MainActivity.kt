package com.collabcode.myapplication

import android.content.Intent
import android.content.pm.ApplicationInfo
import android.content.pm.PackageInfo
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.ListView
import com.collabcode.myapplication.Model.AppInfo
import com.collabcode.myapplication.arrayAdapter.MyAdapter
import java.util.ArrayList

class MainActivity : AppCompatActivity() {

    val mlist: ArrayList<AppInfo> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var tag:String
        tag = "Debug"
        val listView = findViewById<ListView>(R.id.listView)
        // You need to enable Nested Scrolling, otherwise list will not scroll
        listView.isNestedScrollingEnabled = true

        val rBtn = findViewById<Button>(R.id.button)


        scanningInstalled()
        var arrayAdapter : MyAdapter? = null
        arrayAdapter = MyAdapter(this,mlist)
        listView.adapter=arrayAdapter
        Log.v(tag,"Scanned")
        Log.v(tag, mlist.toString())

    }

    /*class LoadAppInfoTask(): AsyncTask<Integer, Integer, List<AppInfos>>()
    {
        override fun onPreExecute() {
            super.onPreExecute()
        }

        override fun doInBackground(vararg params: Integer?): List<AppInfos> {


        }

        override fun onPostExecute(result: List<AppInfos>?) {
            super.onPostExecute(result)
        }
    }*/



    public fun scanningInstalled(){
        var appinfo = packageManager.getInstalledPackages(0)
        for(i in 0 until appinfo.size){
            //this is for retrieving installed packages only. remove ! to retrieve all packages in if logic
            if(!packageManager(appinfo[i])) {
                val appName = appinfo[i].applicationInfo.loadLabel(packageManager).toString()
                val appVer = appinfo[i].versionName;
                val appIcon = appinfo[i].applicationInfo.loadIcon(packageManager)
                mlist.add(AppInfo(appName,appVer,appIcon))
                Log.v("Debug", appName )

            }
        }
    }
    fun packageManager(appinfo: PackageInfo):Boolean{
        return ((appinfo.applicationInfo.flags and ApplicationInfo.FLAG_SYSTEM)!=0)
    }
}