package com.shindze.wbschoolproject.presentation.view.auth.profile

import android.net.Uri
import androidx.activity.compose.ManagedActivityResultLauncher
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.PickVisualMediaRequest
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.shindze.wbschoolproject.R
import com.shindze.wbschoolproject.molecules.ProfileAvatarChange
import com.shindze.wbschoolproject.presentation.components.CustomTextField
import com.shindze.wbschoolproject.presentation.components.FilledButtonExample
import com.shindze.wbschoolproject.presentation.viewmodel.auth.profile.ProfileCreateViewModel
import com.shindze.wbschoolproject.ui.theme.SubheadingOne
import com.shindze.wbschoolproject.ui.theme.WBFontFamily
import com.shindze.wbschoolproject.ui.theme.active
import com.shindze.wbschoolproject.ui.theme.default
import com.shindze.wbschoolproject.ui.theme.defaultOpacity
import com.shindze.wbschoolproject.ui.theme.offWhite
import com.shindze.wbschoolproject.ui.theme.white

@OptIn(ExperimentalMaterial3Api::class)
@Composable
internal fun ProfileSetupScreen(
    viewModel: ProfileCreateViewModel, onNavigateBack: () -> Unit, onNavigateNext: () -> Unit
) {
    Scaffold(containerColor = white, topBar = {
        TopAppBar(colors = TopAppBarDefaults.topAppBarColors(
            containerColor = white,
            titleContentColor = active,
        ), title = {
            Text(
                stringResource(id = R.string.ProfileScreenLabel),
                fontFamily = WBFontFamily,
                style = SubheadingOne
            )
        }, navigationIcon = {
            IconButton(onClick = onNavigateBack) {
                Icon(
                    imageVector = Icons.AutoMirrored.Filled.ArrowBack, contentDescription = null
                )
            }
        })
    }) { paddingValues ->
        ProfileSetupScreenBuilder(
            Modifier.padding(paddingValues), viewModel, onNavigateNext = onNavigateNext
        )
    }
}

@Composable
internal fun ProfileSetupScreenBuilder(
    modifier: Modifier, viewModel: ProfileCreateViewModel, onNavigateNext: () -> Unit

) {
    var firstName by rememberSaveable {
        mutableStateOf("")
    }
    var lastName by rememberSaveable {
        mutableStateOf("")
    }
    val state by viewModel.getProfileState().collectAsState()

    val photoPicker = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.PickVisualMedia(),
        onResult = { uri ->
            if (uri != null) {
                viewModel.setProfileImage(uri.toString())
            }
        })

    LazyColumn(
        modifier = modifier
            .fillMaxSize()
            .padding(24.dp),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        item {
            Spacer(modifier = Modifier.height(48.dp))
            ProfileAvatarChange(
                backgroundSize = 100,
                model = state.profileImage,
                onClick = { getImageFromLibrary(photoPicker) },
            )
        }
        item {
            Spacer(modifier = Modifier.height(32.dp))
            Column(verticalArrangement = Arrangement.spacedBy(12.dp)) {
                CustomTextField(
                    text = firstName,
                    onTextChanged = { newText ->
                        firstName = newText
                    },
                    supportText = stringResource(R.string.TextFieldProfileNameSupportText),
                    modifier = Modifier
                        .clip(RoundedCornerShape(8.dp))
                        .background(offWhite)
                        .height(40.dp)
                        .padding(vertical = 4.dp, horizontal = 8.dp)

                )
                CustomTextField(
                    text = lastName,
                    onTextChanged = { newText ->
                        lastName = newText
                    },
                    supportText = stringResource(R.string.TextFieldProfileSecondNameSupportText),
                    modifier = Modifier
                        .clip(RoundedCornerShape(8.dp))
                        .background(offWhite)
                        .height(40.dp)
                        .padding(vertical = 4.dp, horizontal = 8.dp)
                )
            }
        }
        item {
            Spacer(modifier = Modifier.height(56.dp))
            FilledButtonExample(
                onClick = {
                    onNavigateNext()
                    viewModel.setProfileData(
                        firstName = firstName,
                        lastName = lastName,
                        profileImage = state.profileImage
                    )
                },
                elevateButtonColors = ButtonDefaults.elevatedButtonColors(
                    contentColor = white,
                    containerColor = default,
                    disabledContainerColor = defaultOpacity,
                    disabledContentColor = white
                ),
                isEnable = (firstName.isNotEmpty()),
                buttonText = stringResource(R.string.SaveButtonName),
                modifier = Modifier
                    .fillMaxWidth()
                    .height(48.dp)
            )
        }
    }
}

fun getImageFromLibrary(photoPicker: ManagedActivityResultLauncher<PickVisualMediaRequest, Uri?>) {
    photoPicker.launch(PickVisualMediaRequest(ActivityResultContracts.PickVisualMedia.ImageOnly))
}









