package com.tenny.composeapp.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.tenny.composeapp.MainViewModel
import com.tenny.composeapp.data.MessageEntity

/**
 * Description:列表
 * Created by TennyQ
 * on 2021/9/30
 */

@Composable
fun InfoList(msgList: List<MessageEntity>, isVertical: Boolean = true) {
    if (isVertical) {
        LazyColumn(modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight(0.7f)
            .background(color = Color.White)){
            itemsIndexed(msgList) { index, item ->
                InfoItem(message = item)
                if (index < msgList.size - 1) {
                    Divider( thickness = 1.dp,color = Color.White)
                }
            }
        }
    } else {
        LazyRow(modifier = Modifier
            .fillMaxWidth()
            .background(color = Color.White)){
            itemsIndexed(msgList) { index, item ->
                HorizontalInfoItem(message = item)
                if (index < msgList.size - 1) {
                    Divider( thickness = 1.dp,color = Color.White)
                }
            }
        }
    }

}

@Composable
fun InfoItem(message: MessageEntity) {
    Card(shape = RoundedCornerShape(8.dp),
        elevation = 5.dp,
        modifier = Modifier
            .fillMaxWidth()
            .padding(15.dp)) {
        Row(modifier = Modifier
            .background(color = Color.White)
            .fillMaxWidth(1f)
            .padding(10.dp, 8.dp)
            , verticalAlignment = Alignment.CenterVertically) {
            Image(painter = painterResource(id = message.avatar),
                contentDescription = "avatar",
                modifier = Modifier
                    .size(55.dp)
                    .clip(RoundedCornerShape(5.dp)))

            Column(modifier = Modifier
                .fillMaxSize()
                .padding(8.dp, 0.dp, 0.dp, 0.dp)) {
                Text(text = message.name, fontSize = 15.sp, color = Color.DarkGray)
                Spacer(modifier = Modifier.height(5.dp))
                Text(text = message.msg, fontSize = 13.sp, color = Color.Gray)
            }
        }
    }

}

@Composable
fun HorizontalInfoItem(message: MessageEntity) {
    Card(shape = RoundedCornerShape(8.dp),
        elevation = 5.dp,
        modifier = Modifier
            .width(300.dp)
            .padding(15.dp)) {
        Row(modifier = Modifier
            .background(color = Color.White)
            .fillMaxWidth(1f)
            .padding(10.dp, 8.dp)
            , verticalAlignment = Alignment.CenterVertically) {
            Image(painter = painterResource(id = message.avatar),
                contentDescription = "avatar",
                modifier = Modifier
                    .size(55.dp)
                    .clip(RoundedCornerShape(5.dp)))

            Column(modifier = Modifier
                .height(70.dp)
                .padding(8.dp, 0.dp, 0.dp, 0.dp)) {
                Text(text = message.name, fontSize = 15.sp, color = Color.DarkGray)
                Spacer(modifier = Modifier.height(5.dp))
                Text(text = message.msg, fontSize = 13.sp, color = Color.Gray)
            }
        }
    }

}
