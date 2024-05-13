package net.ezra.ui.destinations


import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController

@Composable
fun DesertsScreen(navController: NavHostController) {


}

@Preview(showBackground = true)
@Composable
fun PreviewLight1() {
    DesertsScreen(rememberNavController())
}