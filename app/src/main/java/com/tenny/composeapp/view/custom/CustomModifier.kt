package com.tenny.composeapp.view.custom

import android.annotation.SuppressLint
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawWithContent
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.*
import androidx.compose.ui.unit.Constraints
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.constrainHeight
import androidx.compose.ui.unit.constrainWidth
import kotlin.math.max

/**
 * Description:  自定义Compose的拓展Modifier
 * Created by TennyQ
 * on 2021/10/10
 */


@SuppressLint("ModifierFactoryUnreferencedReceiver")
fun Modifier.firstBaselineToTop(firstBaselineToTop: Dp) = Modifier.layout { measurable, constraints ->
    val placeable = measurable.measure(constraints)

    check(placeable[FirstBaseline] != AlignmentLine.Unspecified)
    val firstBaseline = placeable[FirstBaseline]
    val placeableY = firstBaselineToTop.roundToPx() - firstBaseline
    val height = placeable.height + placeableY
    layout(placeable.width, height) {
        placeable.placeRelative(0, placeableY)
    }
}


@SuppressLint("ModifierFactoryUnreferencedReceiver")
fun Modifier.drawBackground(color: Color) = Modifier.drawWithContent {
    drawRect(color)
    drawContent()
}

@SuppressLint("ModifierFactoryUnreferencedReceiver")
fun Modifier.customPadding(padding: Dp) = Modifier.layout { measurable, constraints ->
    val paddingPx = padding.roundToPx()
    val paddingConstraints = constraints.copy().apply {
        constrainWidth(maxWidth - paddingPx * 2)
        constrainHeight(maxHeight - paddingPx * 2)
    }
    val placeable = measurable.measure(paddingConstraints)
    layout(placeable.width + paddingPx * 2, placeable.height + paddingPx * 2) {
        placeable.placeRelative(paddingPx, paddingPx)
    }
}

@Composable
fun CustomColumn(modifier: Modifier, content: @Composable () -> Unit) {
    Layout(content, modifier, object : MeasurePolicy{
        override fun MeasureScope.measure(
            measurables: List<Measurable>,
            constraints: Constraints
        ): MeasureResult {
            var width = 0
            var height = 0
            val placeableList = mutableListOf<Placeable>()

            for (measurable in measurables) {
                val placeable = measurable.measure(constraints)
                width = max(placeable.width, width)
                height += placeable.height
                placeableList.add(placeable)
            }

            return layout(width, height) {
                var currentHeight = 0
                for (placeable in placeableList) {
                    placeable.placeRelative(0, currentHeight)
                    currentHeight += placeable.height
                }
            }
        }

        //Modifier.height(IntrinsicSize.Min)，则会调用minIntrinsicHeight方法。width就是父组件能提供的最大宽度
        override fun IntrinsicMeasureScope.minIntrinsicHeight(
            measurables: List<IntrinsicMeasurable>,
            width: Int
        ): Int {
            var maxHeight = 0
            measurables.forEach {
                maxHeight = it.minIntrinsicHeight(width).coerceAtLeast(maxHeight)
            }
            return maxHeight
        }

        //Modifier.height(IntrinsicSize.Max)，则会调用maxIntrinsicHeight方法。width就是父组件能提供的最大宽度
        override fun IntrinsicMeasureScope.maxIntrinsicHeight(
            measurables: List<IntrinsicMeasurable>,
            width: Int
        ): Int {
            var maxHeight = 0
            measurables.forEach {
                maxHeight = it.minIntrinsicHeight(width).coerceAtLeast(maxHeight)
            }
            return maxHeight
        }

        //Modifier.height(IntrinsicSize.Min)，则会调用minIntrinsicWidth方法。height就是父组件能提供的最大高度
        override fun IntrinsicMeasureScope.minIntrinsicWidth(
            measurables: List<IntrinsicMeasurable>,
            height: Int
        ): Int {
            var maxWidth = 0
            measurables.forEach {
                maxWidth = it.minIntrinsicWidth(height).coerceAtLeast(maxWidth)
            }
            return maxWidth
        }

        //Modifier.height(IntrinsicSize.Max)，则会调用maxIntrinsicWidth方法。height就是父组件能提供的最大高度
        override fun IntrinsicMeasureScope.maxIntrinsicWidth(
            measurables: List<IntrinsicMeasurable>,
            height: Int
        ): Int {
            var maxWidth = 0
            measurables.forEach {
                maxWidth = it.minIntrinsicWidth(height).coerceAtLeast(maxWidth)
            }
            return maxWidth
        }

    })
}