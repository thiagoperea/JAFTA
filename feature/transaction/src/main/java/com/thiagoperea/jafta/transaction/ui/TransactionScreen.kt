package com.thiagoperea.jafta.transaction.ui

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.ModalBottomSheetLayout
import androidx.compose.material.ModalBottomSheetState
import androidx.compose.material.ModalBottomSheetValue
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.unit.dp
import com.thiagoperea.jafta.design_system.LoadingScreen
import com.thiagoperea.jafta.design_system.dialog.DialogState
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
    when (viewModel.dialogState.value) {
        is DialogState.Dismissed -> Unit
        is DialogState.Failure -> TODO()
        is DialogState.Loading -> TODO()
        is DialogState.Success -> TODO()
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
