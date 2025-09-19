package io.github.boguszpawlowski.composecalendar.header

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowLeft
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowRight
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.unit.dp
import java.time.format.TextStyle.FULL
import java.util.Locale

/**
 * Default implementation of month header, shows current month and year, as well as
 * 2 arrows for changing currently showed month
 */
@Composable
public fun DefaultMonthHeader(
    monthState: MonthState,
    modifier: Modifier = Modifier,
) {
    Row(
        modifier = modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically,
    ) {
        IconButton(
            modifier = Modifier.testTag("Decrement"),
            onClick = { monthState.currentMonth = monthState.currentMonth.minusMonths(1) },
        ) {
            Image(
                imageVector = Icons.AutoMirrored.Filled.KeyboardArrowLeft,
                colorFilter = ColorFilter.tint(MaterialTheme.colorScheme.onSurface),
                contentDescription = "Previous",
            )
        }
        Text(
            modifier = Modifier.testTag("MonthLabel"),
            text = monthState.currentMonth.month
                .getDisplayName(FULL, Locale.getDefault())
                .lowercase()
                .replaceFirstChar { it.titlecase() },
            style = MaterialTheme.typography.headlineSmall,
        )
        Spacer(modifier = Modifier.width(8.dp))
        Text(
            text = monthState.currentMonth.year.toString(),
            style = MaterialTheme.typography.headlineSmall,
        )
        IconButton(
            modifier = Modifier.testTag("Increment"),
            onClick = { monthState.currentMonth = monthState.currentMonth.plusMonths(1) },
        ) {
            Image(
                imageVector = Icons.AutoMirrored.Filled.KeyboardArrowRight,
                colorFilter = ColorFilter.tint(MaterialTheme.colorScheme.onSurface),
                contentDescription = "Next",
            )
        }
    }
}
