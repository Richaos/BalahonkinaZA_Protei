package ru.protei.balahonkina

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import ru.protei.balahonkina.ui.theme.BalahonkinaTheme
import ru.protei.balahonkina.domain.Note

class MainActivity : ComponentActivity() {

    val noteList = listOf(
        Note("Андроид", "Время занятий: пятница 18:00"),
        Note("Пожелание дня", "Удачи!"),
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BalahonkinaTheme {
                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
                    NotesList(noteList)
                }
            }
        }
    }
}

@Composable
fun NotesList(noteList: List<Note>) {
    Column {
        for (note in noteList) {
            NoteItem(note)
        }
    }
}

@Composable
fun NoteItem(note: Note) {
    Text(
        text = note.title,
        style = MaterialTheme.typography.titleLarge
    )
    Text(text = note.text)
    Text(text = "")
}

@Preview(showBackground = true)
@Composable
fun NotesListPreview() {
    BalahonkinaTheme {
        NotesList(listOf(Note("Title 1", "Text 1"), Note("Title 2", "Text 2")))
    }
}