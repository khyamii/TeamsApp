package com.example.teamsapp.teamslist

import androidx.compose.ui.graphics.Color
import com.example.teamsapp.R

val teamsList = listOf(
    Team(
        id = 1,
        title = "Real Madrid CF",
        description =
        "14 Champions League \n35 La Liga",
        players = listOf(
            "Thibaut Courtois",
            "Dani Carvajal",
            "Éder Militão",
            "David Alaba",
            "Jude Bellingham",
            "Nacho Fernández (captain)",
            "Vinícius Júnior",
            "Toni Kroos",
            "Luka Modrić (vice-captain)",
            "Rodrygo",
            "Eduardo Camavinga",
        ),
        image = R.drawable.real_madrid,
        bgColor = Color(0xFFE6F7FF),
    ),
    Team(
        id = 2,
        title = "Bayern Munich CF",
        "6 Champions League \n33 Bundesliga",
        players = listOf(
            "Manuel Neuer (captain)",
            "Dayot Upamecano",
            "Kim Min-jae",
            "Matthijs de Ligt",
            "Joshua Kimmich (3rd captain)",
            "Serge Gnabry",
            "Leon Goretzka (4th captain)",
            "Harry Kane",
            "Leroy Sané",
            "Kingsley Coman",
            "Eric Maxim Choupo-Moting",
            "Eric Dier ",
        ),

        image = R.drawable.bayern,
        bgColor = Color(0xFFFF4768),

    ),
    Team(
        id = 3,
        title = "Barcelona CF",
        description =
        "5 Champions League \n26 La Liga",
        players = listOf(
            "Marc-André ter Stegen",
            "João Cancelo",
            "Alejandro Balde",
            "Ronald Araújo",
            "Iñigo Martínez",
            "Gavi",
            "Ferran Torres",
            "Pedri",
            "Robert Lewandowski",
            "Raphinha",
            "Eric Maxim Choupo-Moting",
            "Fermín López ",
        ),
        image = R.drawable.barcelona,
        bgColor = Color(0xFFFFED52),
    ),
    Team(
        id = 4,
        title = "Manchester United",
        description =
        "3 Champions League \n20 Premier league",
        players = listOf(
            "André Onana",
            "Victor Lindelöf",
            "Sofyan Amrabat ",
            "Harry Maguire",
            "Lisandro Martínez",
            "Mason Mount",
            "Bruno Fernandes (captain)",
            "Anthony Martial",
            "Marcus Rashford",
            "Rasmus Højlund",
            "Tyrell Malacia",
            "Casemiro",
        ),
        image = R.drawable.man_united,
        bgColor = Color(0xFF63DDEC),
    ),
    Team(
        id = 5,
        title = "Chelsea",
        description =
        "2 Champions League \n5 Premier league",
        players = listOf(
            "Thibaut Courtois",
            "Dani Carvajal",
            "Éder Militão",
            "David Alaba",
            "Jude Bellingham",
            "Nacho Fernández (captain)",
            "Vinícius Júnior",
            "Toni Kroos",
            "Luka Modrić (vice-captain)",
            "Rodrygo",
            "Eduardo Camavinga",
        ),
        image = R.drawable.chelsea,
        bgColor = Color(0xFF657DFF),
    )

)