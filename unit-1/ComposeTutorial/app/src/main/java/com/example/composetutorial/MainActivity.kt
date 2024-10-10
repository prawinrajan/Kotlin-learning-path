package com.example.composetutorial

import android.content.res.Configuration
import android.graphics.Bitmap
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Shapes
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.composetutorial.ui.theme.ComposeTutorialTheme

data class Message(val author: String, val body: String);

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ComposeTutorialTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    shape = MaterialTheme.shapes.medium,
                    color = MaterialTheme.colorScheme.surface
                ) {
                    MessageCard(
                        Message("Prawin", "Learning Kotlin"),
                        modifier = Modifier.padding(4.dp)
                    )
                }
            }
        }
    }
}


@Composable
fun MessageCard(msg: Message, modifier: Modifier = Modifier) {
    Row(modifier = modifier.padding(8.dp), verticalAlignment = Alignment.CenterVertically) {
        Image(
            painter = painterResource(id = R.drawable._0864806),
            contentDescription = "Profile",
            modifier = Modifier
                .size(40.dp)
                .clip(
                    CircleShape
                )
                .border(1.dp, Color.LightGray, CircleShape),
            alignment = Alignment.BottomCenter
        )
        Spacer(modifier = Modifier.padding(2.dp))
        Column {
            Text(
                text = msg.author,
                modifier = modifier,
                style = MaterialTheme.typography.titleSmall,
                color = MaterialTheme.colorScheme.primary
            )
            Surface(shape = MaterialTheme.shapes.medium) {
                Text(
                    text = msg.body,
                    modifier = modifier.padding(all = 4.dp),
                    style = MaterialTheme.typography.bodyMedium
                )
            }

        }
    }
}

@Preview(showBackground = true, name = "Light mode")
@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES, showBackground = true, name = "Night mode")
@Composable
fun MessageCardPreview() {
    ComposeTutorialTheme {
        Surface {}
        MessageCard(Message("Prawin", "Learning Kotlin"))
        MessageCard(Message("Prawin", "Learning Kotlin"))
    }
}

