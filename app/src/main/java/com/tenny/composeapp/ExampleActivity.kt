package com.tenny.composeapp

import android.os.Bundle
import android.widget.Toast
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.tenny.composeapp.ui.theme.Purple200
import com.tenny.composeapp.view.InfoList

/**
 * Description:初步示例
 * Created by TennyQ
 * on 2021/10/14
 */
@ExperimentalComposeUiApi
class ExampleActivity: AppCompatActivity() {

    @ExperimentalMaterialApi
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val viewModel: MainViewModel by viewModels()
        setContent {
            Column(horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.fillMaxSize(1f).background(color = Color.Gray)){
                ExampleText()
                SearchView()
                InfoCard()
                InfoList(msgList = viewModel.messageList)
                InfoList(msgList = viewModel.messageList, isVertical = false)

            }
        }
    }

    @Composable
    fun ExampleText() {
        Text(text = "我是Compose文字控件", color = Purple200, fontSize = 25.sp, textAlign = TextAlign.Start,
        modifier = Modifier.fillMaxWidth())
    }

    @ExperimentalComposeUiApi
    @Composable
    fun SearchView() {
        var input by remember {
            mutableStateOf("")
        }

        TextField(
            value = input,
            onValueChange = {
                input = it
            },
            colors = TextFieldDefaults.textFieldColors(
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent,
                backgroundColor = Color.Transparent,
                cursorColor = Color.Black
            ),
            placeholder = { Text(text = "我是Compose输入控件")},
            modifier = Modifier
                .fillMaxWidth()
                .border(
                    width = 2.dp,
                    color = Color.Black, shape = RoundedCornerShape(20.dp)
                ),
            shape = RoundedCornerShape(20.dp),
        )
    }

    @ExperimentalMaterialApi
    @Composable
    fun InfoCard(){
        val context = LocalContext.current
        Card(shape = RoundedCornerShape(8.dp),
            elevation = 8.dp,
            modifier = Modifier
                .fillMaxWidth()
                .padding(15.dp)
        ) {
            Column(modifier = Modifier
                .padding(5.dp)
                .padding(10.dp)) {
                Text(buildAnnotatedString {
                    append("欢迎来到")
                    withStyle(style = SpanStyle(color = Color.Blue)){
                        append("Card")
                    }
                    append("示例")
                })

                Text(buildAnnotatedString {
                    append("现在看到的是")
                    withStyle(style = SpanStyle(fontWeight = FontWeight.SemiBold, color = Color.Blue)){
                        append("Card实现CardView阴影 Card实现CardView阴影 Card实现CardView阴影")
                    }
                    append("效果")
                },
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis,
                    modifier = Modifier.clickable(indication = null, interactionSource = MutableInteractionSource()) {
                    Toast.makeText(context, "被点击了", Toast.LENGTH_SHORT).show()
                })

            }
        }
    }

}