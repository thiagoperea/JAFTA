package com.thiagoperea.jafta.transaction.ui

import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.input.OffsetMapping
import androidx.compose.ui.text.input.TransformedText
import androidx.compose.ui.text.input.VisualTransformation
import java.text.NumberFormat

class MoneyMask : VisualTransformation {

    val formatter = NumberFormat.getCurrencyInstance()

    override fun filter(text: AnnotatedString): TransformedText {
        val inputOnlyDigits = text.text
            .filter { it.isDigit() }
            .toLongOrNull() ?: 0L

        val newValue = inputOnlyDigits / 100.0
        val formattedText = formatter.format(newValue)

        return TransformedText(
            text = AnnotatedString(formattedText),
            offsetMapping = MoneyMaskOffset(
                originalText = text.text,
                formattedValue = formattedText
            )
        )
    }

    class MoneyMaskOffset(
        val originalText: String,
        val formattedValue: String
    ) : OffsetMapping {

        override fun originalToTransformed(offset: Int): Int {
            return formattedValue.length
        }

        override fun transformedToOriginal(offset: Int): Int {
            return originalText.length
        }
    }
}
