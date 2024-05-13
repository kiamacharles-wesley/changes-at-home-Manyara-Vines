package net.ezra


import android.annotation.SuppressLint
import android.app.Instrumentation
import android.content.Intent
import android.graphics.drawable.Icon
import android.provider.MediaStore
import androidx.activity.compose.ManagedActivityResultLauncher
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.ActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.tween
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.LazyHorizontalGrid
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Create
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Place
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.rounded.Share
import androidx.compose.material3.Card
import androidx.compose.material3.CardElevation
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController

import net.ezra.R

import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.AbsoluteAlignment
import androidx.compose.ui.Alignment
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.BlendMode.Companion.Screen
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp
import androidx.core.net.toUri
import net.ezra.navigation.ROUTE_BEACHES

import net.ezra.navigation.ROUTE_HOME
import net.ezra.navigation.ROUTE_LAKES
import net.ezra.navigation.ROUTE_LOGIN
import net.ezra.navigation.ROUTE_MOUNTAINS
import net.ezra.navigation.ROUTE_POPULAR_HOTELS
import net.ezra.navigation.ROUTE_RADDISONBLU
import net.ezra.navigation.ROUTE_RECOMMENDED_PACKAGES
import net.ezra.navigation.ROUTE_RECOMMENDED_PLACES
import net.ezra.navigation.ROUTE_VASCODAGAMA
import net.ezra.navigation.ROUTE_WILDLIFE
import net.ezra.ui.destinations.DesertsScreen

import org.intellij.lang.annotations.JdkConstants.HorizontalAlignment
data class Screen(val title: String, val icon: Int)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)

@Composable

fun CartPage(navController: NavHostController) {


    var isDrawerOpen by remember { mutableStateOf(false) }

    val callLauncher: ManagedActivityResultLauncher<Intent, ActivityResult> =
        rememberLauncherForActivityResult(contract = ActivityResultContracts.StartActivityForResult()) { _ ->

        }


    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = {
                    Column (){
                        Text(text = " Cart")
                    }

                    // Text(text = stringResource(id = R.string.apen))
                },
                navigationIcon = @Composable {
                    if (!isDrawerOpen) {
                        IconButton(onClick = { isDrawerOpen = true }) {
                            Icon(
                                imageVector = Icons.Filled.AccountCircle,
                                contentDescription = null,
                                tint = Color(0xfff8c471)
                            )
                        }
                    }
                },

                actions = {

                    IconButton(onClick = {
                        navController.navigate(ROUTE_LOGIN) {
                            popUpTo(ROUTE_HOME) { inclusive = true }
                        }

                    }) {
                        Icon(
                            imageVector = Icons.Default.Notifications,
                            contentDescription = "notificationIcon",
                            modifier = Modifier.size(20.dp),
                            tint = Color(0xfff8c471)
                        )
                    } },

                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Color.White,
                    titleContentColor = Color(0xfff8c471),

                    )

            )
        },
        content = {
            Box(modifier = Modifier
                .fillMaxSize()
                .background(Color.White)){

                LazyColumn (
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.SpaceEvenly)
                {

                    item{



                    }

                }
            }
        },
        bottomBar = {BottomBar(navController)}



    )

    AnimatedDrawer(
        isOpen = isDrawerOpen,
        onClose = { isDrawerOpen = false }
    )

}


@Composable
fun AnimatedDrawer(isOpen: Boolean, onClose: () -> Unit) {
    val drawerWidth = remember { Animatable(if (isOpen) 250f else 0f) }





    LaunchedEffect(isOpen) {
        drawerWidth.animateTo(if (isOpen) 250f else 0f, animationSpec = tween(durationMillis = 300))
    }

    Surface(
        modifier = Modifier
            .fillMaxHeight()
            .width(drawerWidth.value.dp),
        color = Color.White,
        // color = Color.LightGray,
        elevation = 16.dp
    ) {


        val mContext = LocalContext.current

        Column {
            Row(horizontalArrangement = Arrangement.Absolute.Right, verticalAlignment = Alignment.CenterVertically) {
                Icon(
                    imageVector = Icons.Default.AccountCircle,
                    contentDescription = ""
                )
                Column () {
                    Text(
                        text = "Alala Amka",
                        modifier = Modifier.clickable { },
                        color= Color(0xfff8c471),
                        fontWeight = FontWeight.ExtraBold
                    )

                    Text(
                        text = "View profile",
                        modifier = Modifier.clickable { },
                        color=  Color(0xfff8c471),
                        fontWeight = FontWeight.ExtraLight
                    )
                }
            }
            Spacer(modifier = Modifier.height(30.dp))
            Row() {
                Icon(imageVector = Icons.Default.Info, contentDescription = "", tint =  Color(0xfff8c471) )
                Text(text = "What's new",
                    color=  Color(0xfff8c471),
                    modifier = Modifier.clickable { })
            }
            Spacer(modifier = Modifier.height(30.dp))
            Row() {
                Icon(imageVector = Icons.Default.Create, contentDescription = "", tint =  Color(0xfff8c471) )
                Text(text = "History",
                    color=  Color(0xfff8c471),
                    modifier = Modifier.clickable { })
            }

            Spacer(modifier = Modifier.height(30.dp))
            Row() {
                Icon(imageVector = Icons.Default.Settings, contentDescription = "", tint =  Color(0xfff8c471) )
                Text(text = "Settings and privacy",
                    color=  Color(0xfff8c471),
                    modifier = Modifier.clickable { })
            }



        }
    }


}
@Composable
fun BottomBar(navController: NavHostController) {
    val selectedIndex = remember { mutableStateOf(0) }
    BottomNavigation(
        elevation = 10.dp,
        backgroundColor = Color.White,
        contentColor = Color(0xfff8c471),
    )
    {
        BottomNavigationItem(icon = {
            Icon(imageVector = Icons.Default.Home, "", tint = Color(0xfff8c471))
        },
            label = { Text(text = "Home", color = Color(0xfff8c471)) },
            selected = (selectedIndex.value == 0),
            onClick = {
                selectedIndex.value = 0
            }
        )
        BottomNavigationItem(icon = {
            Icon(imageVector = Icons.Default.Search, "", tint = Color(0xfff8c471))
        },
            label = { Text(text = "Search", color = Color(0xfff8c471)) },
            selected = (selectedIndex.value == 0),
            onClick = {
                selectedIndex.value = 0
            }
        )

        BottomNavigationItem(icon = {
            Icon(imageVector = Icons.Default.ShoppingCart, "", tint = Color(0xfff8c471))
        },
            label = { Text(text = "Cart", color = Color(0xfff8c471)) },
            selected = (selectedIndex.value == 2),
            onClick = {
                selectedIndex.value = 2
            }
        )
    }
}













