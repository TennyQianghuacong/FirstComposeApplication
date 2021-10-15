package com.tenny.composeapp.data

import androidx.annotation.DrawableRes

/**
 * Description:
 * Created by TennyQ
 * on 2021/9/30
 */
data class MessageEntity(val msg: String, val name: String, @DrawableRes val avatar: Int)
