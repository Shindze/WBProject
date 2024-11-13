package com.shindze.wbschoolproject.presentation.view.auth.number

import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.input.OffsetMapping
import androidx.compose.ui.text.input.TransformedText
import androidx.compose.ui.text.input.VisualTransformation

class PhoneVisualTransformation(
    private val mask: String, private val maskNumber: Char
) : VisualTransformation {

    // Вычисляем максимальное количество символов, которое будет показано на экране
    private val maxLength = mask.count { it == maskNumber }

    override fun filter(text: AnnotatedString): TransformedText {
        // Обрезаем текст, если он превышает максимальную длину
        val trimmed = text.take(maxLength)

        val formattedText = buildString {
            if (trimmed.isEmpty()) return@buildString

            var maskIndex = 0
            var textIndex = 0
            while (textIndex < trimmed.length && maskIndex < mask.length) {
                // Если символ в маске не является номером, добавляем его в результат
                if (mask[maskIndex] != maskNumber) {
                    val nextNumberIndex = mask.indexOf(maskNumber, maskIndex)
                    append(mask.substring(maskIndex, nextNumberIndex))
                    maskIndex = nextNumberIndex
                }
                // Добавляем символ из входного текста
                append(trimmed[textIndex])
                textIndex++
                maskIndex++
            }
        }
        return TransformedText(
            AnnotatedString(formattedText), PhoneOffsetMapper(mask, maskNumber)
        )
    }
}

private class PhoneOffsetMapper(
    private val mask: String, private val numberChar: Char
) : OffsetMapping {

    // Этот метод используется для корректного отображения курсора при вводе текста
    // Он преобразует позицию курсора в исходном тексте в позицию курсора в преобразованном тексте
    override fun originalToTransformed(offset: Int): Int {
        var noneNumberCount = 0
        var i = 0
        while (i < offset + noneNumberCount) {
            if (mask[i] != numberChar) {
                noneNumberCount++
            }
            i++
        }
        return offset + noneNumberCount
    }

    // Этот метод используется для корректного отображения выделения текста
    // Он преобразует позицию в преобразованном тексте в позицию в исходном тексте
    override fun transformedToOriginal(offset: Int): Int =
        offset - mask.take(offset).count { it != numberChar }
}
