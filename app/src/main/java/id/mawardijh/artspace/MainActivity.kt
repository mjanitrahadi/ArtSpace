package id.mawardijh.artspace

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import id.mawardijh.artspace.ui.theme.ArtSpaceTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ArtSpaceTheme {
                ViewSepatu() // Menampilkan komponen ViewSepatu di dalam tema ArtSpaceTheme.
            }
        }
    }
}

data class Item(val imageRes: Int, val text: String)

@Composable
fun ViewSepatu() {
    val items = listOf(
        Item(R.drawable.sepatu1, "Air Jordan Red") // Daftar item sepatu dengan gambar dan teks.
    )

    var currentIndex by remember { mutableStateOf(0) }

    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.spacedBy(16.dp) // Mengatur jarak antar item dalam LazyColumn.
    ) {
        items(items) { item ->
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(25.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Image(
                    painter = painterResource(id = item.imageRes),
                    contentDescription = null,
                    modifier = Modifier
                        .size(350.dp)
                        .clip(shape = MaterialTheme.shapes.medium)
                        .background(MaterialTheme.colorScheme.primary)
                ) // Menampilkan gambar sepatu dengan beberapa modifikasi seperti ukuran dan latar belakang.

                Spacer(modifier = Modifier.height(16.dp)) // Menambahkan spasi vertical.

                Text(
                    text = item.text,
                    style = MaterialTheme.typography.bodyLarge,
                    modifier = Modifier.padding(top = 8.dp)
                ) // Menampilkan teks sepatu.

                Spacer(modifier = Modifier.height(16.dp)) // Menambahkan spasi vertical.

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Button(
                        onClick = {
                            currentIndex = (currentIndex - 1 + items.size) % items.size
                        },
                        modifier = Modifier.padding(8.dp)
                    ) {
                        Text("Previous")
                    } // Tombol untuk melihat item sepatu sebelumnya.

                    Button(
                        onClick = {
                            currentIndex = (currentIndex + 1) % items.size
                        },
                        modifier = Modifier.padding(8.dp)
                    ) {
                        Text("Next")
                    } // Tombol untuk melihat item sepatu berikutnya.
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ViewSepatuPreview() {
    ViewSepatu()
}
