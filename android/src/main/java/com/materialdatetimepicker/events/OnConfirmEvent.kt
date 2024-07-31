package com.materialdatetimepicker.events


import com.facebook.react.bridge.Arguments
import com.facebook.react.bridge.WritableMap
import com.facebook.react.uimanager.events.Event

class OnConfirmEvent(
  surfaceId: Int,
  viewId: Int,
  private val selectedDateMillis: Long?,
) : Event<OnConfirmEvent>(surfaceId, viewId) {
  override fun getEventName() = EVENT_NAME

  // All events for a given view can be coalesced.
  override fun getCoalescingKey(): Short = 0

  override fun getEventData(): WritableMap? = Arguments.createMap().apply {
    selectedDateMillis?.let { putDouble("date", it.toDouble()) }
  }

  companion object {
    const val EVENT_NAME = "onConfirm"
  }
}
