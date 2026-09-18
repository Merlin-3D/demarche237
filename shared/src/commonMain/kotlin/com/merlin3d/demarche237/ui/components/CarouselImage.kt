package com.merlin3d.demarche237.ui.components

import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.util.lerp
import demarche237.shared.generated.resources.Res
import demarche237.shared.generated.resources._01_identite
import demarche237.shared.generated.resources._02_etat_civil
import demarche237.shared.generated.resources._03_entreprise
import demarche237.shared.generated.resources._04_etudes
import demarche237.shared.generated.resources._05_transport
import kotlinx.coroutines.delay
import org.jetbrains.compose.resources.DrawableResource
import org.jetbrains.compose.resources.painterResource
import kotlin.math.absoluteValue
import kotlin.time.Duration.Companion.milliseconds

data class CarouselItem(
    val id: Int,
    val imageResId: DrawableResource,
    val contentTitle: String,
    val contentDescription: String
)

@Suppress("FrequentlyChangingValue")
@Composable
@Preview
fun CarouselImage() {

    val items = remember {
        listOf(
            CarouselItem(
                0,
                Res.drawable._01_identite,
                "Préparez\nvotre passport",
                "Retrouvez les pièces et les étapes pour votre demande"
            ),
            CarouselItem(
                1,
                Res.drawable._02_etat_civil,
                "Vos actes,\nsans confusion",
                "Comprenez les démarches liées à votre état civil."
            ),
            CarouselItem(
                2,
                Res.drawable._03_entreprise,
                "Lancez votre\nentreprise",
                "Découvrez comment préparer votre dossier de création."
            ),
            CarouselItem(
                3,
                Res.drawable._04_etudes,
                "Avancez\ndans vos études",
                "Explorez les démarches pour vos diplômes et inscriptions."
            ),
            CarouselItem(
                4,
                Res.drawable._05_transport,
                "Prenez la\nbonne route",
                "Informez-vous sur le permis et les démarches de votre véhicules"
            ),
        )
    }

    val pagerState = rememberPagerState(
        pageCount = { items.size }
    )

    LaunchedEffect(pagerState) {
        while (true) {
            delay(4000.milliseconds)

            val nextPage = (pagerState.currentPage + 1) % items.size

            pagerState.animateScrollToPage(
                page = nextPage,
                animationSpec = tween(
                    durationMillis = 900,
                    easing = FastOutSlowInEasing
                )
            )
        }
    }

    HorizontalPager(
        state = pagerState,
        modifier = Modifier.fillMaxWidth(),
        contentPadding = PaddingValues(horizontal = 16.dp),
        pageSpacing = 8.dp
    ) { page ->

        val item = items[page]

        val pageOffset =
            ((pagerState.currentPage - page) + pagerState.currentPageOffsetFraction)
                .absoluteValue
                .coerceIn(0f, 1f)

        val scale = lerp(
            start = 0.92f,
            stop = 1f,
            fraction = 1f - pageOffset
        )

        val alpha = lerp(
            start = 0.6f,
            stop = 1f,
            fraction = 1f - pageOffset
        )

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(205.dp)
                .graphicsLayer {
                    scaleX = scale
                    scaleY = scale
                    this.alpha = alpha
                }
                .clip(MaterialTheme.shapes.extraLarge)
        ) {
            Image(
                painter = painterResource(item.imageResId),
                contentDescription = item.contentDescription,
                modifier = Modifier.fillMaxSize(),
                contentScale = ContentScale.Crop
            )
            Column(
                modifier = Modifier
                    .align(Alignment.CenterStart)
                    .padding(20.dp),
                verticalArrangement = Arrangement.spacedBy(6.dp)
            ) {
                Box(
                    modifier = Modifier.size(width = 36.dp, height = 4.dp)
                        .background(Color(0xFFE8C724))
                ) {}
                Text(
                    text = item.contentTitle,
                    color = Color.White,
                    style = MaterialTheme.typography.headlineLarge,
                    fontWeight = FontWeight.Bold,
                    fontSize = 28.sp,
                    lineHeight = 27.sp
                )
                Text(
                    text = item.contentDescription,
                    color = Color.White,
                    style = MaterialTheme.typography.bodyLarge,
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Normal,
                    lineHeight = 16.sp,
                    modifier = Modifier.widthIn(max = 150.dp)

                )
            }
        }

    }
}