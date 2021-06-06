package com.bpawlowski.composecalendar.day

import androidx.compose.runtime.Stable
import com.bpawlowski.composecalendar.selection.SelectionState

@Stable
public data class DayState<T : SelectionState>(
  private val day: Day,
  val selectionState: T,
) : Day by day