package com.merlin3d.demarche237.ui.components.tab

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun ClickableTabs(selectedItem: Int, tabsList : List<String>, onClick: (Int) -> Unit) {
    val selectedItemIndex = remember{
        mutableStateOf(selectedItem)
    }
    Box(
        modifier = Modifier
            .background(Color(0xFFEDEDF0), RoundedCornerShape(10.dp))
            .height(IntrinsicSize.Min),
        contentAlignment = Alignment.Center
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(6.dp)
        ) {
            tabsList.forEachIndexed { index, s ->
                TabItem(isSelected = index == selectedItemIndex.value, text = s) {
                    selectedItemIndex.value = index
                    onClick.invoke(selectedItemIndex.value)
                }
            }
        }
    }
}

@Composable
fun TabItem(isSelected: Boolean, text: String, onClick: () -> Unit) {
     Box(
         modifier = Modifier.background( if(isSelected) Color(0xFF017962) else Color.Gray.copy(alpha = 0.1f),
             shape = RoundedCornerShape(10.dp))
             .padding(horizontal = 16.dp, vertical = 6.dp)
             .clickable{
                 onClick()
             }
     ){
         Text(text, style = TextStyle(
             fontWeight = FontWeight(500),
             fontSize = 12.sp,
             color = if(isSelected) Color.White else Color(0xFF17171C)
         ))
     }
}