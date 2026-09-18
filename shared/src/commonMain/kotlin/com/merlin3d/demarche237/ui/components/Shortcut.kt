package com.merlin3d.demarche237.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import demarche237.shared.generated.resources.Res
import demarche237.shared.generated.resources.enterprise
import demarche237.shared.generated.resources.group_2
import demarche237.shared.generated.resources.heroicons__user_group_solid
import demarche237.shared.generated.resources.identity
import demarche237.shared.generated.resources.school
import org.jetbrains.compose.resources.DrawableResource
import org.jetbrains.compose.resources.painterResource

data class ShortcutItem(
    val imageRes: DrawableResource,
    val title: String,
    val color: Color,
    val iconColor: Color,
)

@Composable
@Preview
fun Shortcut() {
    val items =
        listOf<ShortcutItem>(
            ShortcutItem(
                Res.drawable.identity,
                "Identité",
                Color(0xFF02705A).copy(alpha = 0.1f),
                Color(0xFF02705A),
            ),
            ShortcutItem(
                Res.drawable.group_2,
                "État civil",
                Color(0xFFFCCE1B).copy(alpha = 0.1f),
                Color(0xFFFCCE1B),
            ),
            ShortcutItem(
                Res.drawable.enterprise,
                "Entreprise",
                Color(0xFFC4142A).copy(alpha = 0.1f),
                Color(0xFFC4142A),
            ),
            ShortcutItem(
                Res.drawable.school,
                "Études",
                Color(0xFF02705A).copy(alpha = 0.1f),
                Color(0xFF02705A)
            ),
        )

    Row(
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.fillMaxWidth()
            .padding(horizontal = 16.dp)
    ) {
        items.forEach { shortcut ->
            Column(
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.weight(1f).background(
                    shortcut.color,
                    RoundedCornerShape(12.dp)
                ).padding(12.dp)
            ) {
                Icon(
                    painter = painterResource(
                        shortcut.imageRes
                    ),
                    contentDescription = null,
                    modifier = Modifier.size(42.dp),
                    tint = shortcut.iconColor
                )
                Spacer(modifier = Modifier.height(4.dp))
                Text(
                    shortcut.title, style = TextStyle(
                        fontSize = 12.sp,
                        fontWeight = FontWeight.SemiBold
                    )
                )
            }
        }

    }
}