package com.hirauchi.fortune

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.gms.oss.licenses.OssLicensesMenuActivity

class AppInfoActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_app_info)

        val listView = findViewById<ListView>(R.id.list_view)
        val itemList = arrayOf(getString(R.string.app_info_privacy), getString(R.string.app_info_oss), getString(R.string.app_info_version))
        val adapter = ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, itemList)
        listView.adapter = adapter

        val version = packageManager?.getPackageInfo(packageName, 0)?.versionName
        listView.setOnItemClickListener { _, _, position, _ ->
            when (position) {
                0 -> startActivity(Intent(Intent.ACTION_VIEW, Uri.parse("https://hirauchi-genta.com/?page_id=17")))
                1 -> startActivity(Intent(this, OssLicensesMenuActivity::class.java))
                2 -> Toast.makeText(this, version, Toast.LENGTH_SHORT).show()
            }
        }
    }

    override fun onResume() {
        super.onResume()

        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_FULLSCREEN
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return super.onSupportNavigateUp()
    }
}