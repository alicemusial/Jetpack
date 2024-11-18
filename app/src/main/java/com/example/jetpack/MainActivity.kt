package com.example.jetpack

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.jetpack.ui.theme.JetpackTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetpackTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Greeting()
                }

                val navController = rememberNavController()
                NavHost(navController = navController,
                    startDestination = Routes.screen1,
                    builder = {
                        composable(Routes.screen1){
                            Screen1(navController)
                        }
                        composable(Routes.screen3){
                            Screen3(navController)
                        }
                        composable(Routes.screen2+"/{name}"){
                            val name = it.arguments?.getString("name")
                            Screen2(navController, name?:"No name")
                        }
                    } )
    }
}



}


}



@Composable
fun Greeting( modifier: Modifier = Modifier) {
    Text(
        text = "Alicja Musiał" +
                "Jetpack",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    JetpackTheme {
        Greeting()
    }
}