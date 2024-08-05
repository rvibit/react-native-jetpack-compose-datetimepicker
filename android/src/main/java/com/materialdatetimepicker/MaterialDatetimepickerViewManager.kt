package com.materialdatetimepicker

import android.graphics.Color
import android.os.Build
import android.util.Log
import androidx.annotation.RequiresApi
import com.facebook.react.common.MapBuilder
import com.facebook.react.module.annotations.ReactModule
import com.facebook.react.uimanager.SimpleViewManager
import com.facebook.react.uimanager.ThemedReactContext
import com.facebook.react.uimanager.ViewManagerDelegate
import com.facebook.react.uimanager.annotations.ReactProp
import com.facebook.react.viewmanagers.MaterialDatetimepickerViewManagerInterface
import com.facebook.react.viewmanagers.MaterialDatetimepickerViewManagerDelegate
import com.materialdatetimepicker.events.OnConfirmEvent

@ReactModule(name = MaterialDatetimepickerViewManager.NAME)
class MaterialDatetimepickerViewManager : SimpleViewManager<MaterialDatetimepickerView>(),
  MaterialDatetimepickerViewManagerInterface<MaterialDatetimepickerView> {
  private val mDelegate: ViewManagerDelegate<MaterialDatetimepickerView>

  init {
    mDelegate = MaterialDatetimepickerViewManagerDelegate(this)
  }

  override fun getDelegate(): ViewManagerDelegate<MaterialDatetimepickerView>? {
    return mDelegate
  }

  override fun getName(): String {
    return NAME
  }

  @RequiresApi(Build.VERSION_CODES.O)
  public override fun createViewInstance(context: ThemedReactContext): MaterialDatetimepickerView {
    return MaterialDatetimepickerView(context)
  }

  companion object {
    const val NAME = "MaterialDatetimepickerView"
  }


  @RequiresApi(Build.VERSION_CODES.O)
  override fun setIsVisible(view: MaterialDatetimepickerView?, isVisible: Boolean) {
    view?.isVisible(isVisible)
  }


  override fun getExportedCustomDirectEventTypeConstants(): MutableMap<String, Any> =
    mutableMapOf(
      OnConfirmEvent.EVENT_NAME to MapBuilder.of("registrationName", "onConfirm"),
    )

  @RequiresApi(Build.VERSION_CODES.O)
  override fun setDefaultDate(view: MaterialDatetimepickerView?, value: Double) {
    view?.setDefaultDate(value)
  }

  @RequiresApi(Build.VERSION_CODES.O)
  override fun setConfirmText(view: MaterialDatetimepickerView?, value: String?) {
    view?.setConfirmText(value)
  }

  @RequiresApi(Build.VERSION_CODES.O)
  override fun setCancelText(view: MaterialDatetimepickerView?, value: String?) {
    view?.setCancelText(value)
  }

  @RequiresApi(Build.VERSION_CODES.O)
  override fun setDisplayMode(view: MaterialDatetimepickerView?, value: String?) {
    view?.setDisplayMode(value)
  }

  @RequiresApi(Build.VERSION_CODES.O)
  override fun setPickerType(view: MaterialDatetimepickerView?, value: String?) {
    view?.setPickerType(value)
  }

  @RequiresApi(Build.VERSION_CODES.O)
  override fun setThemeVarient(view: MaterialDatetimepickerView?, value: String?) {
    view?.setThemeVarient(value)
  }

  @RequiresApi(Build.VERSION_CODES.O)
  override fun setDynamicColors(view: MaterialDatetimepickerView?, value: Boolean) {
    view?.setDynamicColors(value)
  }
}
