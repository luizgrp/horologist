/*
 * Copyright 2022 The Android Open Source Project
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

package androidx.wear.compose.material

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import com.google.android.horologist.compose.layout.StateUtils.rememberStateWithLifecycle
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import org.junit.Rule
import org.junit.Test

class PickerTest {
    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun testOriginalFunction() {
        val viewModel = MyViewModel()

        composeTestRule.setContent {
            MyComposable(viewModel)
        }

        viewModel._selectedOption.value = 2

        composeTestRule.onNodeWithText("2").assertExists()
    }

    class MyViewModel {
        val _selectedOption = MutableStateFlow(1)
        val selectedOption: StateFlow<Int> = _selectedOption
    }

    @Composable
    fun MyComposable(viewModel: MyViewModel) {
        val selectedOption by rememberStateWithLifecycle(viewModel.selectedOption)

        val pickerState = rememberPickerState(
            initialNumberOfOptions = 24,
            initiallySelectedOption = selectedOption
        )

        Text(text = "${pickerState.selectedOption}")
    }

    @Test
    fun testFunctionWithFix() {
        val viewModel = MyViewModel()

        composeTestRule.setContent {
            MyComposableFixed(viewModel)
        }

        viewModel._selectedOption.value = 2

        composeTestRule.onNodeWithText("2").assertExists()
    }

    @Composable
    fun MyComposableFixed(viewModel: MyViewModel) {
        val selectedOption by rememberStateWithLifecycle(viewModel.selectedOption)

        val pickerState = rememberPickerStateFixed(
            initialNumberOfOptions = 24,
            initiallySelectedOption = selectedOption
        )

        Text(text = "${pickerState.selectedOption}")
    }

    @Composable
    public fun rememberPickerStateFixed(
        initialNumberOfOptions: Int,
        initiallySelectedOption: Int = 0,
        repeatItems: Boolean = true
    ): PickerState = rememberSaveable(
        initialNumberOfOptions,
        initiallySelectedOption,
        repeatItems,
        saver = PickerState.Saver
    ) {
        PickerState(initialNumberOfOptions, initiallySelectedOption, repeatItems)
    }
}