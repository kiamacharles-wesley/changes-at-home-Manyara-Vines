package net.ezra

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController

@Composable
fun HistoryScreen(navController: NavHostController) {


}


@Composable
@Preview(showBackground = true)
fun Preview2() {
    HistoryScreen(rememberNavController())
}