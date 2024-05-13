package net.ezra.ui.auth


import android.content.Intent
import android.widget.Toast
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.filled.MailOutline
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.google.firebase.auth.FirebaseAuth
import net.ezra.R
import net.ezra.navigation.ROUTE_LOGIN
import net.ezra.navigation.ROUTE_PROFILE
import net.ezra.navigation.ROUTE_SIGNUP


@Composable
fun SignUpScreen(navController: NavController, onSignUpSuccess: () -> Unit) {
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var confirmPassword by remember { mutableStateOf("") }
    var error by remember { mutableStateOf<String?>(null) }
    var isLoading by remember { mutableStateOf(false) }
    val context = LocalContext.current

LazyColumn(modifier=Modifier.fillMaxSize()) {
    item{
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {

            AuthHeader()

            Text("Sign Up",style = MaterialTheme.typography.h4, fontFamily = FontFamily.Cursive, fontStyle = FontStyle.Italic)
            Spacer(modifier = Modifier.height(16.dp))
            Button(
                colors = ButtonDefaults.buttonColors(Color(0xfff8c471)),
                shape = RoundedCornerShape(10.dp),
                onClick = {
                    if (email.isBlank()){
                        error = "Email is required"
                    } else if (password.isBlank()){
                        error = "Password is required"
                    } else if(confirmPassword.isBlank()) {
                        error = "Password Confirmation required"
                    } else if (password != confirmPassword) {
                        error = "Passwords do not match"
                    } else {
                        isLoading = true
                        signUp(email, password, {
                            isLoading = false
                            Toast.makeText(context, "Sign-up successful!", Toast.LENGTH_SHORT).show()
                            onSignUpSuccess()
                        }) { errorMessage ->
                            isLoading = false
                            error = errorMessage
                        }
                    }
                },
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("Signup   with  Phone")
                Spacer(modifier = Modifier.width(150.dp))
                Icon(imageVector = Icons.Default.Call , contentDescription = "")          }

            Spacer(modifier = Modifier.height(5.dp))
            androidx.compose.material3.OutlinedButton(
                onClick = {
                    if (email.isBlank()){
                        error = "Email is required"
                    } else if (password.isBlank()){
                        error = "Password is required"
                    } else if(confirmPassword.isBlank()) {
                        error = "Password Confirmation required"
                    } else if (password != confirmPassword) {
                        error = "Passwords do not match"
                    } else {
                        isLoading = true
                        signUp(email, password, {
                            isLoading = false
                            Toast.makeText(context, "Sign-up successful!", Toast.LENGTH_SHORT).show()
                            onSignUpSuccess()
                        }) { errorMessage ->
                            isLoading = false
                            error = errorMessage
                        }
                    }
                },
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(10.dp),
                border = BorderStroke(2.dp, color = Color(0xfff8c471))

            ) {
                Text("Signup   with   Google")
                Spacer(modifier = Modifier.width(150.dp))
                Image(painter = painterResource(id = R.drawable.img_23) , contentDescription = "",modifier=Modifier.size(25.dp))
            }

            Spacer(modifier = Modifier.height(16.dp))

            androidx.compose.material3.Text(
                text = "or ",
                textAlign = TextAlign.Center,
                color = androidx.compose.material3.MaterialTheme.colorScheme.onSurface
            )

            OutlinedTextField(
                value = email,
                onValueChange = { email = it },
                label = { Text("Email") },
                modifier = Modifier.fillMaxWidth(),
                leadingIcon =  { Icon(imageVector = Icons.Default.MailOutline, contentDescription = "")}
            )
            Spacer(modifier = Modifier.height(8.dp))


            OutlinedTextField(
                value = password,
                onValueChange = { password = it },
                label = { Text("Password") },
                visualTransformation = PasswordVisualTransformation(),
                modifier = Modifier.fillMaxWidth()
            )
            Spacer(modifier = Modifier.height(8.dp))

            OutlinedTextField(
                value = confirmPassword,
                onValueChange = { confirmPassword = it },
                label = { Text("Confirm Password") },
                visualTransformation = PasswordVisualTransformation(),
                modifier = Modifier.fillMaxWidth()
            )
            Spacer(modifier = Modifier.height(16.dp))

            if (isLoading) {
                CircularProgressIndicator(modifier = Modifier.size(48.dp))
            } else {


                Button(
                    shape = RoundedCornerShape(15.dp),
                    colors = ButtonDefaults.buttonColors(Color(0xfff8c471)),
                    onClick = {
                        if (email.isBlank()){
                            error = "Email is required"
                        } else if (password.isBlank()){
                            error = "Password is required"
                        } else if(confirmPassword.isBlank()) {
                            error = "Password Confirmation required"
                        } else if (password != confirmPassword) {
                            error = "Passwords do not match"
                        } else {
                            isLoading = true
                            signUp(email, password, {
                                isLoading = false
                                Toast.makeText(context, "Sign-up successful!", Toast.LENGTH_SHORT).show()
                                onSignUpSuccess()
                            }) { errorMessage ->
                                isLoading = false
                                error = errorMessage
                            }
                        }
                    },
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text("Signup")
                }
                Row(modifier = Modifier.fillMaxWidth()){
                    Text(text = "Already Have an account?",textAlign = TextAlign.Center)
                    androidx.compose.material3.Text(
                        modifier = Modifier

                            .clickable {
                                navController.navigate(ROUTE_LOGIN) {
                                    popUpTo(ROUTE_SIGNUP) { inclusive = true }
                                }
                            },
                        text = " Login",
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
private fun signUp(email: String, password: String, onSuccess: () -> Unit, onError: (String) -> Unit) {
    FirebaseAuth.getInstance().fetchSignInMethodsForEmail(email)
        .addOnCompleteListener { task ->
            if (task.isSuccessful) {
                val signInMethods = task.result?.signInMethods ?: emptyList()
                if (signInMethods.isNotEmpty()) {
                    onError("Email is already registered")
                } else {
                    // Email is not registered, proceed with sign-up
                    FirebaseAuth.getInstance().createUserWithEmailAndPassword(email, password)
                        .addOnCompleteListener { signUpTask ->
                            if (signUpTask.isSuccessful) {
                                onSuccess()
                            } else {
                                onError(signUpTask.exception?.message ?: "Sign-up failed")
                            }
                        }
                }
            } else {
                onError(task.exception?.message ?: "Failed to check email availability")
            }
        }
}