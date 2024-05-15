package com.example.teamsapp.ui.screens

import androidx.compose.animation.AnimatedVisibilityScope
import androidx.compose.animation.ExperimentalSharedTransitionApi
import androidx.compose.animation.SharedTransitionScope
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.teamsapp.R
import com.example.teamsapp.teamslist.SharedViewModel

@OptIn(ExperimentalSharedTransitionApi::class)
@Composable
fun SharedTransitionScope.TeamDetailsScreen(
    navController: NavController,
    animatedVisibilityScope: AnimatedVisibilityScope,
    sharedViewModel: SharedViewModel
)  {
    val team =sharedViewModel.team
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color.Black)

    ) {
        LazyColumn(
            modifier = Modifier.fillMaxSize(),
        ) {

            item {
                Box(
                    modifier = Modifier
                        .background(
                            team!!.bgColor,
                            RoundedCornerShape(
                                bottomEnd = 75.dp, bottomStart = 75.dp
                            ),
                        )
                        .height(300.dp)
                        .fillMaxWidth()
                        .clip(
                            RoundedCornerShape(
                                bottomEnd = 35.dp, bottomStart = 35.dp
                            )
                        ),
                ) {

                    Box(
                        modifier = Modifier
                            .aspectRatio(1f)
                            .align(Alignment.Center)
                            .fillMaxSize()

                    ) {
                        Box(modifier = Modifier.fillMaxSize()) {

                            Image(
                                alignment = Alignment.Center,
                                painter = painterResource(team.image!!),
                                contentDescription = null,
                                modifier = Modifier
                                    .align(Alignment.Center)
                                    .size(220.dp)
                                    .padding(16.dp)
                                    .background(
                                        Color.Transparent,
                                        CircleShape,
                                    )
                                    .sharedElement(
                                        state = rememberSharedContentState(key = "image/${team.image}"),
                                        animatedVisibilityScope = animatedVisibilityScope,
                                        boundsTransform = { _, _ ->
                                            tween(durationMillis = 1500)
                                        }
                                    )
                                    .fillMaxWidth()
                            )
                        }
                    }
                }
            }


            item {
                Text(
                    text = team!!.title,
                    style = MaterialTheme.typography.labelLarge,
                    fontWeight = FontWeight.W700,
                    fontSize = 20.sp,
                    color = Color.White,
                    modifier = Modifier
                        .padding(
                            top = 16.dp, start = 16.dp, end = 16.dp
                        )
                        .sharedElement(
                            state = rememberSharedContentState(key = "text/${team.title}"),
                            animatedVisibilityScope = animatedVisibilityScope,
                            boundsTransform = { _, _ ->
                                tween(durationMillis = 1500)
                            }
                        )
                )

                Text(
                    text = team.description,
                    color = Color.White,
                    fontSize = 14.sp,
                    fontStyle = FontStyle.Italic,
                    style = MaterialTheme.typography.bodySmall,
                    modifier = Modifier
                        .padding(
                            top = 16.dp, start = 16.dp, end = 16.dp
                        )
                        .sharedElement(
                            state = rememberSharedContentState(key = "text/${team.description}"),
                            animatedVisibilityScope = animatedVisibilityScope,
                            boundsTransform = { _, _ ->
                                tween(durationMillis = 1500)
                            }
                        )

                )

                Text(
                    text = "Players",
                    style = MaterialTheme.typography.bodySmall,
                    fontWeight = FontWeight.W700,
                    fontSize = 16.sp,
                    color = Color.White,
                    modifier = Modifier.padding(
                        top = 16.dp, start = 16.dp, end = 16.dp
                    )
                )

            }

            itemsIndexed(team!!.players) { _, value ->
                Box(modifier = Modifier.padding(start = 16.dp, end = 16.dp, top = 8.dp)) {
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 8.dp)
                            .border(
                                width = 3.dp,
                                color = team.bgColor,
                                shape = RoundedCornerShape(15.dp)
                            )
                    ) {
                        Row {
                            Image(
                                painter = painterResource(R.drawable.football_icon),
                                contentDescription = null,
                                modifier = Modifier
                                    .padding(16.dp)
                                    .size(25.dp),
                                colorFilter = ColorFilter.tint(team.bgColor)
                            )
                            Text(
                                text = value,
                                style = MaterialTheme.typography.bodyMedium,
                                color = Color.White,
                                fontSize = 14.sp,
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(
                                        start = 8.dp,
                                        end = 8.dp,
                                        top = 16.dp,
                                        bottom = 16.dp
                                    ),
                                maxLines = 1,
                                overflow = TextOverflow.Ellipsis
                            )
                        }
                    }


                }
            }


        }
        Box(modifier = Modifier.padding(10.dp).background(
            color = Color.Black, shape = RoundedCornerShape(50)
        ).shadow(elevation = 16.dp).padding(5.dp).clickable {
            navController.popBackStack()
        }) {
            if (team != null) {
                Icon(
                    imageVector = Icons.Filled.ArrowBack,
                    contentDescription = null,
                    tint = team.bgColor,
                    modifier = Modifier.size(30.dp)
                )
            }


        }

        }

}
