package net.ezra.ui.Mountains


import android.content.res.Configuration
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import net.ezra.R
import net.ezra.navigation.ROUTE_CONTACT
import net.ezra.navigation.ROUTE_HOME
import net.ezra.navigation.ROUTE_MOUNTAINS
import net.ezra.navigation.ROUTE_SHOP


@Composable
fun MountkenyaScreen(navController: NavHostController) {
    LazyColumn (modifier=Modifier.fillMaxSize()){
        item{
            Card (modifier=Modifier.fillMaxSize()){


                Image(painter = painterResource(id = R.drawable.img_22), contentDescription ="",modifier=Modifier.fillMaxSize(), contentScale = ContentScale.Crop )

            }
            Spacer(modifier = Modifier.height(15.dp))

            LazyRow (modifier = Modifier.fillMaxWidth()){
                item{
                    Column (verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally){
                        Card (shape = CircleShape, modifier = Modifier
                            .size(60.dp)
                            .clickable {
                                navController.navigate(ROUTE_HOME) {
                                    popUpTo(
                                        ROUTE_MOUNTAINS
                                    )
                                }
                            }){
                            Image(painter = painterResource(id = R.drawable.img_14), contentDescription = "", modifier = Modifier.fillMaxSize(), contentScale = ContentScale.Crop)
                        }
                        Text(text = "Guides",fontWeight = FontWeight.ExtraBold)
                    }
                    Spacer(modifier = Modifier.width(15.dp))
                    Column (verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally){
                        Card (shape = CircleShape, modifier = Modifier
                            .size(60.dp)
                            .clickable {
                                navController.navigate(ROUTE_HOME) {
                                    popUpTo(
                                        ROUTE_MOUNTAINS
                                    )
                                }
                            }){
                            Image(painter = painterResource(id = R.drawable.img_14), contentDescription = "", modifier = Modifier.fillMaxSize(), contentScale = ContentScale.Crop)
                        }
                        Text(text = "Map",fontWeight = FontWeight.ExtraBold)
                    }
                    Spacer(modifier = Modifier.width(15.dp))
                    Column (verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally){
                        Card (shape = CircleShape, modifier = Modifier
                            .size(60.dp)
                            .clickable {
                                navController.navigate(ROUTE_HOME) {
                                    popUpTo(
                                        ROUTE_MOUNTAINS
                                    )
                                }
                            }){
                            Image(painter = painterResource(id = R.drawable.img_14), contentDescription = "", modifier = Modifier.fillMaxSize(), contentScale = ContentScale.Crop)
                        }
                        Text(text = "Transport",fontWeight = FontWeight.ExtraBold)
                    }
                    Spacer(modifier = Modifier.width(15.dp))
                    Column (verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally){
                        Card (shape = CircleShape, modifier = Modifier
                            .size(60.dp)
                            .clickable {
                                navController.navigate(ROUTE_HOME) {
                                    popUpTo(
                                        ROUTE_MOUNTAINS
                                    )
                                }
                            }){
                            Image(painter = painterResource(id = R.drawable.img_14), contentDescription = "", modifier = Modifier.fillMaxSize(), contentScale = ContentScale.Crop)
                        }
                        Text(text = "Contacts",fontWeight = FontWeight.ExtraBold)
                    }
                    Spacer(modifier = Modifier.width(15.dp))
                    Column (verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally){
                        Card (shape = CircleShape, modifier = Modifier
                            .size(60.dp)
                            .clickable {
                                navController.navigate(ROUTE_HOME) {
                                    popUpTo(
                                        ROUTE_MOUNTAINS
                                    )
                                }
                            }){
                            Image(painter = painterResource(id = R.drawable.img_14), contentDescription = "", modifier = Modifier.fillMaxSize(), contentScale = ContentScale.Crop)
                        }
                        Text(text = "Reviews",fontWeight = FontWeight.ExtraBold)
                    }


                }

            }

            Spacer(modifier = Modifier.height(15.dp))

            Row(horizontalArrangement = Arrangement.Start, verticalAlignment = Alignment.CenterVertically){
                Text(text = "Description", fontWeight = FontWeight.ExtraBold,  style = MaterialTheme.typography.h1)

            }
            Spacer(modifier = Modifier.height(5.dp))

            Row (){

                Text(text = "Towering majestically, Mount Kenya, Africa's second-highest peak, captivates with its snow-capped summit and rugged beauty. Its diverse ecosystems, ranging from equatorial forests to alpine moorlands, harbor a wealth of flora and fauna, including rare and endemic species. Climbers are drawn to its challenging routes, while nature lovers revel in its scenic trails, pristine lakes, and panoramic views. Mount Kenya is not just a mountain; it's a sanctuary of awe-inspiring landscapes and thrilling adventures, inviting explorers to discover its hidden treasures.")
            }
            Row( horizontalArrangement = Arrangement.Absolute.SpaceEvenly, verticalAlignment = Alignment.Bottom){

                Button(
                    onClick = {
                        navController.navigate(ROUTE_HOME) { popUpTo(ROUTE_SHOP) }    },
                    colors = ButtonDefaults.buttonColors(Color.Black)

                ) {
                    Text(text = "Book Now", color = Color.White)
                }
                Spacer(modifier = Modifier.width(300.dp))
                Button(
                    onClick = {
                        navController.navigate(ROUTE_HOME) { popUpTo(ROUTE_SHOP) }    },
                    colors = ButtonDefaults.buttonColors(Color.Black)

                ) {
                    Text(text = "Add to Cart", color = Color.White)
                }

            }
        }
    }
}

@Preview(showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_NO)
@Composable
fun MountainScreenPreviewLight() {
    MountkenyaScreen(rememberNavController())
}

