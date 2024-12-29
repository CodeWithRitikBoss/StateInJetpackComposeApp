package com.ritikcoder.stateinjetpackcomposeapp

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp

//@Preview(showBackground = true)
@Composable
fun StateTestScreen(viewModel: StateTextViewModel){
    val name by viewModel.name.observeAsState(initial = "")
    val surName by viewModel.surName.observeAsState(initial = "")
//    var name by rememberSaveable() {
//        mutableStateOf("")
//    }
    Column (
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        MyText("$name $surName")
        MyTextField(name, "first", onNameChange = {
            viewModel.onNameUpdate(it)
        })
        MyTextField(surName, "last", onNameChange = {
            viewModel.onSurNameUpdate(it)
        })
    }
}

@Composable
fun MyText(name: String){
    Text(text = "Hello $name", style = TextStyle(fontSize = 30.sp))
}

@Composable
fun MyTextField(name: String, n: String, onNameChange: (String)-> Unit){

    OutlinedTextField(
        value = name,
        onValueChange = {
            onNameChange(it)
        },
        label = {Text(text = "Enter $n name")}
    )
}