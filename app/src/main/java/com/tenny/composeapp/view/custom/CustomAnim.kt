package com.tenny.composeapp.view.custom

import androidx.compose.animation.*
import androidx.compose.animation.core.*
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Favorite
import androidx.compose.material.icons.rounded.Send
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

/**
 * Description:
 * Created by TennyQ
 * on 2021/10/9
 */
@Composable
fun AnimFavorite() {
    var big by remember {
        mutableStateOf(true)
    }

    val size by animateDpAsState(targetValue = if (big) 32.dp else 24.dp, spring(Spring.DampingRatioHighBouncy))
    val color by animateColorAsState(targetValue = if(big) Color.Red else Color.Gray, tween(durationMillis = 500))

    IconButton(onClick = { big = !big }) {
        Icon(Icons.Rounded.Favorite, contentDescription = null, modifier = Modifier.size(size), tint = color)
    }
}

@Preview
@Composable
fun PreviewAnimFavorite() {
    AnimFavorite()
}

/************************ Animatable ************************/

@Composable
fun AnimSend() {
    var big by remember {
        mutableStateOf(true)
    }

    val anim = remember {
        Animatable(32.dp, Dp.VectorConverter)
    }
    LaunchedEffect(big) {
        anim.snapTo(if (big) 48.dp else 12.dp)
        anim.animateTo(if (big) 24.dp else 32.dp, tween(durationMillis = 500, delayMillis = 200))
    }
    IconButton(onClick = { big = !big }) {
        Icon(Icons.Rounded.Send, contentDescription = null, modifier = Modifier.size(anim.value), tint = Color.Blue)
    }
}

@Preview
@Composable
fun PreviewAnimSend() {
    AnimSend()
}

/************************ Transition ************************/
@Composable
fun AnimTransitionFavorite() {
    var big by remember {
        mutableStateOf(true)
    }
    val bigTransition = updateTransition(big, label = "点赞")
    val size by bigTransition.animateDp(label = "大小", targetValueByState =  {if (it) 32.dp else 24.dp})
    val color by bigTransition.animateColor(label = "颜色", targetValueByState =  {if (it) Color.Red else Color.Gray})

    IconButton(onClick = { big = !big }) {
        Icon(Icons.Rounded.Favorite, contentDescription = null, modifier = Modifier.size(size), tint = color)
    }
}

@Preview
@Composable
fun PreviewAnimTransitionFavorite() {
    AnimTransitionFavorite()
}

@ExperimentalAnimationApi
@Composable
fun AnimVisibility() {
    var show by remember {
        mutableStateOf(true)
    }
    Column(
        modifier = Modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ){
        AnimatedVisibility(visible = show, enter = slideInVertically(
            initialOffsetY = {-1000},
            animationSpec = tween(1200)
        )) {
            Text(
                text = "这是一个普通的正文",
                fontWeight = FontWeight.W900,
                style = MaterialTheme.typography.h5
            )
        }
        Spacer(Modifier.padding(vertical = 50.dp))
        Button(onClick = {show = !show}) {
            Text(if(show) "隐藏" else "显示")
        }
    }
}