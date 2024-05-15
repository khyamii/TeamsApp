package com.example.teamsapp.teamslist

import androidx.compose.ui.graphics.Color


data class Team (
    val id: Int,
    val title: String,
    val description: String,
    val players: List<String>,
    val image: Int? = null,
    val bgColor: Color
)
