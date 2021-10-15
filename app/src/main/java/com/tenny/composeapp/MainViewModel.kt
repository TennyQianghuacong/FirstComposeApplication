package com.tenny.composeapp

import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateMapOf
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.tenny.composeapp.data.MessageEntity

/**
 * Description:
 * Created by TennyQ
 * on 2021/9/30
 */
class MainViewModel: ViewModel() {
    fun add() {
        buttonCount.value = buttonCount.value + 1
    }

    val buttonCount = mutableStateOf(0)

    val messageList = mutableStateListOf(
        MessageEntity(msg = "眼睛稍呈三角形，深陷，朝着耳朵的外耳根部向上倾斜", name = "柴犬", avatar = R.mipmap.avatar_1),
        MessageEntity(msg = "耳中等大小，直立，耳尖呈圆形，棕褐色眼睛中等大小，呈卵圆形。", name = "柯基", avatar = R.mipmap.avatar_2),
        MessageEntity(msg = "耳朵三角形，小而且牢固地竖立，但和头及身体大小相称。", name = "柴犬", avatar = R.mipmap.avatar_1),
        MessageEntity(msg = "眼睛中等大小，不突出，眼圈为暗黑色，眼角清晰。", name = "柯基", avatar = R.mipmap.avatar_2),
        MessageEntity(msg = "嘴唇紧而黑，鼻子为黑色。", name = "柴犬", avatar = R.mipmap.avatar_1),
        MessageEntity(msg = "嘴鼻部优美且紧凑，缺毛，为先天性特征。", name = "柯基", avatar = R.mipmap.avatar_2),
        MessageEntity(msg = "四肢骨料粗壮，强健有力，站立姿势好，后肢大腿肌肉丰满。", name = "柴犬", avatar = R.mipmap.avatar_1),
        MessageEntity(msg = "胸部宽度适中，向下逐渐变细，在前肢之间放松。", name = "柯基", avatar = R.mipmap.avatar_2)
    )

    val object1 = mutableStateMapOf<Int, String>()

}