package net.ezra.ui.auth


import android.content.res.Configuration.UI_MODE_NIGHT_NO
import android.widget.Toast
import androidx.activity.compose.BackHandler
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.MailOutline
import androidx.compose.material.icons.filled.Person
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.google.firebase.auth.FirebaseAuth
import net.ezra.R
import net.ezra.navigation.ROUTE_LOGIN
import net.ezra.navigation.ROUTE_PROFILE
import net.ezra.navigation.ROUTE_SIGNUP

@Composable
fun PhoneLoginScreen(navController: NavController) {
    var phoneAuthOptions by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var error by remember { mutableStateOf<String?>(null) }
    var isLoading by remember { mutableStateOf(false) }

    BackHandler {
        navController.popBackStack()

    }
LazyColumn (modifier=Modifier.fillMaxSize()){
    item{

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {

            AuthHeader()
            Text("Login", style = MaterialTheme.typography.h4, fontFamily = FontFamily.Cursive, fontStyle = FontStyle.Italic)
            Spacer(modifier = Modifier.height(16.dp))
            Button(
                shape = RoundedCornerShape(10.dp),
                colors = ButtonDefaults.buttonColors(Color(0xfff8c471)),

                onClick = {
                    if (phoneAuthOptions.isBlank() || password.isBlank()) {
                        error = "Please fill in all fields"
                    } else {
                        isLoading = true
                        FirebaseAuth.getInstance().signInWithEmailAndPassword(phoneAuthOptions, password)
                            .addOnCompleteListener { task ->
                                isLoading = false
                                if (task.isSuccessful) {
                                    navController.navigate(ROUTE_PROFILE)
                                } else {
                                    error = task.exception?.message ?: "Login failed"
                                }
                            }
                    }
                },
                modifier = Modifier.fillMaxWidth()
            )  {
                Text("Login   with   Phone", fontWeight = FontWeight.ExtraBold)
                Spacer(modifier = Modifier.width(150.dp))
                Icon(imageVector = Icons.Default.Call , contentDescription = "")
            }
            Spacer(modifier = Modifier.height(5.dp))

            androidx.compose.material3.OutlinedButton(
                onClick = {
                    if (phoneAuthOptions.isBlank() || password.isBlank()) {
                        error = "Please fill in all fields"
                    } else {
                        isLoading = true
                        FirebaseAuth.getInstance().signInWithEmailAndPassword(phoneAuthOptions, password)
                            .addOnCompleteListener { task ->
                                isLoading = false
                                if (task.isSuccessful) {
                                    navController.navigate(ROUTE_PROFILE)
                                } else {
                                    error = task.exception?.message ?: "Login failed"
                                }
                            }
                    }
                },
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(10.dp),
                border = BorderStroke(2.dp, color = Color(0xfff8c471))

            ) {
                Text("Login   with   Google", fontWeight = FontWeight.ExtraBold)
                Spacer(modifier = Modifier.width(150.dp))
                Image(painter = painterResource(id = R.drawable.img_23) , contentDescription = "",modifier=Modifier.size(30.dp) )
            }
            Spacer(modifier = Modifier.height(16.dp))

            androidx.compose.material3.Text(
                text = "or ",
                textAlign = TextAlign.Center,
                color = androidx.compose.material3.MaterialTheme.colorScheme.onSurface
            )

            OutlinedTextField(
                value = phoneAuthOptions,
                onValueChange = { phoneAuthOptions = it },
                label = { Text("Email") },
                modifier = Modifier.fillMaxWidth(),
                leadingIcon =  { Icon(imageVector =Icons.Default.MailOutline, contentDescription = "")}
            )
            Spacer(modifier = Modifier.height(8.dp))


            OutlinedTextField(
                value = password,
                onValueChange = { password = it },
                label = { Text("Password") },
                visualTransformation = PasswordVisualTransformation(),
                modifier = Modifier.fillMaxWidth(),)
            Spacer(modifier = Modifier.height(16.dp))

            if (isLoading) {
                CircularProgressIndicator(modifier = Modifier.size(48.dp))
            } else {


                Button(
                    shape = RoundedCornerShape(25.dp),
                    colors = ButtonDefaults.buttonColors(Color(0xfff8c471)),
                    onClick = {
                        if (phoneAuthOptions.isBlank() || password.isBlank()) {
                            error = "Please fill in all fields"
                        } else {
                            isLoading = true
                            FirebaseAuth.getInstance().signInWithEmailAndPassword(phoneAuthOptions, password)
                                .addOnCompleteListener { task ->
                                    isLoading = false
                                    if (task.isSuccessful) {
                                        navController.navigate(ROUTE_PROFILE)
                                    } else {
                                        error = task.exception?.message ?: "Login failed"
                                    }
                                }
                        }
                    },
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text("Login")
                }

                Row(modifier = Modifier.fillMaxWidth()){
                    Text(text = "Don't Have an account?",textAlign = TextAlign.Center)
                    androidx.compose.material3.Text(
                        modifier = Modifier

                            .clickable {
                                navController.navigate(ROUTE_SIGNUP) {
                                    popUpTo(ROUTE_LOGIN) { inclusive = true }
                                }
                            },
                        text = " Signup",
                        textAlign = TextAlign.Center,
                        color = androidx.compose.material3.MaterialTheme.colorScheme.onSurface
                    )

                }


            }

            error?.let {
                Text(
                    text = it,
                    color = MaterialTheme.colors.error,
                    modifier = Modifier.padding(top = 8.dp)
                )
            }
        }


    }
}

}
@Composable
@Preview(showBackground = true, uiMode = UI_MODE_NIGHT_NO)
fun PhoneLoginScreenPreviewLight() {
    PhoneLoginScreen(rememberNavController())
}

