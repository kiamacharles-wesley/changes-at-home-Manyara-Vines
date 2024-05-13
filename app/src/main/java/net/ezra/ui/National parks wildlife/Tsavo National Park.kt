package net.ezra.ui.tsavo


import android.net.Uri
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.PickVisualMediaRequest
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import coil.compose.rememberAsyncImagePainter

import coil.request.ImageRequest
import com.google.firebase.Firebase
import com.google.firebase.firestore.firestore
import com.google.firebase.storage.FirebaseStorage
import net.ezra.R
import net.ezra.navigation.ROUTE_HOME
import net.ezra.navigation.ROUTE_MOUNTAINS
import net.ezra.navigation.ROUTE_SHOP
import java.util.UUID


@Composable
fun Tsavo(navController: NavHostController) {


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
                            .size(40.dp)
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
                            .size(40.dp)
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
                            .size(40.dp)
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
                            .size(40.dp)
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

            Row(){
                Text(text = "Description", fontWeight = FontWeight.ExtraBold, modifier = Modifier.size(15.dp))

            }
            Spacer(modifier = Modifier.height(5.dp))

            Row (){
Text(text = " Tsavo National Park, Kenya's largest protected area, is a wilderness sanctuary renowned for its diverse ecosystems and abundant wildlife. Divided into Tsavo East and Tsavo West, the park boasts vast savannas, volcanic landscapes, and meandering rivers, creating a haven for iconic African species such as elephants, lions, and giraffes. Visitors can embark on thrilling game drives, guided walks, or cultural tours, immersing themselves in the untamed beauty and raw wilderness of Tsavo.")            }
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



fun uploadImageToFirebaseStorage(imageUri: Uri, studentName: String, studentClass: String) {
    val storageRef = FirebaseStorage.getInstance().reference
    val imageRef = storageRef.child("images/${UUID.randomUUID()}")

    val uploadTask = imageRef.putFile(imageUri)
    uploadTask.continueWithTask { task ->
        if (!task.isSuccessful) {
            task.exception?.let {
                throw it
            }
        }
        imageRef.downloadUrl
    }.addOnCompleteListener { task ->
        if (task.isSuccessful) {
            val downloadUri = task.result
            saveToFirestore(downloadUri.toString(), studentName, studentClass)
        } else {


        }
    }
}

fun saveToFirestore(imageUrl: String, studentName: String, studentClass: String) {
    val db = Firebase.firestore
    val imageInfo = hashMapOf(
        "imageUrl" to imageUrl,
        "studentName" to studentName,
        "studentClass" to studentClass,


       
    )
    



    db.collection("Students")
        .add(imageInfo)
        .addOnSuccessListener {
          


        }
        .addOnFailureListener {
            // Handle error
        }
}







@Preview(showBackground = true)
@Composable
fun PreviewLight() {
    Tsavo(rememberNavController())
}




