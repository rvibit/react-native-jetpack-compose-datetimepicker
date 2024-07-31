package com.materialdatetimepicker

import android.graphics.Color
import com.facebook.react.module.annotations.ReactModule
import com.facebook.react.uimanager.SimpleViewManager
import com.facebook.react.uimanager.ThemedReactContext
import com.facebook.react.uimanager.ViewManagerDelegate
import com.facebook.react.uimanager.annotations.ReactProp
import com.facebook.react.viewmanagers.MaterialDatetimepickerViewManagerInterface
import com.facebook.react.viewmanagers.MaterialDatetimepickerViewManagerDelegate

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

  public override fun createViewInstance(context: ThemedReactContext): MaterialDatetimepickerView {
    return MaterialDatetimepickerView(context)
  }

  @ReactProp(name = "color")
  override fun setColor(view: MaterialDatetimepickerView?, color: String?) {
    view?.setBackgroundColor(Color.parseColor(color))
  }

  companion object {
    const val NAME = "MaterialDatetimepickerView"
  }
}
