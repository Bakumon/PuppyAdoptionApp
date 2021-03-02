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
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.FabPosition
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.androiddevchallenge.data.Dog
import com.example.androiddevchallenge.data.dogList
import com.example.androiddevchallenge.ui.theme.MyTheme
import com.example.androiddevchallenge.ui.theme.tag

@Composable
fun Detail(dog: Dog, onClick: (Dog) -> Unit = {}) {
    Scaffold(
        topBar = {
            TopAppBar(
                backgroundColor = MaterialTheme.colors.primary,
                title = { Text("🐶 Puppy Adoption") },
                contentColor = MaterialTheme.colors.onPrimary
            )
        },
        floatingActionButtonPosition = FabPosition.End,
        floatingActionButton = {
            FloatingActionButton(
                modifier = Modifier.padding(10.dp),
                onClick = {
                    onClick(dog)
                }
            ) {
                Text(text = "领养")
            }
        },
        content = {
            Column(
                modifier = Modifier.background(MaterialTheme.colors.background),
                verticalArrangement = Arrangement.spacedBy(10.dp)
            ) {
                Image(
                    painterResource(dog.picture),
                    "Picture of dog: ${dog.name}",
                    Modifier
                        .fillMaxWidth()
                        .height(240.dp),
                    contentScale = ContentScale.Crop
                )
                Column(
                    modifier = Modifier
                        .background(MaterialTheme.colors.background)
                        .padding(15.dp),
                    verticalArrangement = Arrangement.spacedBy(10.dp)
                ) {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Text(
                            dog.name,
                            style = MaterialTheme.typography.h5
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
                    Text("品种：" + dog.variety)
                    Text("性别：" + dog.gender)
                    Text("地址：" + dog.location)
                    Text("介绍：" + dog.introduction)
                }
            }
        }
    )
}

@Preview("Light Theme", widthDp = 360, heightDp = 640)
@Composable
fun LightPreviewForDetail() {
    MyTheme {
        Detail(dogList.first())
    }
}

@Preview("Dark Theme", widthDp = 360, heightDp = 640)
@Composable
fun DarkPreviewForDetail() {
    MyTheme(darkTheme = true) {
        Detail(dogList.first())
    }
}
