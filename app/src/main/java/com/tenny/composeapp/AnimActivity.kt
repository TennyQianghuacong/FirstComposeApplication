package com.tenny.composeapp

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.layout.Column
import com.tenny.composeapp.view.custom.AnimFavorite
import com.tenny.composeapp.view.custom.AnimSend
import com.tenny.composeapp.view.custom.AnimTransitionFavorite
import com.tenny.composeapp.view.custom.AnimVisibility

/**
 * Description:
 * Created by TennyQ
 * on 2021/10/10
 */
class AnimActivity : AppCompatActivity() {

    @ExperimentalAnimationApi
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Column {
                AnimFavorite()
                AnimSend()
                AnimTransitionFavorite()
                AnimVisibility()
            }
        }
    }

}