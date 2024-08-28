package com.example.businesscard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.businesscard.ui.theme.BusinessCardTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            BusinessCardTheme {
                Surface (
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    BusinessCardApp()
                }
            }
        }
    }
}

@Composable
fun BusinessCardApp() {
    BusinessCard(
        logo = painterResource(R.drawable.android_logo),
//        logoCircle = painterResource(R.drawable.baseline_circle_24),
        name = stringResource(R.string.name),
        title = stringResource(R.string.title),
        phone = stringResource(R.string.phone),
        phoneIcon = painterResource(R.drawable.baseline_smartphone_24),
        social = stringResource(R.string.social),
        socialIcon = painterResource(R.drawable.baseline_share_24),
        email = stringResource(R.string.email),
        emailIcon = painterResource(R.drawable.baseline_email_24),
        )
}

@Composable
private fun BusinessCard(
    logo: Painter,
//    logoCircle: Painter,
    name: String,
    title: String,
    phone: String,
    phoneIcon: Painter,
    social: String,
    socialIcon: Painter,
    email: String,
    emailIcon: Painter,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Box(
            modifier = Modifier
                .size(100.dp) // Adjust the size as needed
                .clip(RectangleShape)
                .background(MaterialTheme.colorScheme.primary) // Set your desired circle color
        ) {
            Image(
                painter = logo, // Your transparent logo drawable
                contentDescription = null,
                modifier = Modifier.size(100.dp) // Adjust the size of the logo inside the circle
            )
        }
        Text(text = name,
            style = MaterialTheme.typography.headlineMedium,
            modifier = Modifier.padding(top = 16.dp)
        )
        Text(text = title)
    }
    Row(
        modifier = modifier.padding(bottom = 100.dp),
        verticalAlignment = Alignment.Bottom,
        horizontalArrangement = Arrangement.Center
    ) {
        Column {
            Image(painter = phoneIcon, contentDescription = null, Modifier.padding(5.dp))
            Image(painter = socialIcon, contentDescription = null, Modifier.padding(5.dp))
            Image(painter = emailIcon, contentDescription = null, Modifier.padding(5.dp))

        }
        Spacer(Modifier.width(5.dp))
        Column {
            Text(text = phone, Modifier.padding(5.dp))
            Text(text = social, Modifier.padding(5.dp))
            Text(text = email, Modifier.padding(5.dp))
        }
    }

}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    BusinessCardTheme {
        BusinessCardApp()
    }
}