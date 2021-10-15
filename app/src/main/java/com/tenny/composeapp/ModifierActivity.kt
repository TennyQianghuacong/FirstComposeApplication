package com.tenny.composeapp

import android.os.Bundle
import android.widget.ImageView
import android.widget.Toast
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.viewinterop.AndroidView
import androidx.lifecycle.viewmodel.compose.viewModel
import coil.compose.rememberImagePainter
import coil.load
import coil.transform.CircleCropTransformation

class ModifierActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val viewModel: MainViewModel by viewModels()
        setContent {
            Column(horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.fillMaxSize(1f)){

                ExampleCardView()
                Spacer(modifier = Modifier.size(5.dp))

                Count()
                Spacer(modifier = Modifier.size(5.dp))

                SizeExample()
                Spacer(modifier = Modifier.size(5.dp))

                NetWorkImage()
            }
        }


    }

    @Preview
    @Composable
    fun ExampleCardView() {
        val context = LocalContext.current
        Surface(shape = RoundedCornerShape(8.dp),
        elevation = 10.dp, modifier = Modifier.padding(5.dp)) {
            Row(
                modifier = Modifier
                    .clickable {
                        Toast
                            .makeText(context, "外圈被点击", Toast.LENGTH_SHORT)
                            .show()
                    }
                    .background(color = Color.Gray)
                    .padding(15.dp)

                    .clickable {
                        Toast
                            .makeText(context, "中圈", Toast.LENGTH_SHORT)
                            .show()
                    }
                    .background(color = Color.DarkGray)
                    .padding(20.dp)


                    .clickable {
                        Toast
                            .makeText(context, "内圈被点击", Toast.LENGTH_SHORT)
                            .show()
                    }
                    .background(color = Color.White)
                    .padding(10.dp)
                , horizontalArrangement = Arrangement.Center
                , verticalAlignment = Alignment.CenterVertically) {

                val viewModel: MainViewModel by viewModels()

                Text(text = "哟吼吼", fontSize = 16.sp)

                Spacer(modifier = Modifier.size(5.dp))

                Image(painter = painterResource(id = R.mipmap.avatar_2),
                    contentDescription = "image",
                    modifier = Modifier
                        .clip(CircleShape)
                        .size(90.dp)
                        .clickable {
                            Toast
                                .makeText(context, "图片被点击", Toast.LENGTH_SHORT)
                                .show()
                        })

                Spacer(modifier = Modifier.size(5.dp))

                Button(
                    onClick = {
                        viewModel.add()
                    },
                    elevation = ButtonDefaults.elevation(8.dp, 4.dp, 2.dp),
                    colors = ButtonDefaults.buttonColors()
                ) {
                    Text(text = "Button", fontSize = 20.sp, color = Color.White)
                }

            }
        }
    }

    @Preview
    @Composable
    fun Count() {
        Box(contentAlignment = Alignment.Center, modifier = Modifier
            .height(30.dp)
            .fillMaxWidth(0.5f)
            .background(color = Color.Cyan, shape = RoundedCornerShape(10.dp))) {
            val viewModel: MainViewModel = viewModel()
            Text(text = viewModel.buttonCount.value.toString(), fontSize = 20.sp)
        }
    }

    @Preview
    @Composable
    fun SizeExample() {
        Box(modifier = Modifier.background(color = Color.Black)
            .size(20.dp)
            .fillMaxSize()
        ) {
            
        }
    }

    @Composable
    fun NetWorkImage() {
        Row() {
            Image(painter = rememberImagePainter(data = "https://picsum.photos/300/300",
                builder = {crossfade(true).placeholder(R.drawable.ic_launcher_background)}),
                contentDescription = "NetImage", modifier = Modifier.size(100.dp))

            Spacer(modifier = Modifier.width(10.dp))
            AndroidView({ ImageView(this@ModifierActivity)}, modifier = Modifier.size(100.dp)){ it ->
                it.load("https://picsum.photos/300/300") {
                    placeholder(R.drawable.ic_launcher_background).transformations(CircleCropTransformation())
                }
            }
        }
    }

}
