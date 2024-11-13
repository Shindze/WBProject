package com.shindze.wbschoolproject.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.shindze.wbschoolproject.R

// Set of Material typography styles to start with
val Typography = Typography(
    bodyLarge = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp,
        lineHeight = 24.sp,
        letterSpacing = 0.5.sp
    )
)

val WBFontFamily = FontFamily(
    Font(R.font.sf_pro_display_bold, FontWeight.Bold),
    Font(R.font.sf_pro_display_semibold, FontWeight.SemiBold),
    Font(R.font.sf_pro_display_regular, FontWeight.Normal),
)

val HeadingOne = TextStyle(
    fontFamily = WBFontFamily,
    fontSize = 32.sp,
    fontWeight = FontWeight.Bold
)

val HeadingTwo = TextStyle(
    fontFamily = WBFontFamily,
    fontSize = 24.sp,
    fontWeight = FontWeight.Bold
)

val SubheadingOne = TextStyle(
    fontFamily = WBFontFamily,
    fontSize = 18.sp,
    fontWeight = FontWeight.SemiBold
)

val SubheadingTwo = TextStyle(
    fontFamily = WBFontFamily,
    fontSize = 16.sp,
    fontWeight = FontWeight.SemiBold
)

val BodyOne = TextStyle(
    fontFamily = WBFontFamily,
    fontSize = 14.sp,
    fontWeight = FontWeight.SemiBold
)

val BodyTwo = TextStyle(
    fontFamily = WBFontFamily,
    fontSize = 14.sp,
    fontWeight = FontWeight.Normal
)

val MetadataOne = TextStyle(
    fontFamily = WBFontFamily,
    fontSize = 12.sp,
    fontWeight = FontWeight.Normal
)

val MetadataTwo = TextStyle(
    fontFamily = WBFontFamily,
    fontSize = 10.sp,
    fontWeight = FontWeight.Normal
)

val MetadataThree = TextStyle(
    fontFamily = WBFontFamily,
    fontSize = 10.sp,
    fontWeight = FontWeight.SemiBold
)
