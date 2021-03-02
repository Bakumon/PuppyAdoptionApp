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
package com.example.androiddevchallenge

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import com.example.androiddevchallenge.data.Dog
import com.example.androiddevchallenge.ui.Detail
import com.example.androiddevchallenge.ui.theme.MyTheme

class DetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val dog: Dog = intent.getSerializableExtra(KEY_DOG) as Dog
        setContent {
            MyTheme {
                Detail(dog) {
                    Toast.makeText(this, "领养了${dog.name}", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }

    companion object {
        private const val KEY_DOG = "KEY_DOG"
        fun open(context: Context, dog: Dog) {
            val intent = Intent(context, DetailActivity::class.java)
            intent.putExtra(KEY_DOG, dog)
            context.startActivity(intent)
        }
    }
}
