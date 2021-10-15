package com.tenny.composeapp

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import com.tenny.composeapp.view.ExampleMeasure

/**
 * Description:测量
 * Created by TennyQ
 * on 2021/10/14
 */
class MeasureActivity: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.example_layout)

       /* setContent {
            ExampleMeasure()
        }*/
    }

}