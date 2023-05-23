package com.example.mahdavi20

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.mahdavi20.ui.theme.Mahdavi20Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Mahdavi20Theme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    myNavigation()
                }
            }
        }
    }
}

@Composable



fun myNavigation(){
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Home.Route){
        composable(Home.Route){
            HomeScreen(navController)
        }
        composable(route = "Second/{username}/{age}", arguments = listOf(navArgument("username") {
            type = NavType.StringType
        }, navArgument("age") {
            type = NavType.IntType
        })){
            val age = it.arguments?.getInt("age")
            val username = it.arguments?.getString("username")

            SecondScreen(username, age)

        }
    }
}