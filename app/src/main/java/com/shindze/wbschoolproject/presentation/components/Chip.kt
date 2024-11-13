package com.shindze.wbschoolproject.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.shindze.wbschoolproject.ui.theme.MetadataThree
import com.shindze.wbschoolproject.ui.theme.background
import com.shindze.wbschoolproject.ui.theme.dark

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Chip(name: String) {
    Box(
        modifier = Modifier
            .background(color = background, shape = RoundedCornerShape(100.dp))
            .padding(horizontal = 8.dp, vertical = 4.dp),
        contentAlignment = Alignment.Center
    ) {
        Text(text = name, color = dark, style = MetadataThree)
    }
}