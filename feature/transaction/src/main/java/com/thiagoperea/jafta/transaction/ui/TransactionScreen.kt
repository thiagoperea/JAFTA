package com.thiagoperea.jafta.transaction.ui

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.AlertDialog
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Icon
import androidx.compose.material.ModalBottomSheetLayout
import androidx.compose.material.ModalBottomSheetState
import androidx.compose.material.ModalBottomSheetValue
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.DialogProperties
import com.thiagoperea.jafta.design_system.LoadingScreen
import com.thiagoperea.jafta.design_system.dialog.DialogState
import com.thiagoperea.jafta.design_system.theme.Dark100
import com.thiagoperea.jafta.design_system.theme.Red100
import com.thiagoperea.jafta.design_system.theme.TextStyles
import com.thiagoperea.jafta.design_system.theme.Violet100
import com.thiagoperea.jafta.transaction.ui.type.TransactionScreenType
import com.thiagoperea.jafta.transaction.ui.view.TransactionRepeatSheet
import kotlinx.coroutines.launch
import org.koin.androidx.compose.koinViewModel

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun TransactionScreen(
    screenType: TransactionScreenType,
    viewModel: TransactionViewModel = koinViewModel(),
    onNavigateUp: () -> Unit
) {
    val coroutineScope = rememberCoroutineScope()
    val screenState = viewModel.screenState.value

    val bottomSheetState = ModalBottomSheetState(
        initialValue = ModalBottomSheetValue.Hidden,
        confirmStateChange = { false }
    )

    BackHandler {
        if (bottomSheetState.isVisible) {
            coroutineScope.launch { bottomSheetState.hide() }
            viewModel.isRepeatingTransaction.value = false
            return@BackHandler
        }

        onNavigateUp()
    }

    LaunchedEffect(Unit) {
        viewModel.loadScreen()
    }

    /* TODO: EXT FUN TO HANDLE LOADING? */
    if (screenState == TransactionState.Loading) {
        LoadingScreen()
    }

    /* TODO: EXT FUN TO HANDLE DIALOGS */
    val dialogState = viewModel.dialogState.value

    when (dialogState) {
        is DialogState.Dismissed -> Unit
        is DialogState.Loading -> {
            AlertDialog(
                onDismissRequest = {},
                shape = RoundedCornerShape(16.dp),
                properties = DialogProperties(
                    dismissOnBackPress = false,
                    dismissOnClickOutside = false
                ),
                buttons = {
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(20.dp),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        CircularProgressIndicator(
                            modifier = Modifier.size(48.dp)
                        )

                        Spacer(Modifier.height(16.dp))

                        Text(
                            text = stringResource(dialogState.messageRes),
                            style = TextStyles.body3,
                            color = Dark100
                        )
                    }
                }
            )
        }
        is DialogState.Failure -> {
            AlertDialog(
                onDismissRequest = {},
                shape = RoundedCornerShape(16.dp),
                properties = DialogProperties(
                    dismissOnBackPress = false,
                    dismissOnClickOutside = false
                ),
                buttons = {
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(20.dp),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Icon(
                            modifier = Modifier.size(48.dp),
                            painter = painterResource(com.thiagoperea.jafta.design_system.R.drawable.ic_warning),
                            tint = Red100,
                            contentDescription = null
                        )

                        Spacer(Modifier.height(16.dp))

                        Text(
                            text = stringResource(dialogState.messageRes),
                            style = TextStyles.body3,
                            color = Dark100
                        )
                    }
                }
            )
        }
        is DialogState.Success -> {
            AlertDialog(
                onDismissRequest = {},
                shape = RoundedCornerShape(16.dp),
                properties = DialogProperties(
                    dismissOnBackPress = false,
                    dismissOnClickOutside = false
                ),
                buttons = {
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(20.dp),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Icon(
                            modifier = Modifier.size(48.dp),
                            painter = painterResource(com.thiagoperea.jafta.design_system.R.drawable.ic_success),
                            tint = Violet100,
                            contentDescription = null
                        )

                        Spacer(Modifier.height(16.dp))

                        Text(
                            text = stringResource(dialogState.messageRes),
                            style = TextStyles.body3,
                            color = Dark100
                        )
                    }
                }
            )
        }
    }



    ModalBottomSheetLayout(
        sheetState = bottomSheetState,
        sheetShape = RoundedCornerShape(topStart = 32.dp, topEnd = 32.dp),
        sheetContent = {
            //TODO: I COULD SHOW ANY KIND OF SHEETS HERE

            TransactionRepeatSheet(
                onNextClick = {

                    /* TODO: DISMISS BOTTOMSHEET AND SET VALUES */

                    viewModel.isRepeatingTransaction.value = false
                    coroutineScope.launch { bottomSheetState.hide() }
                }
            )
        }
    ) {
        TransactionScreenContent(
            type = screenType,
            onNavigateUp = onNavigateUp,
            isRepeatingTransaction = viewModel.isRepeatingTransaction.value,
            onRepeatingTransactionChanged = {
                viewModel.isRepeatingTransaction.value = it

                if (viewModel.isRepeatingTransaction.value) {
                    coroutineScope.launch { bottomSheetState.show() }
                }
            },
            frequency = viewModel.frequency,
            endDate = viewModel.endDate,
            onEditFrequencyClick = { /* TODO: reopen transaction dialog */ },
            onSaveClick = { viewModel.saveTransaction() }
        )
    }
}
