package net.ezra.ui.home

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
import net.ezra.navigation.ROUTE_CART

import net.ezra.navigation.ROUTE_HOME
import net.ezra.navigation.ROUTE_LAKES
import net.ezra.navigation.ROUTE_LOGIN
import net.ezra.navigation.ROUTE_MOUNTAINS
import net.ezra.navigation.ROUTE_POPULAR_HOTELS
import net.ezra.navigation.ROUTE_RADDISONBLU
import net.ezra.navigation.ROUTE_RECOMMENDED_PACKAGES
import net.ezra.navigation.ROUTE_RECOMMENDED_PLACES
import net.ezra.navigation.ROUTE_SEARCH
import net.ezra.navigation.ROUTE_SHOP
import net.ezra.navigation.ROUTE_VASCODAGAMA
import net.ezra.navigation.ROUTE_WILDLIFE
import net.ezra.ui.destinations.DesertsScreen

import org.intellij.lang.annotations.JdkConstants.HorizontalAlignment
data class Screen(val title: String, val icon: Int)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)

@Composable

fun HomePage(navController: NavHostController) {


    var isDrawerOpen by remember { mutableStateOf(false) }

    val callLauncher: ManagedActivityResultLauncher<Intent, ActivityResult> =
        rememberLauncherForActivityResult(contract = ActivityResultContracts.StartActivityForResult()) { _ ->

        }


    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = {
                    Column (){
                        Text(text = " Welcome back")
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

                LazyColumn ( horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.SpaceEvenly){

                    item {



                        Spacer(modifier = Modifier.height(15.dp))

                        Row(Modifier.fillMaxWidth()){

                            Text(text = "")

                        }

                        Spacer(modifier = Modifier.height(15.dp) )

                        Row(modifier=Modifier.fillMaxWidth()){
                            LazyRow(modifier=Modifier.fillMaxWidth()){
                                item{




                                    Card( modifier = Modifier
                                        .padding(15.dp)
                                        .border(
                                            shape = RoundedCornerShape(10.dp),
                                            width = 1.dp,
                                            color = Color.White
                                        )
                                        .shadow(elevation = 10.dp)
                                        .clickable {
                                            navController.navigate(ROUTE_WILDLIFE) {
                                                popUpTo(
                                                    ROUTE_HOME
                                                )
                                            }
                                        })
                                    {
                                        Row (horizontalArrangement = Arrangement.Absolute.Center, verticalAlignment = Alignment.CenterVertically, modifier = Modifier.background(
                                            Color.White)){
                                            Image(painter = painterResource(id = R.drawable.img_5), contentDescription = "" , modifier = Modifier.size(70.dp))
                                            Text(text = "Wildlife")
                                        }
                                    }
                                    Spacer(modifier = Modifier.width(15.dp))


                                    Card( modifier = Modifier
                                        .padding(15.dp)
                                        .border(
                                            shape = RoundedCornerShape(10.dp),
                                            width = 1.dp,
                                            color = Color.White
                                        )
                                        .shadow(elevation = 10.dp)
                                        .clickable {
                                            navController.navigate(ROUTE_BEACHES) {
                                                popUpTo(
                                                    ROUTE_HOME
                                                )
                                            }
                                        }) {
                                        Row(horizontalArrangement = Arrangement.Absolute.Center, verticalAlignment = Alignment.CenterVertically,modifier = Modifier.background(
                                            Color.White)) {
                                            Image(painter = painterResource(id = R.drawable.img_4), contentDescription = "" , modifier = Modifier.size(70.dp))
                                            Text(text = "Beaches")
                                        }
                                    }
                                    Spacer(modifier = Modifier.width(15.dp))


                                    Card( modifier = Modifier
                                        .padding(15.dp)
                                        .border(
                                            shape = RoundedCornerShape(10.dp),
                                            width = 1.dp,
                                            color = Color.White
                                        )
                                        .shadow(elevation = 10.dp)
                                        .clickable {
                                            navController.navigate(ROUTE_LAKES) {
                                                popUpTo(
                                                    ROUTE_HOME
                                                )
                                            }
                                        }) {
                                        Row(horizontalArrangement = Arrangement.Absolute.Center, verticalAlignment = Alignment.CenterVertically,modifier = Modifier.background(
                                            Color.White)){
                                            Image(painter = painterResource(id = R.drawable.img_2), contentDescription = "" , modifier = Modifier.size(70.dp))
                                            Text(text = "Lakes")
                                        }
                                    }
                                    Spacer(modifier = Modifier.width(15.dp))


                                    Card( modifier = Modifier
                                        .padding(15.dp)
                                        .border(
                                            shape = RoundedCornerShape(10.dp),
                                            width = 1.dp,
                                            color = Color.White
                                        )
                                        .shadow(elevation = 10.dp)
                                        .clickable {
                                            navController.navigate(ROUTE_HOME) {
                                                popUpTo(
                                                    ROUTE_HOME
                                                )
                                            }
                                        })
                                    {
                                        Row (horizontalArrangement = Arrangement.Absolute.Center, verticalAlignment = Alignment.CenterVertically,modifier = Modifier.background(
                                            Color.White)){
                                            Image(painter = painterResource(id = R.drawable.img), contentDescription = "", modifier = Modifier.size(70.dp) )
                                            Text(text = "Deserts")
                                        }
                                    }
                                    Spacer(modifier = Modifier.width(15.dp))

                                    Card( modifier = Modifier
                                        .padding(15.dp)
                                        .border(
                                            shape = RoundedCornerShape(10.dp),
                                            width = 1.dp,
                                            color = Color.White
                                        )
                                        .shadow(elevation = 10.dp)
                                        .clickable {
                                            navController.navigate(ROUTE_HOME) {
                                                popUpTo(
                                                    ROUTE_HOME
                                                )
                                            }
                                        }) {
                                        Row (horizontalArrangement = Arrangement.Absolute.Center, verticalAlignment = Alignment.CenterVertically,modifier = Modifier.background(
                                            Color.White)){
                                            Image(painter = painterResource(id = R.drawable.img_1), contentDescription = "" , modifier = Modifier.size(70.dp))
                                            Text(text = "Mountains")


                                        }
                                    }
                                    Spacer(modifier = Modifier.width(20.dp))

                                    Card( modifier = Modifier
                                        .padding(15.dp)
                                        .border(
                                            shape = RoundedCornerShape(10.dp),
                                            width = 1.dp,
                                            color = Color.White
                                        )
                                        .shadow(elevation = 10.dp)
                                        .clickable {
                                            navController.navigate(ROUTE_HOME) {
                                                popUpTo(
                                                    ROUTE_HOME
                                                )
                                            }
                                        }) {
                                        Row (horizontalArrangement = Arrangement.Absolute.Center, verticalAlignment = Alignment.CenterVertically,modifier = Modifier.background(
                                            Color.White)){
                                            Image(painter = painterResource(id = R.drawable.img_6), contentDescription = "" , modifier = Modifier.size(70.dp))
                                            Text(text = "Culture")
                                        }
                                    }


                                }
                            }
                        }



                        Spacer(modifier = Modifier.height(15.dp) )
                        Row (
                            horizontalArrangement = Arrangement.SpaceBetween , modifier=Modifier.fillMaxWidth()
                        )
                        {
                            Column(horizontalAlignment = AbsoluteAlignment.Left){
                                Text(text = "Popular Packages",fontWeight = FontWeight.ExtraBold)
                            }
                            Spacer(modifier = Modifier.width(50.dp))
                            Column(horizontalAlignment = AbsoluteAlignment.Right){
                                Text(text = " View all",  color=  Color(0xfff8c471),modifier = Modifier.clickable {  navController.navigate(
                                    ROUTE_RECOMMENDED_PACKAGES) { popUpTo(ROUTE_HOME)} })
                            }


                        }

                        LazyRow(modifier=Modifier.fillMaxWidth()) {

                            item {
                                Card(modifier = Modifier
                                    .padding(15.dp)
                                    .border(
                                        shape = RoundedCornerShape(10.dp),
                                        width = 1.dp,
                                        color = Color.White
                                    )
                                    .shadow(elevation = 10.dp)
                                    .clickable {
                                        navController.navigate(ROUTE_MOUNTAINS) {
                                            popUpTo(
                                                ROUTE_HOME
                                            )
                                        }
                                    }) {
                                    Column(modifier = Modifier.background(
                                        Color.White)) {
                                        Image(painter = painterResource(id = R.drawable.img_17), contentDescription = "" , modifier = Modifier
                                            .fillMaxWidth()
                                            .padding(5.dp),contentScale = ContentScale.Fit)
                                        Row(modifier=Modifier.fillMaxWidth()){
                                            Column (verticalArrangement = Arrangement.Center, horizontalAlignment = AbsoluteAlignment.Left){
                                                Text(text = "Along Rift Valley")
                                                Row (horizontalArrangement = Arrangement.Center, verticalAlignment = Alignment.CenterVertically){
                                                    Icon(imageVector =Icons.Default.LocationOn , contentDescription ="",modifier=Modifier.size(15.dp) )
                                                    Text(text = "Turkana-Kajiado",fontWeight = FontWeight.ExtraLight)
                                                }

                                            }
                                            Spacer(modifier = Modifier.width(40.dp))

                                            Column (verticalArrangement = Arrangement.Center, horizontalAlignment = AbsoluteAlignment.Right){
                                                Text(text = "3 Days")
                                                Text(text = "2 Nights")
                                            }

                                        }

                                    }
                                }
                                Spacer(modifier = Modifier.width(15.dp))

                                Card(modifier = Modifier
                                    .padding(15.dp)
                                    .border(
                                        shape = RoundedCornerShape(10.dp),
                                        width = 1.dp,
                                        color = Color.White
                                    )
                                    .shadow(elevation = 10.dp)
                                    .clickable {
                                        navController.navigate(ROUTE_MOUNTAINS) {
                                            popUpTo(
                                                ROUTE_HOME
                                            )
                                        }
                                    }) {
                                    Column(modifier = Modifier.background(
                                        Color.White)) {
                                        Image(painter = painterResource(id = R.drawable.img_17), contentDescription = "" , modifier = Modifier
                                            .fillMaxWidth()
                                            .padding(5.dp),contentScale = ContentScale.Fit)

                                            Row(){
                                            Column (verticalArrangement = Arrangement.Center, horizontalAlignment = AbsoluteAlignment.Left){
                                                Text(text = "Summit Madness")
                                                Row(horizontalArrangement = Arrangement.Center, verticalAlignment = Alignment.CenterVertically){
                                                    Icon(imageVector =Icons.Default.LocationOn , contentDescription ="",modifier=Modifier.size(15.dp) )
                                                    Text(text = "Mombasa-Kajiado", fontWeight = FontWeight.ExtraLight,)
                                                }


                                            }
                                                Spacer(modifier = Modifier.width(40.dp))

                                            Column (verticalArrangement = Arrangement.Center, horizontalAlignment = AbsoluteAlignment.Right){
                                                Text(text = " 4 Days")
                                                Text(text = " 3 Nights")
                                            }
                                        }


                                    }
                                }
                                Spacer(modifier = Modifier.width(15.dp))

                                Card(modifier = Modifier
                                    .padding(15.dp)
                                    .border(
                                        shape = RoundedCornerShape(10.dp),
                                        width = 1.dp,
                                        color = Color.White
                                    )
                                    .shadow(elevation = 10.dp)
                                    .clickable {
                                        navController.navigate(ROUTE_MOUNTAINS) {
                                            popUpTo(
                                                ROUTE_HOME
                                            )
                                        }
                                    })  {
                                    Column(modifier = Modifier.background(
                                        Color.White)) {
                                        Image(painter = painterResource(id = R.drawable.img_17), contentDescription = "" , modifier = Modifier
                                            .fillMaxWidth()
                                            .padding(5.dp),contentScale = ContentScale.Fit)
                                        Row (modifier=Modifier.fillMaxWidth()){
                                            Column (verticalArrangement = Arrangement.Center, horizontalAlignment = AbsoluteAlignment.Left){
                                                Text(text = "Kenya Classics")
                                                Row(horizontalArrangement = Arrangement.Center, verticalAlignment = Alignment.CenterVertically){
                                                    Icon(imageVector =Icons.Default.LocationOn , contentDescription ="",modifier=Modifier.size(15.dp) )
                                                    Text(text = "Nairobi-Mombasa", fontWeight = FontWeight.ExtraLight,)
                                                }

                                            }
                                            Spacer(modifier = Modifier.width(40.dp))

                                            Column (verticalArrangement = Arrangement.Center, horizontalAlignment = AbsoluteAlignment.Right)
                                            {
                                                Text(text = "10 Days")
                                                Text(text = "9 Nights")
                                            }

                                        }


                                    }
                                }

                                Spacer(modifier = Modifier.width(15.dp))

                                Card(
                                    modifier = Modifier
                                        .padding(15.dp)
                                        .border(
                                            shape = RoundedCornerShape(10.dp),
                                            width = 1.dp,
                                            color = Color.White
                                        )
                                        .shadow(elevation = 10.dp)
                                        .clickable {
                                            navController.navigate(ROUTE_MOUNTAINS) {
                                                popUpTo(
                                                    ROUTE_HOME
                                                )
                                            }
                                        }
                                ) {
                                    Column(modifier = Modifier.background(Color.White)) {
                                        Image(
                                            painter = painterResource(id = R.drawable.img_17),
                                            contentDescription = "",
                                            modifier = Modifier
                                                .fillMaxWidth()
                                                .padding(5.dp),
                                            contentScale = ContentScale.Fit
                                        )
                                        Row(modifier = Modifier.fillMaxWidth()) {
                                            Column(
                                                verticalArrangement = Arrangement.Center,
                                                horizontalAlignment = AbsoluteAlignment.Left
                                            ) {
                                                Text(text = "Kenya Classics")
                                                Row(
                                                    horizontalArrangement = Arrangement.Center,
                                                    verticalAlignment = Alignment.CenterVertically
                                                ) {
                                                    Icon(imageVector = Icons.Default.LocationOn, contentDescription = "", modifier = Modifier.size(15.dp))
                                                    Text(text = "Nairobi-Mombasa", fontWeight = FontWeight.ExtraLight)
                                                }
                                            }
                                            Spacer(modifier = Modifier.width(40.dp))
                                            Column(verticalArrangement = Arrangement.Center, horizontalAlignment = AbsoluteAlignment.Right) {
                                                Text(text = "10 Days")
                                                Text(text = "9 Nights")
                                            }
                                        }
                                    }
                                }

                                Spacer(modifier = Modifier.width(15.dp))

                                Card(modifier = Modifier
                                    .padding(15.dp)
                                    .border(
                                        shape = RoundedCornerShape(10.dp),
                                        width = 1.dp,
                                        color = Color.White
                                    )
                                    .shadow(elevation = 10.dp)
                                    .clickable {
                                        navController.navigate(ROUTE_MOUNTAINS) {
                                            popUpTo(
                                                ROUTE_HOME
                                            )
                                        }
                                    })  {
                                    Column(modifier = Modifier.background(
                                        Color.White)) {
                                        Image(painter = painterResource(id = R.drawable.img_17), contentDescription = "" , modifier = Modifier
                                            .fillMaxWidth()
                                            .padding(5.dp),contentScale = ContentScale.Fit)

                                            Row(){
                                            Column (verticalArrangement = Arrangement.Center, horizontalAlignment = AbsoluteAlignment.Left){
                                                Text(text = "Time travel")
                                                Row(horizontalArrangement = Arrangement.Center, verticalAlignment = Alignment.CenterVertically){
                                                    Icon(imageVector =Icons.Default.LocationOn , contentDescription ="",modifier=Modifier.size(15.dp) )
                                                    Text(text = "Mombasa-Turkana", fontWeight = FontWeight.ExtraLight,)
                                                }

                                            }
                                                Spacer(modifier = Modifier.width(40.dp))

                                            Column (verticalArrangement = Arrangement.Center, horizontalAlignment = AbsoluteAlignment.Right){
                                                Text(text = "5 Days")
                                                Text(text = "4 Nights")
                                            }

                                    }
                                    }
                                }
                                Spacer(modifier = Modifier.width(15.dp))

                                Card(modifier = Modifier
                                    .padding(15.dp)
                                    .border(
                                        shape = RoundedCornerShape(10.dp),
                                        width = 1.dp,
                                        color = Color.White
                                    )
                                    .shadow(elevation = 10.dp)
                                    .clickable {
                                        navController.navigate(ROUTE_MOUNTAINS) {
                                            popUpTo(
                                                ROUTE_HOME
                                            )
                                        }
                                    })  {

                                    Column(modifier = Modifier.background(
                                        Color.White)) {
                                        Image(painter = painterResource(id = R.drawable.img_17), contentDescription = "" , modifier = Modifier
                                            .fillMaxSize()
                                            .padding(5.dp),contentScale = ContentScale.Fit)
                                        Row (modifier=Modifier.fillMaxWidth()){
                                            Row{
                                                Column (verticalArrangement = Arrangement.Center, horizontalAlignment = AbsoluteAlignment.Left)
                                                {
                                                    Text(text = "Karibu Kenya")
                                                    Row (horizontalArrangement = Arrangement.Center, verticalAlignment = Alignment.CenterVertically)
                                                    {
                                                        Icon(imageVector =Icons.Default.LocationOn , contentDescription ="",modifier=Modifier.size(15.dp) )
                                                        Text(text = "Kiambu-Mombasa", fontWeight = FontWeight.ExtraLight,)

                                                    }
                                                }
                                                Spacer(modifier = Modifier.width(40.dp))

                                                Column (verticalArrangement = Arrangement.Center, horizontalAlignment = AbsoluteAlignment.Right)
                                                {
                                                    Text(text = "7 Days")
                                                    Text(text = "6 Nights")
                                                }
                                            }


                                        }




                                    }
                                }

                            }
                        }
                        Spacer(modifier =Modifier.height(20.dp) )

                        Row (horizontalArrangement = Arrangement.SpaceBetween ,modifier=Modifier.fillMaxWidth()){
                            Column( horizontalAlignment = AbsoluteAlignment.Left) {
                                Text(text = "Recommended Places",fontWeight = FontWeight.ExtraBold,)
                            }
                            Spacer(modifier = Modifier.width(50.dp))

                            Column( horizontalAlignment = AbsoluteAlignment.Right) {
                                Text(text = "View all",  color=  Color(0xfff8c471),modifier = Modifier.clickable {  navController.navigate(
                                    ROUTE_RECOMMENDED_PLACES) { popUpTo(ROUTE_HOME)}})
                            }


                        }


                        LazyRow (modifier = Modifier.fillMaxWidth()){
                            item {

                                Column (verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally){
                                    Card (shape = CircleShape, modifier = Modifier
                                        .size(80.dp)
                                        .clickable {
                                            navController.navigate(ROUTE_VASCODAGAMA) {
                                                popUpTo(
                                                    ROUTE_HOME
                                                )
                                            }
                                        }){
                                        Image(painter = painterResource(id = R.drawable.img_14), contentDescription = "", modifier = Modifier.fillMaxSize(), contentScale = ContentScale.Crop)
                                    }
                                    Text(text = "Vasco da Gama")
                                }
                                Spacer(modifier = Modifier.width(15.dp))

                                Column (verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally){
                                    Card (shape = CircleShape, modifier = Modifier
                                        .size(80.dp)
                                        .clickable {
                                            navController.navigate(ROUTE_VASCODAGAMA) {
                                                popUpTo(
                                                    ROUTE_HOME
                                                )
                                            }
                                        }){
                                        Image(painter = painterResource(id = R.drawable.img_15), contentDescription = "", modifier = Modifier.fillMaxSize(),contentScale = ContentScale.Crop)
                                    }
                                    Text(text = "Fort Jesus")
                                }
                                Spacer(modifier = Modifier.width(15.dp))

                                Column (verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally){
                                    Card (shape = CircleShape, modifier = Modifier
                                        .size(80.dp)
                                        .clickable {
                                            navController.navigate(ROUTE_VASCODAGAMA) {
                                                popUpTo(
                                                    ROUTE_HOME
                                                )
                                            }
                                        }){
                                        Image(painter = painterResource(id = R.drawable.img_16), contentDescription = "", modifier = Modifier.fillMaxSize(),contentScale = ContentScale.Crop)
                                    }
                                    Text(text = "Hell's gate")
                                }
                                Spacer(modifier = Modifier.width(15.dp))

                                Column (verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally){
                                    Card (shape = CircleShape, modifier = Modifier
                                        .size(80.dp)
                                        .clickable {
                                            navController.navigate(ROUTE_VASCODAGAMA) {
                                                popUpTo(
                                                    ROUTE_HOME
                                                )
                                            }
                                        }){
                                        Image(painter = painterResource(id = R.drawable.img_10), contentDescription = "", modifier = Modifier.fillMaxSize(),contentScale = ContentScale.Crop)
                                    }
                                    Text(text = "Wildebeests")
                                }
                                Spacer(modifier = Modifier.width(15.dp))

                                Column (verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally){
                                    Card (shape = CircleShape, modifier = Modifier
                                        .size(80.dp)
                                        .clickable {
                                            navController.navigate(ROUTE_VASCODAGAMA) {
                                                popUpTo(
                                                    ROUTE_HOME
                                                )
                                            }
                                        }){
                                        Image(painter = painterResource(id = R.drawable.img_11), contentDescription = "", modifier = Modifier.fillMaxSize(),contentScale = ContentScale.Crop)
                                    }
                                    Text(text = "Fourteen falls")
                                }
                                Spacer(modifier = Modifier.width(15.dp))

                                Column (verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally){
                                    Card (shape = CircleShape, modifier = Modifier
                                        .size(80.dp)
                                        .clickable {
                                            navController.navigate(ROUTE_VASCODAGAMA) {
                                                popUpTo(
                                                    ROUTE_HOME
                                                )
                                            }
                                        }){
                                        Image(painter = painterResource(id = R.drawable.img_19), contentDescription = "", modifier = Modifier.fillMaxSize(),contentScale = ContentScale.Crop)
                                    }
                                    Text(text = "Hot Springs")
                                }
                                Spacer(modifier = Modifier.width(10.dp))

                                Column (verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally) {
                                    Card(shape = CircleShape, modifier = Modifier
                                        .size(80.dp)
                                        .clickable {
                                            navController.navigate(ROUTE_HOME) {
                                                popUpTo(
                                                    ROUTE_VASCODAGAMA
                                                )
                                            }
                                        }) {
                                        Image(
                                            painter = painterResource(id = R.drawable.img_18),
                                            contentDescription = "",
                                            modifier = Modifier.fillMaxSize(),
                                            contentScale = ContentScale.Crop
                                        )
                                    }
                                    Text(text = "Flamingos")



                                }
                            }
                        }

                        Spacer(modifier =Modifier.height(20.dp))

                        Row (horizontalArrangement = Arrangement.SpaceBetween ,modifier=Modifier.fillMaxWidth()){
                            Column( horizontalAlignment = AbsoluteAlignment.Left) {
                                Text(text = "Popular Hotels",fontWeight = FontWeight.ExtraBold,)
                            }

                            Column( horizontalAlignment = AbsoluteAlignment.Right) {
                                Text(text = "View all", color=  Color(0xfff8c471), modifier = Modifier.clickable {  navController.navigate(ROUTE_POPULAR_HOTELS) {
                                    popUpTo(
                                    ROUTE_HOME  )
                                }})
                            }


                        }


                        Column (modifier = Modifier.fillMaxWidth()) {

                            Card(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(15.dp)
                                    .border(
                                        shape = RoundedCornerShape(10.dp),
                                        width = 1.dp,
                                        color = Color.White
                                    )
                                    .shadow(elevation = 10.dp)
                                    .clickable {
                                        navController.navigate(ROUTE_RADDISONBLU) {
                                            popUpTo(
                                                ROUTE_HOME
                                            )
                                        }
                                    }
                            ) {
                                Row(horizontalArrangement = Arrangement.SpaceEvenly, verticalAlignment = Alignment.Bottom,modifier = Modifier
                                    .background(
                                        Color.White
                                    )
                                    .width(500.dp)) {
                                    Image(painter = painterResource(id = R.drawable.img_4), contentDescription = "" )
                                    Spacer(modifier = Modifier.width(10.dp))
                                    Column (verticalArrangement = Arrangement.Center, horizontalAlignment = AbsoluteAlignment.Left) {
                                        Row(horizontalArrangement = Arrangement.Absolute.Left) {
                                            Text(
                                                text = "Raddison Blu"
                                            )
                                        }
                                        Row(horizontalArrangement = Arrangement.Absolute.Left) {
                                            Icon(
                                                imageVector = Icons.Default.Place,
                                                contentDescription = ""
                                            )
                                            Text(text = "Nairobi", fontWeight = FontWeight.ExtraLight)
                                        }
                                    }
                                    Spacer(modifier = Modifier.width(10.dp))

                                    Column (verticalArrangement = Arrangement.Center, horizontalAlignment = AbsoluteAlignment.Left) {


                                        Row(horizontalArrangement = Arrangement.Absolute.Left) {
                                            Text(text = "$30/night")
                                        }

                                        Row(horizontalArrangement = Arrangement.Absolute.Right) {

                                            Icon(
                                                imageVector = Icons.Default.Star,
                                                contentDescription = "Review",
                                                tint = Color.Yellow
                                            )


                                            Text(text = "4.9")
                                        }

                                    }
                                }
                            }
                            Spacer(modifier = Modifier.height(20.dp))

                            Card(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(15.dp)
                                    .border(
                                        shape = RoundedCornerShape(10.dp),
                                        width = 1.dp,
                                        color = Color.White
                                    )
                                    .shadow(elevation = 10.dp)
                                    .clickable {
                                        navController.navigate(ROUTE_RADDISONBLU) {
                                            popUpTo(
                                                ROUTE_HOME
                                            )
                                        }
                                    }
                            ) {
                                Row(horizontalArrangement = Arrangement.SpaceEvenly, verticalAlignment = Alignment.Bottom,modifier = Modifier
                                    .background(
                                        Color.White
                                    )
                                    .width(500.dp)) {
                                    Image(painter = painterResource(id = R.drawable.img_4), contentDescription = "" )
                                  Spacer(modifier = Modifier.width(10.dp))
                                    Column (verticalArrangement = Arrangement.Center, horizontalAlignment = AbsoluteAlignment.Left) {
                                        Row(horizontalArrangement = Arrangement.Absolute.Left) {
                                            Text(
                                                text = "Raddison Blu"
                                            )
                                        }
                                        Row(horizontalArrangement = Arrangement.Absolute.Left) {
                                            Icon(
                                                imageVector = Icons.Default.Place,
                                                contentDescription = ""
                                            )
                                            Text(text = "Nairobi", fontWeight = FontWeight.ExtraLight)
                                        }
                                    }
                                    Spacer(modifier = Modifier.width(10.dp))

                                    Column (verticalArrangement = Arrangement.Center, horizontalAlignment = AbsoluteAlignment.Left) {


                                        Row(horizontalArrangement = Arrangement.Absolute.Left) {
                                            Text(text = "$30/night")
                                        }

                                        Row(horizontalArrangement = Arrangement.Absolute.Right) {

                                            Icon(
                                                imageVector = Icons.Default.Star,
                                                contentDescription = "Review",
                                                tint = Color.Yellow
                                            )


                                            Text(text = "4.9")
                                        }

                                    }
                                }
                            }
                            Spacer(modifier = Modifier.height(20.dp))

                            Card(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(15.dp)
                                    .border(
                                        shape = RoundedCornerShape(10.dp),
                                        width = 1.dp,
                                        color = Color.White
                                    )
                                    .shadow(elevation = 10.dp)
                                    .clickable {
                                        navController.navigate(ROUTE_RADDISONBLU) {
                                            popUpTo(
                                                ROUTE_HOME
                                            )
                                        }
                                    }
                            ) {
                                Row(horizontalArrangement = Arrangement.SpaceEvenly, verticalAlignment = Alignment.Bottom,modifier = Modifier
                                    .background(
                                        Color.White
                                    )
                                    .width(500.dp)) {
                                    Image(painter = painterResource(id = R.drawable.img_4), contentDescription = "" )
                                    Spacer(modifier = Modifier.width(10.dp))
                                    Column (verticalArrangement = Arrangement.Center, horizontalAlignment = AbsoluteAlignment.Left) {
                                        Row(horizontalArrangement = Arrangement.Absolute.Left) {
                                            Text(
                                                text = "Raddison Blu"
                                            )
                                        }
                                        Row(horizontalArrangement = Arrangement.Absolute.Left) {
                                            Icon(
                                                imageVector = Icons.Default.Place,
                                                contentDescription = ""
                                            )
                                            Text(text = "Nairobi", fontWeight = FontWeight.ExtraLight)
                                        }
                                    }
                                    Spacer(modifier = Modifier.width(10.dp))

                                    Column (verticalArrangement = Arrangement.Center, horizontalAlignment = AbsoluteAlignment.Left) {


                                        Row(horizontalArrangement = Arrangement.Absolute.Left) {
                                            Text(text = "$30/night")
                                        }

                                        Row(horizontalArrangement = Arrangement.Absolute.Right) {

                                            Icon(
                                                imageVector = Icons.Default.Star,
                                                contentDescription = "Review",
                                                tint = Color.Yellow
                                            )


                                            Text(text = "4.9")
                                        }

                                    }
                                }
                            }





                        }

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
    val drawerWidth = remember { Animatable(if (isOpen) 300f else 0f) }





    LaunchedEffect(isOpen) {
        drawerWidth.animateTo(if (isOpen) 300f else 0f, animationSpec = tween(durationMillis = 300))
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
                   fontWeight = FontWeight.ExtraLight,

               )
           }
          }
            Spacer(modifier = Modifier.height(50.dp))
            Row() {
                Icon(imageVector = Icons.Default.Info, contentDescription = "", tint =  Color(0xfff8c471) )
              Spacer(modifier = Modifier.width(5.dp))
                Text(text = "What's new",
                    color=  Color(0xfff8c471),
                    modifier = Modifier.clickable { },
                    fontWeight = FontWeight.ExtraBold)
            }
            Spacer(modifier = Modifier.height(50.dp))
            Row() {
                Icon(imageVector = Icons.Default.Create, contentDescription = "", tint =  Color(0xfff8c471) )
                Spacer(modifier = Modifier.width(5.dp))
                Text(text = "History",
                    color=  Color(0xfff8c471),
                    modifier = Modifier.clickable { },
                    fontWeight = FontWeight.ExtraBold)
            }

            Spacer(modifier = Modifier.height(50.dp))
            Row() {
               Icon(imageVector = Icons.Default.Settings, contentDescription = "", tint =  Color(0xfff8c471) )
                Spacer(modifier = Modifier.width(5.dp))
                Text(text = "Settings and privacy",
                    color=  Color(0xfff8c471),
                    modifier = Modifier.clickable { },
                    fontWeight = FontWeight.ExtraBold)
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
                    navController.navigate(ROUTE_HOME) { popUpTo(ROUTE_HOME) }    },
                selectedContentColor = Color.Black
            )
            BottomNavigationItem(icon = {
                Icon(imageVector = Icons.Default.Search, "", tint = Color(0xfff8c471))
            },
                label = { Text(text = "Search", color = Color(0xfff8c471)) },
                selected = (selectedIndex.value == 0),
                onClick = {
                    navController.navigate(ROUTE_SEARCH) { popUpTo(ROUTE_HOME) }    },
                selectedContentColor = Color.Black
            )

            BottomNavigationItem(icon = {
                Icon(imageVector = Icons.Default.ShoppingCart, "", tint = Color(0xfff8c471))
            },
                label = { Text(text = "Cart", color = Color(0xfff8c471)) },
                selected = (selectedIndex.value == 2),
                onClick = {
                    navController.navigate(ROUTE_CART) { popUpTo(ROUTE_HOME) }    },
                selectedContentColor = Color.Black
            )
        }
    }



    









