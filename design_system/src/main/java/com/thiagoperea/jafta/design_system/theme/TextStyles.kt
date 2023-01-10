package com.thiagoperea.jafta.design_system.theme

import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

object TextStyles {

    val body1 = TextStyle(
        fontWeight = FontWeight.Medium,
        fontSize = 16.sp,
        //TODO: fontFamily =
    )

    val title1 = TextStyle(
        fontWeight = FontWeight.SemiBold,
        fontSize = 32.sp,
        //TODO: fontFamily =
    )

    val title3 = TextStyle(
        fontWeight = FontWeight.W600,
        fontSize = 18.sp,
        //TODO: fontFamily =
    )

    val textField = TextStyle(
        fontWeight = FontWeight.W400,
        fontSize = 16.sp,
        lineHeight = 18.sp,
        color = Light20
    )
}