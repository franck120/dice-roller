package ci.pigier.diceroller

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateSetOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import ci.pigier.diceroller.ui.theme.DiceRollerTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
           DiceRollerTheme {
               Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
                   DiceRollerApp()
               }
           }
        }
    }
}

@Composable
fun DiceRollerApp() {
    DeviceWithButttonAndImage(modifier = Modifier.fillMaxSize().wrapContentSize(Alignment.Center))
}

@Composable
fun DeviceWithButttonAndImage(modifier: Modifier = Modifier) {
    var result by remember {  mutableStateSetOf(1) }
    val imageRessource = when (result) {
        1 -> R.drawable.dice_1
        2 -> R.drawable.dice_2
        3 -> R.drawable.dice_3
        4 -> R.drawable.dice_4
        5 -> R.drawable.dice_5
        else -> R.drawable.dice_6
    }
   Column(modifier = modifier,horizontalAlignment = Alignment.CenterHorizontally) {
       Image(painter =  painterResource(id = imageRessource), contentDescription = stringResource(R.string.dice_description,result),modifier = Modifier.size(160.dp))
       Spacer(modifier =  Modifier.Height(160.dp))
       Button(onClick =  {
           result = (1..6).random()
       }) {
           Text(text = stringResource(R.string.roll))
       }
   }
}


@Preview(showBackground = true, showSystemUi = true)
@Composbale
fun DiceRollerPreview () {
       DiceRollerTheme {
        Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
            DiceRollerApp()
        }
    }
}