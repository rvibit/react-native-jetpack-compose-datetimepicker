package com.materialdatetimepicker

import android.annotation.SuppressLint
import android.os.Build
import android.widget.FrameLayout
import androidx.annotation.RequiresApi
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Edit
import androidx.compose.material3.DatePicker
import androidx.compose.material3.DatePickerDialog
import androidx.compose.material3.DisplayMode
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TimeInput
import androidx.compose.material3.TimePicker
import androidx.compose.material3.rememberDatePickerState
import androidx.compose.material3.rememberTimePickerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableLongStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import com.facebook.react.bridge.ReactContext
import com.facebook.react.uimanager.ThemedReactContext
import com.facebook.react.uimanager.UIManagerHelper
import com.facebook.react.uimanager.events.Event
import com.facebook.react.uimanager.events.EventDispatcher
import com.materialdatetimepicker.compose.TimePickerDialog
import com.materialdatetimepicker.events.OnCancelEvent
import com.materialdatetimepicker.events.OnConfirmEvent
import java.util.Calendar


@SuppressLint("ViewConstructor")
@RequiresApi(Build.VERSION_CODES.O)
class MaterialDatetimepickerView(private val context: ThemedReactContext) : FrameLayout(context) {
  private val composeView: ComposeView = ComposeView(context)
  private var isVisible = mutableStateOf(false)
  private var defaultDate = mutableLongStateOf(System.currentTimeMillis())
  private var confirmText = mutableStateOf("Ok")
  private var cancelText = mutableStateOf("Cancel")

  @OptIn(ExperimentalMaterial3Api::class)
  private var defaultDisplayMode = mutableStateOf(DisplayMode.Picker)
  private var defaultPickerType = mutableStateOf("date")

  private val surfaceId = UIManagerHelper.getSurfaceId(this)

  @OptIn(ExperimentalMaterial3Api::class)
  @Composable
  fun DatePickerCompose() {
    val datePickerState = rememberDatePickerState(
      initialSelectedDateMillis = defaultDate.longValue,
      initialDisplayMode = defaultDisplayMode.value,
    )
    if (isVisible.value){
      DatePickerDialog(
        onDismissRequest = { isVisible.value = false },
        confirmButton = {
          TextButton(onClick = {
            defaultDate.longValue = datePickerState.selectedDateMillis!!
            isVisible.value = false
            sendEvent(OnConfirmEvent(surfaceId ,id,datePickerState.selectedDateMillis))
          }) {
            Text(confirmText.value)
          }
        },
        dismissButton = {
          TextButton(onClick = {
            datePickerState.selectedDateMillis = defaultDate.longValue
            isVisible.value = false
            sendEvent(OnCancelEvent(surfaceId ,id))
          }) {
            Text(cancelText.value)
          }
        }
      ) {
        DatePicker(state = datePickerState)
      }
    }
  }


  @RequiresApi(Build.VERSION_CODES.O)
  @Composable
  @OptIn(ExperimentalMaterial3Api::class)
  fun TimePickerCompose() {
    val cal = Calendar.getInstance()
    cal.timeInMillis = defaultDate.longValue
    val state = rememberTimePickerState(
      initialHour = cal.get(Calendar.HOUR_OF_DAY),
      initialMinute = cal.get(Calendar.MINUTE),
    )

    val configuration = LocalConfiguration.current
    if (isVisible.value) {
      TimePickerDialog(
        title = if (isVisible.value) {
          "Select Time "
        } else {
          "Enter Time"
        },
        confirmText = confirmText.value,
        cancelText = cancelText.value,
        onCancel = {
          cal.timeInMillis = defaultDate.longValue
          isVisible.value = false
          sendEvent(OnCancelEvent(surfaceId ,id))
                   },
        onConfirm = {
          cal.set(Calendar.HOUR_OF_DAY, state.hour)
          cal.set(Calendar.MINUTE, state.minute)
          cal.isLenient = false
          defaultDate.longValue = cal.timeInMillis
          sendEvent(OnConfirmEvent(surfaceId ,id,cal.timeInMillis))
          isVisible.value = false
        },
        toggle = {
          if (configuration.screenHeightDp > 400) {
            IconButton(onClick = {
              if (defaultDisplayMode.value == DisplayMode.Input){
                defaultDisplayMode.value = DisplayMode.Picker
              }else{
                defaultDisplayMode.value = DisplayMode.Input
              }
            }) {
              val icon = if (defaultDisplayMode.value == DisplayMode.Picker) {
                painterResource(R.drawable.keyboard)
              } else {
                painterResource(R.drawable.baseline_access_time_24)
              }
              Icon(
                icon,
                contentDescription = if (isVisible.value) {
                  "Switch to Text Input"
                } else {
                  "Switch to Touch Input"
                }
              )
            }
          }
        }
      ) {
        if (defaultDisplayMode.value == DisplayMode.Picker && configuration.screenHeightDp > 400) {
          TimePicker(state = state)
        } else {
          TimeInput(state = state)
        }
      }
    }
  }

  fun isVisible(visible:Boolean){
    isVisible.value = visible
  }

  fun setDefaultDate(date:Double){
    defaultDate.value = date.toLong()
  }

  fun setConfirmText(value:String?){
    if (value != null) {
      confirmText.value = value
    }
  }

  fun setCancelText(value:String?){
    if (value != null) {
      cancelText.value = value
    }
  }

  private fun sendEvent(event: Event<*>) {
    val eventDispatcher: EventDispatcher? =
      UIManagerHelper.getEventDispatcherForReactTag(context as ReactContext, id)
    eventDispatcher?.dispatchEvent(event)
  }

  @OptIn(ExperimentalMaterial3Api::class)
  fun setDisplayMode(value: String?) {
    defaultDisplayMode.value = if(value == "picker") DisplayMode.Picker else DisplayMode.Input
  }

   fun setPickerType(value: String?) {
    if (value != null) {
      defaultPickerType.value = value
    }
  }

  init {
    composeView.setContent {
      if (defaultPickerType.value == "date"){
        DatePickerCompose()
      }else{
        TimePickerCompose()
      }
    }
    addView(composeView)
  }
}
