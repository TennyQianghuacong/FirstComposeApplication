package com.tenny.composeapp

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

/**
 * Description:Recompose
 * Created by TennyQ
 * on 2021/10/14
 */
class RecomposeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Column(modifier = Modifier.fillMaxSize()) {
                Recompose1()
                Recompose2()
                Recompose3()
                Recompose4()
            }
        }
    }

    @Composable
    fun Recompose1() {
        Box(contentAlignment = Alignment.Center, modifier = Modifier
            .fillMaxWidth()
            .height(50.dp)) {
            val name = mutableStateOf("xixixi")
            Text(text = name.value, fontSize = 30.sp)
            lifecycleScope.launch{
                delay(3000)
                name.value = "嘻嘻嘻"
            }
        }
    }


    @Composable
    fun Recompose2() {
        Box(contentAlignment = Alignment.Center, modifier = Modifier
            .fillMaxWidth()
            .height(50.dp)) {
            var name by remember{
                mutableStateOf("xixixi")
            }
            Text(text = name, fontSize = 30.sp)
            lifecycleScope.launch{
                delay(3000)
                name = "嘻嘻嘻"
            }
        }
    }

    @Composable
    fun Recompose3() {
        Box(contentAlignment = Alignment.Center, modifier = Modifier
            .fillMaxWidth()
            .height(50.dp)) {
            var name by remember{
                mutableStateOf(1)
            }
            Text(text = name.toString(), fontSize = 30.sp)
            lifecycleScope.launch{
                delay(3000)
                name += 1
            }
        }
    }

    @Composable
    fun Recompose4() {
        Box(contentAlignment = Alignment.Center, modifier = Modifier
            .fillMaxWidth()
            .height(50.dp)) {
            var name by remember{
                mutableStateOf(1)
            }
            var key by remember {
                mutableStateOf(true)
            }
            Text(text = name.toString(), fontSize = 30.sp,
            modifier = Modifier.clickable {
                key = !key
            })
            LaunchedEffect(key){
             //   delay(3000)
                name += 1
            }
        }
    }

}