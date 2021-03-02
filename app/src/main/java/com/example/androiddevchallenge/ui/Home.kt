/*
 * Copyright 2021 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.androiddevchallenge.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.androiddevchallenge.R
import com.example.androiddevchallenge.data.Dog
import com.example.androiddevchallenge.data.dogList
import com.example.androiddevchallenge.ui.theme.MyTheme
import com.example.androiddevchallenge.ui.theme.locationColor
import com.example.androiddevchallenge.ui.theme.mask
import com.example.androiddevchallenge.ui.theme.tag

@Composable
fun Home(dogs: List<Dog>, onClick: (Dog) -> Unit = {}) {
    Scaffold(
        topBar = {
            TopAppBar(
                backgroundColor = MaterialTheme.colors.primary,
                title = { Text("🐶 Puppy Adoption") },
                contentColor = MaterialTheme.colors.onPrimary
            )
        },
        content = {
            LazyColumn(
                Modifier.background(MaterialTheme.colors.background),
                contentPadding = PaddingValues(16.dp),
                verticalArrangement = Arrangement.spacedBy(20.dp)
            ) {
                items(dogs) { dog ->
                    val modifier = Modifier
                        .clip(RoundedCornerShape(8.dp))
                        .fillMaxWidth()
                        .clickable {
                            onClick(dog)
                        }
                    Card(modifier) {
                        Image(
                            painterResource(dog.picture),
                            "Picture of dog: ${dog.name}",
                            Modifier.size(180.dp),
                            contentScale = ContentScale.Crop
                        )
                        Surface(color = mask, modifier = Modifier.size(180.dp)) {
                            Column(Modifier.padding(top = 110.dp, start = 15.dp, end = 15.dp)) {
                                Row(verticalAlignment = Alignment.CenterVertically) {
                                    Text(
                                        dog.name,
                                        style = MaterialTheme.typography.h5,
                                        color = MaterialTheme.colors.onPrimary
                                    )
                                    Text(
                                        dog.age,
                                        style = MaterialTheme.typography.caption,
                                        color = MaterialTheme.colors.onPrimary,
                                        modifier = Modifier
                                            .background(
                                                color = tag,
                                                shape = RoundedCornerShape(percent = 50)
                                            )
                                            .size(40.dp, 20.dp),
                                        textAlign = TextAlign.Center
                                    )
                                }
                                Row(verticalAlignment = Alignment.CenterVertically) {
                                    Image(
                                        painterResource(id = R.drawable.ic_baseline_location_on_24),
                                        "Location of dog: ${dog.name}",
                                        Modifier.size(18.dp)
                                    )
                                    Text(dog.location, color = locationColor)
                                }
                            }
                        }
                    }
                }
            }
        }
    )
}

@Preview("Light Theme", widthDp = 360, heightDp = 640)
@Composable
fun LightPreviewForHome() {
    val dogs by mutableStateOf(dogList)
    MyTheme {
        Home(dogs)
    }
}

@Preview("Dark Theme", widthDp = 360, heightDp = 640)
@Composable
fun DarkPreviewForHome() {
    val dogs by mutableStateOf(dogList)
    MyTheme(darkTheme = true) {
        Home(dogs)
    }
}
