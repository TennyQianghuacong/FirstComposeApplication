package com.tenny.composeapp

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.MutableLiveData
import com.tenny.composeapp.view.custom.CustomColumn
import com.tenny.composeapp.view.custom.drawBackground
import com.tenny.composeapp.view.custom.firstBaselineToTop

/**
 * Description:自定义View
 * Created by TennyQ
 * on 2021/10/14
 */
class CustomActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val number = mutableStateOf(1)
        val numberList = mutableStateListOf(1)

        val liveNumber = MutableLiveData(7)


        //var numberLD = liveNumbr
        setContent {
            val liveNumberState by liveNumber.observeAsState()

            CustomColumn(modifier = Modifier.verticalScroll(rememberScrollState())) {
                Button(onClick = {
                    number.value += 1
                    numberList.add(numberList.last() + 1)
                }) {
                    Text(text = number.value.toString())
                }

                for (element in numberList) {
                    Text(text = "第 $element 个数字", modifier = Modifier.firstBaselineToTop(24.dp).drawBackground(Color.Gray))
                }
            //    PasswordInput()
            }
        }
    }

    @Preview
    @Composable
    fun TextExam() {
        Text(text = "第 1 个数字", fontSize = 30.sp)
    }


    @Composable
    fun PasswordInput() {
        var showPassword by remember { mutableStateOf(false) }
        var passwordValue by remember { mutableStateOf("") }

        TextField(value = passwordValue,
            onValueChange = { it ->
                passwordValue = it
            },
            trailingIcon = {
                IconButton(onClick = { showPassword = !showPassword }) {
                    Icon(painter = painterResource(id = if (showPassword) R.mipmap.icon_pwd_invisible else R.mipmap.icon_pwd_visible), contentDescription = "密码可见")
                }
            },
            label = {
                "密码"
            },
            visualTransformation = if (showPassword) PasswordVisualTransformation() else VisualTransformation.None
        )
    }


    @Preview
    @Composable
    fun PreviewPasswordInput() {
        PasswordInput()
    }



}
