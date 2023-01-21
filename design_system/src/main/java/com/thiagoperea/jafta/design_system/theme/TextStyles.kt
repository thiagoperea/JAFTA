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

    val bold14 = TextStyle(
        fontWeight = FontWeight.Bold,
        fontSize = 14.sp,
        //TODO: fontFamily =
    )

    val bold16 = TextStyle(
        fontWeight = FontWeight.Bold,
        fontSize = 16.sp,
        //TODO: fontFamily =
    )

    val medium10 = TextStyle(
        fontWeight = FontWeight.Medium,
        fontSize = 10.sp,
        //TODO: fontFamily =
    )

    val medium13 = TextStyle(
        fontWeight = FontWeight.Medium,
        fontSize = 13.sp,
        //TODO: fontFamily =
    )

    val semiBold13 = TextStyle(
        fontWeight = FontWeight.SemiBold,
        fontSize = 13.sp,
        //TODO: fontFamily =
    )

    val semiBold16 = TextStyle(
        fontWeight = FontWeight.SemiBold,
        fontSize = 16.sp,
        //TODO: fontFamily =
    )

    val semiBold18 = TextStyle(
        fontWeight = FontWeight.SemiBold,
        fontSize = 18.sp,
        //TODO: fontFamily =
    )

    val semiBold22 = TextStyle(
        fontWeight = FontWeight.SemiBold,
        fontSize = 22.sp,
        //TODO: fontFamily =
    )

    val semiBold40 = TextStyle(
        fontWeight = FontWeight.SemiBold,
        fontSize = 40.sp,
        //TODO: fontFamily =
    )

    val semiBold48 = TextStyle(
        fontWeight = FontWeight.SemiBold,
        fontSize = 48.sp,
        //TODO: fontFamily =
    )

    @Composable
    fun spannableString(
        text: String,
        textSpan: String,
        textSpanStyle: SpanStyle = SpanStyle(Violet100)
    ): AnnotatedString {
        val annotatedString = buildAnnotatedString {
            append(text)
            withStyle(style = textSpanStyle) {
                append(textSpan)
            }
        }
        return annotatedString
    }
}