package com.merlin3d.demarche237.ui.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import demarche237.shared.generated.resources.Res
import demarche237.shared.generated.resources.vertical
import kotlinx.coroutines.delay
import org.jetbrains.compose.resources.painterResource
import kotlin.time.Duration.Companion.milliseconds

@Composable
fun SplashScreen(onFinish: ()-> Unit){

    LaunchedEffect(Unit){
        delay(2000.milliseconds)
        onFinish()
    }

    Scaffold (
        modifier = Modifier.padding(horizontal = 16.dp),
    ) {
        Column (
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
        ) {
            Image(painterResource(Res.drawable.vertical),null, modifier = Modifier.size(width = 250.dp, height = 250.dp))
        }

    }
}