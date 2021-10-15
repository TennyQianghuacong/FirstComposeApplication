package com.tenny.composeapp

import android.os.Bundle
import android.widget.TextView
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.layout.Column
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.unit.sp
import androidx.compose.ui.viewinterop.AndroidView

/**
 * Description:Compose与原生View的混合使用
 * Created by TennyQ
 * on 2021/10/14
 */
class MixtureActivity: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    //    composeInXml()

        setContent {
            viewInCompose()
        }
    }

    /**
     * 在xml里添加ComposeView
     */
    private fun composeInXml() {
        setContentView(R.layout.activity_main)

        val androidCompose: ComposeView = findViewById<ComposeView>(R.id.compose_view)
        androidCompose.setContent {
            Text(text = "compose text view", fontSize = 30.sp)
        }
    }

    @Composable
    private fun viewInCompose() {
        Column {
            Text(text = "compose text view")
            AndroidView({ TextView(this@MixtureActivity) }){ it ->
                it.text = "textView"
            }
        }
    }

}