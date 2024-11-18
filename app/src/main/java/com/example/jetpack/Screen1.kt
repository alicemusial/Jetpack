package com.example.jetpack

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavController


@Composable
fun Screen1 (navController: NavController){
    var name = remember { mutableStateOf("") }
    var newname = name.value
    Column (Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center)
    {
        Text(text = "Screen 1")
        OutlinedTextField(
            value = name.value,
            onValueChange = { name.value = it },
            label = { Text("You're name:") }
        )
        Button(onClick = {
            navController.navigate(Routes.screen2+"/$newname")
        }) {
            Text(text = "Go to screen 2")
        }
    }
}