package com.travelee.signing.components


import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Text
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import com.travelee.signing.ui.theme.TraveleeYellow
import com.travelee.signing.ui.theme.TraveleeYellow2
import com.travelee.signing.utilities.Constants.EMAIL_LABEL
import kotlinx.coroutines.job

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CustomField(
    name: TextFieldValue,
    onEmailValueChange: (newValue: TextFieldValue) -> Unit
) {
    val focusRequester = FocusRequester()

    OutlinedTextField(
        value = name,
        onValueChange = { newValue ->
            onEmailValueChange(newValue)
        },
        label = {
            Text(
                text = EMAIL_LABEL,
                color = TraveleeYellow2
            )
        },
        colors = TextFieldDefaults.outlinedTextFieldColors(
            disabledBorderColor = TraveleeYellow,
            focusedBorderColor = TraveleeYellow,
            unfocusedBorderColor = TraveleeYellow,
            errorBorderColor = Color.Red,
            cursorColor = TraveleeYellow
        ),
        singleLine = true,
        keyboardOptions = KeyboardOptions(
            keyboardType = KeyboardType.Email
        ),
        modifier = Modifier.focusRequester(focusRequester)
    )

    LaunchedEffect(Unit) {
        coroutineContext.job.invokeOnCompletion {
            focusRequester.requestFocus()
        }
    }
}