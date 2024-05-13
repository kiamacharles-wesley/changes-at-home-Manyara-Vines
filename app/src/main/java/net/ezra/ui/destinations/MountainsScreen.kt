package net.ezra.ui.destinations


import android.graphics.drawable.Icon
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.LazyHorizontalGrid
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
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
import androidx.compose.material3.SegmentedButtonDefaults.Icon
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.TopEnd
import androidx.compose.ui.semantics.Role.Companion.Button
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.sp
import net.ezra.navigation.ROUTE_HOME
import net.ezra.navigation.ROUTE_MOUNTAINS
import net.ezra.navigation.ROUTE_SHOP


@Composable
fun MountainsScreen(navController: NavHostController) {

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
                        .size(40.dp)
                        .clickable { navController.navigate(ROUTE_HOME) { popUpTo(ROUTE_MOUNTAINS) } }){
                        Image(painter = painterResource(id = R.drawable.img_14), contentDescription = "", modifier = Modifier.fillMaxSize(), contentScale = ContentScale.Crop)
                    }
                    Text(text = "Guides",fontWeight = FontWeight.ExtraBold)
                }
                Spacer(modifier = Modifier.width(15.dp))
                Column (verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally){
                    Card (shape = CircleShape, modifier = Modifier
                        .size(40.dp)
                        .clickable { navController.navigate(ROUTE_HOME) { popUpTo(ROUTE_MOUNTAINS) } }){
                        Image(painter = painterResource(id = R.drawable.img_14), contentDescription = "", modifier = Modifier.fillMaxSize(), contentScale = ContentScale.Crop)
                    }
                    Text(text = "Map",fontWeight = FontWeight.ExtraBold)
                }
                Spacer(modifier = Modifier.width(15.dp))
                Column (verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally){
                    Card (shape = CircleShape, modifier = Modifier
                        .size(40.dp)
                        .clickable { navController.navigate(ROUTE_HOME) { popUpTo(ROUTE_MOUNTAINS) } }){
                        Image(painter = painterResource(id = R.drawable.img_14), contentDescription = "", modifier = Modifier.fillMaxSize(), contentScale = ContentScale.Crop)
                    }
                    Text(text = "Transport",fontWeight = FontWeight.ExtraBold)
                }
                Spacer(modifier = Modifier.width(15.dp))
                Column (verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally){
                    Card (shape = CircleShape, modifier = Modifier
                        .size(40.dp)
                        .clickable { navController.navigate(ROUTE_HOME) { popUpTo(ROUTE_MOUNTAINS) } }){
                        Image(painter = painterResource(id = R.drawable.img_14), contentDescription = "", modifier = Modifier.fillMaxSize(), contentScale = ContentScale.Crop)
                    }
                    Text(text = "Vasco da Gama",fontWeight = FontWeight.ExtraBold)
                }
                Spacer(modifier = Modifier.width(15.dp))
                Column (verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally){
                    Card (shape = CircleShape, modifier = Modifier
                        .size(40.dp)
                        .clickable { navController.navigate(ROUTE_HOME) { popUpTo(ROUTE_MOUNTAINS) } }){
                        Image(painter = painterResource(id = R.drawable.img_14), contentDescription = "", modifier = Modifier.fillMaxSize(), contentScale = ContentScale.Crop)
                    }
                    Text(text = "Reviews",fontWeight = FontWeight.ExtraBold)
                }


            }

        }

        Spacer(modifier = Modifier.height(15.dp))

        Row(){
            Text(text = "Description", fontWeight = FontWeight.ExtraBold, modifier = Modifier.size(15.dp))

        }
        Spacer(modifier = Modifier.height(5.dp))

        Row (){
            Text(text = " Sdf  sd gf g sf gsdfgdfg.sdffffffff fsdddddddd sdffffffffffff sfddddddddd sfddddddd sfd sdf sdf sdfsdf sdf sdf sdf sdf sdf sdf sdfsdf sdf sdf sdfdfs sdfffffffffffff. sdf  sd gf g sf gsdfgdfg.sdffffffff fsdddddddd sdffffffffffff sfddddddddd  sdfdfs sdfffffffffffff. sdf  sd gf g sf gsdfgdfg.sdffffffff fsdddddddd sdffffffffffff sfddddddddd sfddddddd sfd sdf sdf sdfsdf sdf sdf sdf sdf sdf sdf sdfsdf sdf sdf sdfdfs sdfffffffffffff. sdf  sd gf g sf gsdfgdfg.sdffffffff fsdddddddd sdffffffffffff sfddddddddd sfddddddd sfd sdf sdf sdfsdf sdf sdf sdf sdf sdf sdf sdfsdf sdf sdf sdfdfs sdfffffffffffff. sdf  sd gf g sf gsdfgdfg.sdffffffff fsdddddddd sdffffffffffff sfddddddddd sfddddddd sfd sdf sdf sdfsdf sdf sdf sdf sdf sdf sdf sdfsdf sdf sdf sdfdfs sdfffffffffffff. sdf  sd gf g sf gsdfgdfg.sdffffffff fsdddddddd sdffffffffffff sfddddddddd sfddddddd sfd sdf sdf sdfsdf sdf sdf sdf sdf sdf sdf sdfsdf sdf sdf sdfdfs sdfffffffffffff. sdf  sd gf g sf gsdfgdfg.sdffffffff fsdddddddd sdffffffffffff sfddddddddd sfddddddd sfd sdf sdf sdfsdf sdf sdf sdf sdf sdf sdf sdfsdf sdf sdf sdfdfs sdfffffffffffff. sdf  sd gf g sf gsdfgdfg.sdffffffff fsdddddddd sdffffffffffff sfddddddddd sfddddddd sfd sdf sdf sdfsdf sdf sdf sdf sdf sdf sdf sdfsdf sdf sdf sdfdfs sdfffffffffffff. sdf  sd gf g sf gsdfgdfg.sdffffffff fsdddddddd sdf  sdf  sd gf g sf gsdfgdfg.")
        }
        Row( horizontalArrangement = Arrangement.Absolute.SpaceEvenly, verticalAlignment = Alignment.Bottom){

            Button(
                onClick = {
                    navController.navigate(ROUTE_HOME) { popUpTo(ROUTE_SHOP) }    },
colors = ButtonDefaults.buttonColors(Color.Black)

            ) {
                Text(text = "Book Now", color = Color.White)
            }
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


@Preview(showBackground = true)
@Composable
fun PreviewLight4() {
    MountainsScreen(rememberNavController())
}

