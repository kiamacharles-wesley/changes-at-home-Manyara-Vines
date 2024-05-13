package net.ezra.ui.destinations


import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController

@Composable
fun NotificationScreen(navController: NavHostController) {


}

@Preview(showBackground = true)
@Composable
fun PreviewLight2() {
    NotificationScreen(rememberNavController())
}