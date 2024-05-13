package net.ezra

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController

@Composable
fun SettingsScreen(navController: NavHostController) {


}


@Composable
@Preview(showBackground = true)
fun Preview() {
    SettingsScreen(rememberNavController())
}