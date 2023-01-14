package com.thiagoperea.jafta.design_system.theme

import androidx.compose.runtime.Composable
import androidx.compose.ui.text.*
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

object TextStyles {

    val body1 = TextStyle(
        fontWeight = FontWeight.Medium,
        fontSize = 16.sp,
        //TODO: fontFamily =
    )

    val body3 = TextStyle(
        fontWeight = FontWeight.W500,
        fontSize = 14.sp,
        lineHeight = 18.sp
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
        lineHeight = 21.78.sp
        //TODO: fontFamily =
    )

    val title2 = TextStyle(
        fontWeight = FontWeight.W400,
        fontSize = 16.sp,
        lineHeight = 18.sp,
        color = Light20
        //TODO: fontFamily =
    )

    val title4 = TextStyle(
        fontWeight = FontWeight.W500,
        fontSize = 16.sp,
        lineHeight = 19.36.sp,
        color = Light20
        //TODO: fontFamily =
    )

    val title5 = TextStyle(
        fontWeight = FontWeight.W700,
        fontSize = 14.sp,
        lineHeight = 18.sp,
        color = Light20
        //TODO: fontFamily =
    )

    @Composable
    fun spannableString(text: String, textSpan: String): AnnotatedString {
        val annotatedString = buildAnnotatedString {
            append(text)
            withStyle(style = SpanStyle(Violet100)) {
                append(textSpan)
            }
        }
        return annotatedString
    }
}