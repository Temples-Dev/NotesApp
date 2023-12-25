package com.temples_dev.notes_app.presentation

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Check
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController

@Composable
fun AddNoteScreen(
    state: NoteState, navController: NavHostController, onEvent: (NotesEvent) -> Unit
) {

    Scaffold(floatingActionButton = {
        FloatingActionButton(onClick = {
            onEvent(
                NotesEvent.SaveNote(
                    title = state.title.value, description = state.description.value
                )
            )

            navController.popBackStack()
        }) {

            Icon(imageVector = Icons.Rounded.Check, contentDescription = "Save Note")

        }
    }) { paddingValues ->

        Column(
            modifier = Modifier
                .padding(paddingValues)
                .fillMaxSize()
        ) {

            TextField(modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
                value = state.title.value,
                onValueChange = {
                    state.title.value = it
                },
                textStyle = TextStyle(
                    fontWeight = FontWeight.SemiBold,
                    fontSize = 17.sp
                ), placeholder = { Text("title") }
            )

            TextField(modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
                value = state.description.value,
                onValueChange = {
                    state.description.value = it
                },
                textStyle = TextStyle(
                    fontWeight = FontWeight.Light,
                    fontSize = 17.sp
                ), placeholder = { Text("description") }
            )


        }


    }

}