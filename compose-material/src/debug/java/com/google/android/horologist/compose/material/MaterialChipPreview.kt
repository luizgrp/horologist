/*
 * Copyright 2023 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.google.android.horologist.compose.material

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Image
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.wear.compose.material.Chip
import androidx.wear.compose.material.ChipDefaults
import androidx.wear.compose.material.Text
import com.google.android.horologist.compose.material.util.DECORATIVE_ELEMENT_CONTENT_DESCRIPTION

class MaterialChipPreview {

    @Preview(
        backgroundColor = 0xff000000,
        showBackground = true
    )
    @Composable
    fun PrimaryChip() {
        Column {
            Chip(
                label = { Text("Enabled chip") },
                onClick = { },
                icon = {
                    androidx.wear.compose.material.Icon(
                        imageVector = Icons.Default.Image,
                        contentDescription = DECORATIVE_ELEMENT_CONTENT_DESCRIPTION,
                        modifier = Modifier
                            .size(ChipDefaults.IconSize)
                            .clip(CircleShape)
                    )
                },
            )

            Spacer(Modifier.height(16.dp))

            Chip(
                label = { Text("Disabled chip") },
                onClick = { },
                icon = {
                    androidx.wear.compose.material.Icon(
                        imageVector = Icons.Default.Image,
                        contentDescription = DECORATIVE_ELEMENT_CONTENT_DESCRIPTION,
                        modifier = Modifier
                            .size(ChipDefaults.IconSize)
                            .clip(CircleShape)
                    )
                },
                enabled = false
            )
        }
    }

    @Preview(
        backgroundColor = 0xff000000,
        showBackground = true
    )
    @Composable
    fun SecondaryChip() {
        Column {
            Chip(
                label = { Text("Enabled chip") },
                onClick = { },
                icon = {
                    androidx.wear.compose.material.Icon(
                        imageVector = Icons.Default.Image,
                        contentDescription = DECORATIVE_ELEMENT_CONTENT_DESCRIPTION,
                        modifier = Modifier
                            .size(ChipDefaults.IconSize)
                            .clip(CircleShape)
                    )
                },
                colors = ChipDefaults.secondaryChipColors()
            )

            Spacer(Modifier.height(16.dp))

            Chip(
                label = { Text("Disabled chip") },
                onClick = { },
                icon = {
                    androidx.wear.compose.material.Icon(
                        imageVector = Icons.Default.Image,
                        contentDescription = DECORATIVE_ELEMENT_CONTENT_DESCRIPTION,
                        modifier = Modifier
                            .size(ChipDefaults.IconSize)
                            .clip(CircleShape)
                    )
                },
                colors = ChipDefaults.secondaryChipColors(),
                enabled = false
            )
        }
    }
}