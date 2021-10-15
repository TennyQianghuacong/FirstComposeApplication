package com.tenny.composeapp.view

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

/**
 * Description:
 * Created by TennyQ
 * on 2021/10/10
 */

@Composable
fun ExampleMeasure() {
    Row(modifier = Modifier.background(color = Color.White)/*.width(IntrinsicSize.Min).height(IntrinsicSize.Min)*/
        ) {
        Text(text = "文本1",
            fontSize = 20.sp,
            modifier = Modifier
                .weight(weight = 1f)
                .wrapContentWidth(Alignment.CenterHorizontally))

        Spacer(modifier = Modifier.background(color = Color.Black)
            .width(2.dp)
            .fillMaxHeight())
        
        Text(text = "文本2",
            fontSize = 20.sp,
            modifier = Modifier
                .weight(weight = 1f)
                .wrapContentWidth(Alignment.CenterHorizontally))
    }
}

@Preview
@Composable
fun PreviewExampleMeasure() {
    ExampleMeasure()
}