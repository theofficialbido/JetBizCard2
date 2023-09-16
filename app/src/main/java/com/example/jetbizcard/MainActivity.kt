package com.example.jetbizcard

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults.cardColors
import androidx.compose.material3.CardDefaults.cardElevation
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.jetbizcard.ui.theme.JetBizCardTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetBizCardTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    color = MaterialTheme.colorScheme.background
                ) {
                    CreateBizCard()
                }
            }
        }
    }
}

@Composable
fun CreateBizCard() {
    Surface( modifier = Modifier
        .fillMaxHeight()
        .fillMaxWidth()) {
        Card(
            modifier = Modifier
                .padding(12.dp)
                .width(200.dp)
                .height(390.dp),
            shape = RoundedCornerShape(corner = CornerSize(15.dp)),
            colors = cardColors(containerColor = MaterialTheme.colorScheme.primaryContainer),
            elevation = cardElevation(defaultElevation = 4.dp)

        ) {
            Column(modifier = Modifier
                .height(300.dp),
                verticalArrangement = Arrangement.Top,
                horizontalAlignment = Alignment.CenterHorizontally) {
                    CreateImageProfile()
                    Divider(modifier = Modifier,
                        color = Color.DarkGray,
                        thickness = 1.dp )
                    GetInfo()
                    Button(onClick = { Log.d("Clicked", "Clicked!!!")},) {
                        Text(text = "Portfolio", style = MaterialTheme.typography.bodyMedium)
                    }
            }

        }
    }

}

@Preview
@Composable
fun Content() {
    Box(modifier = Modifier.fillMaxSize()) {
        Surface(modifier = Modifier
            .fillMaxSize()
            .padding(6.dp),
                border = BorderStroke(5.dp, Color.LightGray),
                shape = RoundedCornerShape(corner = CornerSize(6.dp))) {

            Portfolio(data = listOf("Project1", "Project2", "Project3"))

        }
    }
}
@Composable
fun Portfolio(data: List<String>) {
    LazyColumn{
        items(data) {item ->
            Text(item)
            
        }
    }

}

@Composable
private fun GetInfo() {
    Column(modifier = Modifier.padding(all = 5.dp)) {
        Text(
            text = "Abdullah I.",
            modifier = Modifier.padding(all = 4.dp),
            style = MaterialTheme.typography.headlineLarge,
            color = MaterialTheme.colorScheme.primary
        )
        Text(
            text = "Jetpack Compose Learner",
            modifier = Modifier.padding(all = 4.dp)
        )
        Text(
            text = "@theofficialbido",
            modifier = Modifier.padding(all = 4.dp)
        )

    }
}

@Composable
private fun CreateImageProfile(modifier: Modifier = Modifier) {
    Surface(
        modifier = Modifier
            .size
                (135.dp)
            .padding(5.dp),
        shape = CircleShape,
        border = BorderStroke(0.5.dp, Color.LightGray),
        shadowElevation = 4.dp,
        color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.5f)
    ) {
        Image(
            painter = painterResource(id = R.drawable.profile_image),
            contentDescription = "Profile Picture",
            modifier = Modifier
                .size(135.dp),
                contentScale = ContentScale.Crop
        )
    }
}


//@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    JetBizCardTheme {
        CreateBizCard()
    }
}