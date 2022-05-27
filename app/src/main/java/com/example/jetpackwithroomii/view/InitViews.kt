package com.example.jetpackwithroomii.view

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.text.isDigitsOnly
import com.example.jetpackwithroomii.ui.theme.Purple500
import com.example.jetpackwithroomii.utils.ObjectLists
import com.example.jetpackwithroomii.viewmodel.UserViewModel
import kotlinx.coroutines.launch

@Composable
fun InitViews(viewModel: UserViewModel) {
    val scope = rememberCoroutineScope()
    viewModel.addLibrary(ObjectLists.libraryList())
    viewModel.addUser(ObjectLists.userList())

    val getUserRecord = viewModel.readAllData.observeAsState(listOf()).value
    val userId = remember { mutableStateOf("") }

    Scaffold {
        Column(
            modifier = Modifier.fillMaxSize()
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color.White)
                    .padding(15.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Text(
                    text = "Room Database with tables",
                    color = Color.White,
                    fontWeight = FontWeight.Bold,
                    fontSize = 18.sp
                )
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(15.dp),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ) {
                    OutlinedTextField(
                        value = userId.value,
                        onValueChange = {
                            if (it.isNotEmpty()) {
                                userId.value = it
                            }
                        },
                        label = {
                            Text(text = "Enter user Id")
                        },
                        singleLine = true,
                        modifier = Modifier.fillMaxWidth(0.8f)
                    )
                    Spacer(modifier = Modifier.height(25.dp))

                    Button(
                        onClick = {
                            scope.launch {
                                if (userId.value.isDigitsOnly()) {
                                    viewModel.getUser(userId.value.toInt())
                                }
                            }
                        },
                        modifier = Modifier
                            .fillMaxWidth(0.5f)
                            .height(60.dp)
                            .padding(10.dp),
                        shape = RoundedCornerShape(5.dp),
                        colors = ButtonDefaults.buttonColors(Purple500)
                    ) {
                        Text(
                            text = "Submit",
                            color = Color.White,
                            fontSize = 20.sp,
                            fontWeight = FontWeight.Bold
                        )
                    }
                    Spacer(modifier = Modifier.height(50.dp))

                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .background(Purple500)
                            .padding(15.dp)
                    ) {
                        Text(
                            text = "User Id",
                            modifier = Modifier.weight(0.3f),
                            color = Color.White,
                            fontWeight = FontWeight.Bold
                        )
                        Text(
                            text = "Name",
                            modifier = Modifier.weight(0.3f),
                            color = Color.White,
                            fontWeight = FontWeight.Bold
                        )
                        Text(
                            text = "Age",
                            modifier = Modifier.weight(0.3f),
                            color = Color.White,
                            fontWeight = FontWeight.Bold
                        )
                    }
                    if (getUserRecord!!.isNotEmpty()) {
                        LazyColumn {
                            items(getUserRecord.size) { index ->
                                UserDataList(getUserRecord[index])
                            }
                            item {
                                Spacer(modifier = Modifier.height(30.dp))

                                Row(
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .background(Purple500)
                                        .padding(15.dp)
                                ) {
                                    Text(
                                        text = "Library Id",
                                        modifier = Modifier.weight(0.3f),
                                        color = Color.White,
                                        fontWeight = FontWeight.Bold
                                    )
                                    Text(
                                        text = "Name",
                                        modifier = Modifier.weight(0.3f),
                                        color = Color.White,
                                        fontWeight = FontWeight.Bold
                                    )
                                }
                            }
                            items(getUserRecord[0].library.size) { index ->
                                LibraryList(getUserRecord[0].library[index])
                            }
                        }
                    }
                }
            }
        }
    }
}