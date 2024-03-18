package com.stu71930.lab1_71930

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.stu71930.lab1_71930.ui.theme.Lab1_71930Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Lab1_71930Theme {
                // remove the two slashes that are ahead of the functions to call each page

                //gLogin(LightGrey, WelcomeBack, Login)
                //bLogin(Black, WelcomeBack, Login)
                //gSignUp(LightGrey, CreateAccount, SignUp)
                bSignUp(Black, CreateAccount, SignUp)
            }
        }
    }
}

//Defining four constants that represent the colours => Light Grey, White, Black and Light Black
val LightGrey = Color(android.graphics.Color.parseColor("#e5e5e5"))
val White = Color(android.graphics.Color.parseColor("#ffffff"))
val Black = Color(android.graphics.Color.parseColor("#000000"))
val LightBlack = Color(android.graphics.Color.parseColor("#5c5c5c"))
const val WelcomeBack = "Welcome back you've been missed"
const val CreateAccount = "Let's create an account for you"
const val Login = "Login"
const val SignUp = "Sign Up"

@Composable
fun gLogin(backGroundColour: Color, welcomeBack: String, login: String){
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = backGroundColour
    ){
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceAround,
            modifier = Modifier.padding(35.dp)
        ) {
            mySpacer()
            Logo()
            LoginInput(LightGrey, welcomeBack)
            LoginButton(White, Black, login)
            ContinueWith(LightBlack)

        }
    }
}

@Composable
fun bLogin(backgroundColour: Color, welcomeBack: String, login: String){
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = backgroundColour)
    {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceAround,
            modifier = Modifier
                .padding(36.dp)

        ) {
            mySpacer()
            Logo()
            LoginInput(White , welcomeBack)
            LoginButton(LightBlack, White, login)
            ContinueWith(LightBlack)

        }

    }

}

@Composable
fun gSignUp(backGroundColour: Color, createAccount: String, signUp: String){
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = backGroundColour
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceAround,
            modifier = Modifier.padding(36.dp)
        ) {
            mySpacer()
            Logo()
            SignInput(LightBlack, CreateAccount)
            LoginButton(LightBlack, LightGrey, SignUp)
            notAMember(LightBlack)

        }
    }
}


@Composable
fun bSignUp(backgroundColour: Color, createAccount: String, signUp: String){
    Surface(
        modifier = Modifier
            .fillMaxSize(),
        color = backgroundColour)
    {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceAround,
            modifier = Modifier
                .padding(36.dp)

        ) {
            mySpacer()
            Logo()
            SignInput( LightGrey, createAccount)
            LoginButton(LightBlack, White, signUp)
            notAMember(LightGrey)

        }

    }

}

@Composable
fun mySpacer(){
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .size(50.dp)
    )
}
@Composable
fun notAMember(fontColor: Color){

    Row {
        Text(
            text = "Already a member? ",
            color = fontColor
        )
        Text(
            text = "Login now",
            color = fontColor,
            fontWeight = FontWeight.Bold
        )
    }
}

@Composable
fun ContinueWith(fontColor: Color){
    Text(
        text = "Or Continue with",
        color = fontColor)
    Row(
        modifier = Modifier
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.Center
    ) {
        val googleLogo = painterResource(id = R.drawable.google)
        val appleLogo = painterResource(id = R.drawable.apple)


        Image(
            modifier = Modifier
                .size(60.dp)
                .padding(end = 20.dp),
            painter = googleLogo, contentDescription = "Google logo")

        Image(
            modifier = Modifier
                .size(60.dp)
                .padding(start = 20.dp),
            painter = appleLogo, contentDescription = "Apple Logo")

    }
    Row {
        Text(
            text = "Not a member? ",
            color = fontColor
        )
        Text(
            text = "Register now",
            color = fontColor,
            fontWeight = FontWeight.Bold
        )
    }
}

@Composable
fun LoginButton(backgroundColour: Color, fontColor: Color, login: String) {

    Button(
        onClick = {},
        colors = ButtonDefaults.buttonColors(backgroundColour),
        modifier = Modifier
            .fillMaxWidth()
            .size(50.dp),
        shape = RectangleShape,
    ) {
        Text(text = login, color = fontColor)
    }

}



@Composable
fun Logo(){
    val logo = painterResource(id = R.drawable.lock)
    Image(
        modifier = Modifier.size(100.dp),
        painter = logo, contentDescription = "App's logo"
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LoginInput(fontColor: Color, welcomeBack: String){
    val username = remember { mutableStateOf("") }
    val password = remember { mutableStateOf("") }

    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Text(
            text = welcomeBack,
            color = LightBlack,
            modifier = Modifier
                .padding(bottom = 20.dp)
        )

        TextField(
            value = username.value,
            onValueChange = { username.value = it },
            label = { Text("Username") },

            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 8.dp),

            colors = TextFieldDefaults.textFieldColors(
                containerColor = Color.LightGray,
                cursorColor = Color.Black,
            )
        )

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .size(5.dp)
        )

        TextField(
            value = password.value,
            onValueChange = { password.value = it },
            label = { Text("Password") },
            modifier = Modifier
                .fillMaxWidth(),

            colors = TextFieldDefaults.textFieldColors(
                    containerColor = Color.LightGray,
                 cursorColor = Color.Black
            )

        )

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .size(5.dp)
        )

        Text(
            text = "Forgot Password?",
            color = LightBlack,
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 8.dp),
            textAlign = TextAlign.End)

    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SignInput(fontColor: Color, welcomeBack: String){
    val email = remember { mutableStateOf("") }
    val password = remember { mutableStateOf("") }
    val confirmPassword = remember { mutableStateOf("") }

    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Text(
            text = welcomeBack,
            color = fontColor,
            modifier = Modifier
                .padding(bottom = 20.dp)
        )

        TextField(
            value = email.value,
            onValueChange = { email.value = it },
            label = { Text("Email") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 8.dp),
            colors = TextFieldDefaults.textFieldColors(
                containerColor = Color.LightGray,
                cursorColor = Color.Black,
            )
        )

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .size(5.dp)
        )

        TextField(
            value = password.value,
            onValueChange = { password.value = it },
            label = { Text("Password") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 8.dp),
            colors = TextFieldDefaults.textFieldColors(
                containerColor = Color.LightGray,
                cursorColor = Color.Black,
            )

        )

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .size(5.dp)
        )

        TextField(
            value = confirmPassword.value,
            onValueChange = { confirmPassword.value = it },
            label = { Text("Confirm Password") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 10.dp),
            colors = TextFieldDefaults.textFieldColors(
                containerColor = Color.LightGray,
                cursorColor = Color.Black,
            )

        )
    }
}




