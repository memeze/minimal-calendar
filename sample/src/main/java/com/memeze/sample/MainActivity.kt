package com.memeze.sample

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.memeze.minimalcalendar.ui.MinimalCalendar
import com.memeze.sample.ui.theme.MinimalCalendarTheme
import java.time.format.DateTimeFormatter

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MinimalCalendarTheme {
                var selectDate by remember { mutableStateOf("") }

                Scaffold(
                    modifier = Modifier.fillMaxSize(),
                    topBar = {
                        TopAppBar(
                            title = { Text(text = "Minimal calendar") }
                        )
                    }
                ) { innerPadding ->
                    Column(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(innerPadding),
                        verticalArrangement = Arrangement.spacedBy(8.dp)
                    ) {
                        Surface(
                            modifier = Modifier
                                .padding(16.dp),
                            shape = RoundedCornerShape(16.dp),
                            elevation = 4.dp
                        ) {
                            MinimalCalendar(
                                onSelectDate = { date ->
                                    selectDate = date.format(DateTimeFormatter.ofPattern("yyyy.MM.dd"))
                                }
                            )
                        }
                        Text(
                            modifier = Modifier.align(Alignment.CenterHorizontally),
                            text = selectDate
                        )
                    }
                }
            }
        }
    }
}