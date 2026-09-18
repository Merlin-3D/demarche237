package com.merlin3d.demarche237.ui.screen.main.navigation

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.merlin3d.demarche237.ui.components.CarouselImage
import com.merlin3d.demarche237.ui.components.Shortcut
import com.merlin3d.demarche237.ui.components.tab.ClickableTabs
import demarche237.shared.generated.resources.Res
import demarche237.shared.generated.resources.arrow_right
import demarche237.shared.generated.resources.building
import demarche237.shared.generated.resources.logo_slogan
import demarche237.shared.generated.resources.passport
import demarche237.shared.generated.resources.search
import org.jetbrains.compose.resources.painterResource

@Composable
@Preview
fun HomeScreen() {
    Scaffold(
        topBar = {
            TopAppBar(
                windowInsets = WindowInsets(0.dp),

                colors = TopAppBarDefaults.topAppBarColors(
                    titleContentColor = MaterialTheme.colorScheme.primary,
                ),
                title = {
                    Row(
                        horizontalArrangement = Arrangement.SpaceBetween,
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Image(
                            painterResource(Res.drawable.logo_slogan),
                            "Démarche 237",
                            modifier = Modifier
                                .width(200.dp)
                                .height(80.dp),
                            contentScale = ContentScale.Fit
                        )
                    }
                },
                actions = {
                    Column(
                        Modifier.padding(end = 16.dp)
                    ) {
                        ClickableTabs(
                            selectedItem = 0, tabsList = listOf(
                                "FR", "EN"
                            ), onClick = {})
                    }
                }
            )
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(innerPadding)

        ) {
            CarouselImage()
            Spacer(modifier = Modifier.height(8.dp))
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp)
                    .background(Color(0xFFEDEDF0), RoundedCornerShape(14.dp))

            ) {
                Row(
                    modifier = Modifier.padding(vertical = 8.dp, horizontal = 16.dp),
                    horizontalArrangement = Arrangement.spacedBy(4.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Icon(
                        painter = painterResource(
                            Res.drawable.search
                        ),
                        contentDescription = null,
                        modifier = Modifier.size(24.dp),
                        tint = Color.Gray
                    )
                    Text("Quelle démarche recherchez-vous ?", style = TextStyle(
                        fontSize = 13.sp
                    ))
                }
            }
            Spacer(modifier = Modifier.height(8.dp))
            Shortcut()
            Spacer(modifier = Modifier.height(16.dp))
            Row(
                modifier = Modifier.fillMaxWidth()
                    .padding(horizontal = 16.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text("Démarches populaires",
                    style = TextStyle(
                        fontWeight = FontWeight.SemiBold,
                        fontSize = 18.sp
                        ))
                Row(
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically
                ){
                    Text("Voir tout",
                        style = TextStyle(
                            fontWeight = FontWeight.Normal,
                            fontSize = 12.sp,
                            color = Color(0xFF02705A)
                        ))
                    Spacer(modifier = Modifier.width(4.dp))
                    Icon(
                        painter = painterResource(
                            Res.drawable.arrow_right
                        ),
                        contentDescription = null,
                        modifier = Modifier.size(16.dp),
                        tint = Color(0xFF02705A)
                    )
                }
            }
            Spacer(modifier = Modifier.height(8.dp))
            Row(
                horizontalArrangement = Arrangement.spacedBy(8.dp),
                modifier = Modifier.fillMaxWidth()
                    .padding(horizontal = 16.dp)
            ) {
                Column(
                    modifier = Modifier.weight(1f).border(
                        width = 1.dp,
                        color = Color.Gray.copy(alpha = 0.2f),
                        shape = MaterialTheme.shapes.medium
                    )
                ){
                    Image(
                        painterResource(Res.drawable.passport),
                        "Demander un passport",
                        modifier = Modifier
                            .fillMaxWidth()
                            .clip(MaterialTheme.shapes.medium),
                        contentScale = ContentScale.Fit
                    )
                    Spacer(modifier = Modifier.height(4.dp))
                    Column  (
                        modifier = Modifier.height(100.dp).padding(horizontal = 8.dp)
                            .padding(bottom = 16.dp)
                    ) {
                        Text("Demander un passport",
                            style = TextStyle(
                                fontWeight = FontWeight.SemiBold,
                                fontSize = 14.sp
                            ))
                        Spacer(modifier = Modifier.height(4.dp))
                        Text("Informations générales pour votre demande de passport",
                            style = TextStyle(
                                fontWeight = FontWeight.Normal,
                                fontSize = 12.sp,
                                color = Color.Gray.copy(alpha = 0.7f)
                            ))
                    }
                }
                Column(
                    modifier = Modifier.weight(1f).border(
                     width = 1.dp,
                        color = Color.Gray.copy(alpha = 0.2f),
                        shape = MaterialTheme.shapes.medium
                    )
                ){
                    Image(
                        painterResource(Res.drawable.building),
                        "Créer mon entreprise",
                        modifier = Modifier
                            .fillMaxWidth()
                            .clip(MaterialTheme.shapes.medium),
                        contentScale = ContentScale.Fit
                    )
                    Spacer(modifier = Modifier.height(4.dp))
                    Column  (
                        modifier = Modifier.height(100.dp).padding(horizontal = 8.dp)
                            .padding(bottom = 16.dp)
                    ) {
                        Text("Créer mon entreprise",
                            style = TextStyle(
                                fontWeight = FontWeight.SemiBold,
                                fontSize = 14.sp
                            ))
                        Spacer(modifier = Modifier.height(4.dp))
                        Text("Découvrez les démarches pour créer votre entreprise au Cameroun",
                            style = TextStyle(
                                fontWeight = FontWeight.Normal,
                                fontSize = 12.sp,
                                color = Color.Gray.copy(alpha = 0.7f)
                            ))
                    }
                }
            }
        }

    }
}