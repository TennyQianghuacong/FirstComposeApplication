package com.tenny.composeapp

import android.content.Intent
import android.content.pm.PackageManager
import android.os.Bundle
import android.view.ViewGroup
import android.view.ViewGroup.LayoutParams.MATCH_PARENT
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatButton

/**
 * Description:
 * Created by TennyQ
 * on 2021/10/14
 */
class MainActivity: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        LinearLayout(this).apply {
            layoutParams = ViewGroup.LayoutParams(MATCH_PARENT, MATCH_PARENT)
            orientation = LinearLayout.VERTICAL
            setContentView(this)

            packageManager.getPackageInfo(packageName, PackageManager.GET_ACTIVITIES).activities
                .filterNot { it.name == this@MainActivity::class.java.name}
                .map { Class.forName(it.name) }
                .forEach { clazz ->
                    this.addView(AppCompatButton(this@MainActivity).apply {
                        isAllCaps = false
                        text = clazz.simpleName
                        setOnClickListener {
                            startActivity(Intent(this@MainActivity, clazz))
                        }
                    })
                }
        }
    }

}