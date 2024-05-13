package net.ezra.ui.Hotels





import android.graphics.drawable.Icon
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
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Place
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
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
import androidx.compose.ui.Alignment
import androidx.compose.ui.draw.shadow
import net.ezra.navigation.ROUTE_BEACHES
import net.ezra.navigation.ROUTE_HOME
import net.ezra.navigation.ROUTE_RADDISONBLU


@Composable
fun PopularHotels(navController: NavHostController) {

    LazyColumn (){
        item{

            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(15.dp)
                    .border(shape = RoundedCornerShape(10.dp), width = 1.dp, color = Color.White)
                    .shadow(elevation = 10.dp)
                    .clickable {  navController.navigate(ROUTE_RADDISONBLU) { popUpTo(
                        ROUTE_HOME)}}
            )  {
                Row(horizontalArrangement = Arrangement.Absolute.Center, verticalAlignment = Alignment.CenterVertically,modifier = Modifier.background(
                    Color.White
                ).width(500.dp)) {
                    Image(painter = painterResource(id = R.drawable.img_4), contentDescription = "" , modifier = Modifier.size(70.dp))
                    Column (){
                        Row(horizontalArrangement = Arrangement.Absolute.Left){Text(text = "Raddison Blu")}
                        Row(horizontalArrangement = Arrangement.Absolute.Left){
                            Icon(
                                imageVector = Icons.Default.Place ,
                                contentDescription = ""
                            )
                            Text(text = "Nairobi")}
                        Row(horizontalArrangement = Arrangement.Absolute.Left){

                            Icon(
                                imageVector = Icons.Default.Star,
                                contentDescription = "Review",
                                tint = Color.Yellow
                            )


                            Text(text = "4.9")}
                        Row(horizontalArrangement = Arrangement.Absolute.Right){
                            Text(text = "$30/night")}
                    }
                }
            }
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(15.dp)
                    .border(shape = RoundedCornerShape(10.dp), width = 1.dp, color = Color.White)
                    .shadow(elevation = 10.dp)
                    .clickable {  navController.navigate(ROUTE_RADDISONBLU) { popUpTo(
                        ROUTE_HOME)}}
            ) {
                Row(horizontalArrangement = Arrangement.Absolute.Center, verticalAlignment = Alignment.CenterVertically,modifier = Modifier.background(
                    Color.White
                ).width(500.dp)) {
                    Image(painter = painterResource(id = R.drawable.img_4), contentDescription = "" , modifier = Modifier.size(70.dp))
                    Column (){
                        Row(horizontalArrangement = Arrangement.Absolute.Left){Text(text = "Raddison Blu")}
                        Row(horizontalArrangement = Arrangement.Absolute.Left){
                            Icon(
                                imageVector = Icons.Default.Place ,
                                contentDescription = ""
                            )
                            Text(text = "Nairobi")}
                        Row(horizontalArrangement = Arrangement.Absolute.Left){

                            Icon(
                                imageVector = Icons.Default.Star,
                                contentDescription = "Review",
                                tint = Color.Yellow
                            )


                            Text(text = "4.9")}
                        Row(horizontalArrangement = Arrangement.Absolute.Right){
                            Text(text = "$30/night")}
                    }
                }
            }

            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(15.dp)
                    .border(shape = RoundedCornerShape(10.dp), width = 1.dp, color = Color.White)
                    .shadow(elevation = 10.dp)
                    .clickable {  navController.navigate(ROUTE_RADDISONBLU) { popUpTo(
                        ROUTE_HOME)}}
            ) {
                Row(horizontalArrangement = Arrangement.Absolute.Center, verticalAlignment = Alignment.CenterVertically,modifier = Modifier.background(
                    Color.White
                ).width(500.dp)) {
                    Image(painter = painterResource(id = R.drawable.img_4), contentDescription = "" , modifier = Modifier.size(70.dp))
                    Column (){
                        Row(horizontalArrangement = Arrangement.Absolute.Left){Text(text = "Raddison Blu")}
                        Row(horizontalArrangement = Arrangement.Absolute.Left){
                            Icon(
                                imageVector = Icons.Default.Place ,
                                contentDescription = ""
                            )
                            Text(text = "Nairobi")}
                        Row(horizontalArrangement = Arrangement.Absolute.Left){

                            Icon(
                                imageVector = Icons.Default.Star,
                                contentDescription = "Review",
                                tint = Color.Yellow
                            )


                            Text(text = "4.9")}
                        Row(horizontalArrangement = Arrangement.Absolute.Right){
                            Text(text = "$30/night")}
                    }
                }
            }
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(15.dp)
                    .border(shape = RoundedCornerShape(10.dp), width = 1.dp, color = Color.White)
                    .shadow(elevation = 10.dp)
                    .clickable {  navController.navigate(ROUTE_RADDISONBLU) { popUpTo(
                        ROUTE_HOME)}}
            ) {
                Row(horizontalArrangement = Arrangement.Absolute.Center, verticalAlignment = Alignment.CenterVertically,modifier = Modifier.background(
                    Color.White
                ).width(500.dp)) {
                    Image(painter = painterResource(id = R.drawable.img_4), contentDescription = "" , modifier = Modifier.size(70.dp))
                    Column (){
                        Row(horizontalArrangement = Arrangement.Absolute.Left){Text(text = "Raddison Blu")}
                        Row(horizontalArrangement = Arrangement.Absolute.Left){
                            Icon(
                                imageVector = Icons.Default.Place ,
                                contentDescription = ""
                            )
                            Text(text = "Nairobi")}
                        Row(horizontalArrangement = Arrangement.Absolute.Left){

                            Icon(
                                imageVector = Icons.Default.Star,
                                contentDescription = "Review",
                                tint = Color.Yellow
                            )


                            Text(text = "4.9")}
                        Row(horizontalArrangement = Arrangement.Absolute.Right){
                            Text(text = "$30/night")}
                    }
                }
            }
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(15.dp)
                    .border(shape = RoundedCornerShape(10.dp), width = 1.dp, color = Color.White)
                    .shadow(elevation = 10.dp)
                    .clickable {  navController.navigate(ROUTE_RADDISONBLU) { popUpTo(
                        ROUTE_HOME)}}
            ) {
                Row(horizontalArrangement = Arrangement.Absolute.Center, verticalAlignment = Alignment.CenterVertically,modifier = Modifier.background(
                    Color.White
                ).width(500.dp)) {
                    Image(painter = painterResource(id = R.drawable.img_4), contentDescription = "" , modifier = Modifier.size(70.dp))
                    Column (){
                        Row(horizontalArrangement = Arrangement.Absolute.Left){Text(text = "Raddison Blu")}
                        Row(horizontalArrangement = Arrangement.Absolute.Left){
                            Icon(
                                imageVector = Icons.Default.Place ,
                                contentDescription = ""
                            )
                            Text(text = "Nairobi")}
                        Row(horizontalArrangement = Arrangement.Absolute.Left){

                            Icon(
                                imageVector = Icons.Default.Star,
                                contentDescription = "Review",
                                tint = Color.Yellow
                            )


                            Text(text = "4.9")}
                        Row(horizontalArrangement = Arrangement.Absolute.Right){
                            Text(text = "$30/night")}
                    }
                }
            }
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(15.dp)
                    .border(shape = RoundedCornerShape(10.dp), width = 1.dp, color = Color.White)
                    .shadow(elevation = 10.dp)
                    .clickable {  navController.navigate(ROUTE_RADDISONBLU) { popUpTo(
                        ROUTE_HOME)}}
            ) {
                Row(horizontalArrangement = Arrangement.Absolute.Center, verticalAlignment = Alignment.CenterVertically,modifier = Modifier.background(
                    Color.White
                ).width(500.dp)) {
                    Image(painter = painterResource(id = R.drawable.img_4), contentDescription = "" , modifier = Modifier.size(70.dp))
                    Column (){
                        Row(horizontalArrangement = Arrangement.Absolute.Left){Text(text = "Raddison Blu")}
                        Row(horizontalArrangement = Arrangement.Absolute.Left){
                            Icon(
                                imageVector = Icons.Default.Place ,
                                contentDescription = ""
                            )
                            Text(text = "Nairobi")}
                        Row(horizontalArrangement = Arrangement.Absolute.Left){

                            Icon(
                                imageVector = Icons.Default.Star,
                                contentDescription = "Review",
                                tint = Color.Yellow
                            )


                            Text(text = "4.9")}
                        Row(horizontalArrangement = Arrangement.Absolute.Right){
                            Text(text = "$30/night")}
                    }
                }
            }
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(15.dp)
                    .border(shape = RoundedCornerShape(10.dp), width = 1.dp, color = Color.White)
                    .shadow(elevation = 10.dp)
                    .clickable {  navController.navigate(ROUTE_RADDISONBLU) { popUpTo(
                        ROUTE_HOME)}}
            )  {
                Row(horizontalArrangement = Arrangement.Absolute.Center, verticalAlignment = Alignment.CenterVertically,modifier = Modifier.background(
                    Color.White
                ).width(500.dp)) {
                    Image(painter = painterResource(id = R.drawable.img_4), contentDescription = "" , modifier = Modifier.size(70.dp))
                    Column (){
                        Row(horizontalArrangement = Arrangement.Absolute.Left){Text(text = "Raddison Blu")}
                        Row(horizontalArrangement = Arrangement.Absolute.Left){
                            Icon(
                                imageVector = Icons.Default.Place ,
                                contentDescription = ""
                            )
                            Text(text = "Nairobi")}
                        Row(horizontalArrangement = Arrangement.Absolute.Left){

                            Icon(
                                imageVector = Icons.Default.Star,
                                contentDescription = "Review",
                                tint = Color.Yellow
                            )


                            Text(text = "4.9")}
                        Row(horizontalArrangement = Arrangement.Absolute.Right){
                            Text(text = "$30/night")}
                    }
                }
            }
        }
    }


}

@Preview(showBackground = true)
@Composable
fun PreviewLight30() {
    PopularHotels(rememberNavController())
}

