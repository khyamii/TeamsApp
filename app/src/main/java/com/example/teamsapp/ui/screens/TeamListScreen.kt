package com.example.teamsapp.ui.screens

import androidx.compose.animation.AnimatedVisibilityScope
import androidx.compose.animation.ExperimentalSharedTransitionApi
import androidx.compose.animation.SharedTransitionScope
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.teamsapp.teamslist.TeamListItemImageWrapper
import com.example.teamsapp.teamslist.teamsList
import com.example.teamsapp.teamslist.SharedViewModel

@OptIn(ExperimentalSharedTransitionApi::class)
@Composable
fun SharedTransitionScope.TeamListScreen(
    animatedVisibilityScope: AnimatedVisibilityScope,
    sharedViewModel: SharedViewModel,
    onItemClick: () -> Unit,

    ) {
    Box (Modifier.background(Color.Black).padding(vertical = 12.dp, horizontal = 5.dp)){
        LazyColumn(modifier = Modifier
            .fillMaxSize()
            .padding(vertical = 16.dp, horizontal = 5.dp)) {
            itemsIndexed(teamsList) { index, team ->

                Box(modifier = Modifier) {
                    Box(
                        modifier = Modifier
                            .padding(
                                top = 8.dp,
                                start = 16.dp,
                                end = 16.dp,
                                bottom = 16.dp
                            )
                            .height(160.dp)
                            .shadow(
                                elevation = 16.dp,
                                shape = RoundedCornerShape(35.dp),
                                clip = true,
                                ambientColor = Color(0xffCE5A01),
                                spotColor = Color(0xffCE5A01)
                            )
                            .fillMaxWidth()
                            .aspectRatio(1.5f)
                            .background(team.bgColor, RoundedCornerShape(35.dp))
                            .clickable {
                                sharedViewModel.team = team
                                onItemClick()
                            }
                    ) {

                        Box(modifier = Modifier.fillMaxWidth()) {
                            Row(
                                modifier = Modifier
                                    .fillMaxHeight()
                                    .padding(16.dp)
                                    .fillMaxWidth(0.55f),
                                verticalAlignment = Alignment.Bottom
                            ) {
                                Column(modifier = Modifier.align(Alignment.CenterVertically)) {
                                    Text(
                                        text = team.title,
                                        style = MaterialTheme.typography.bodySmall,
                                        fontWeight = FontWeight.W700,
                                        color = Color.Black,
                                        fontSize = 16.sp,
                                        modifier = Modifier
                                            .padding(top = 5.dp)
                                            .sharedElement(
                                                state = rememberSharedContentState(key = "text/${team.title}"),
                                                animatedVisibilityScope = animatedVisibilityScope,
                                                boundsTransform = { _, _ ->
                                                    tween(durationMillis = 1500)
                                                }
                                            )
                                    )
                                    Text(
                                        team.description,
                                        style = MaterialTheme.typography.bodyMedium,
                                        fontStyle = FontStyle.Italic,
                                        color = Color.DarkGray,
                                        maxLines = 3,
                                        overflow = TextOverflow.Ellipsis,
                                        modifier = Modifier
                                            .padding(top = 5.dp, bottom = 16.dp)
                                            .sharedElement(
                                                state = rememberSharedContentState(key = "text/${team.description}"),
                                                animatedVisibilityScope = animatedVisibilityScope,
                                                boundsTransform = { _, _ ->
                                                    tween(durationMillis = 1500)
                                                }
                                            )
                                    )
                                }
                                Spacer(modifier = Modifier.weight(1f))
                            }
                        }

                    }

                    TeamListItemImageWrapper(modifier = Modifier
                        .align(Alignment.TopEnd)
                        .padding(end = 5.dp)
                        .fillMaxWidth(0.30f),
                        child = {
                            Box() {
                                Box(
                                    Modifier
                                        .clip(RoundedCornerShape(50))
                                        .background(
                                            color = Color.Transparent,
                                            shape = RoundedCornerShape(50)
                                        )
                                )

                                Image(
                                    painter = painterResource(team.image!!),
                                    contentDescription = null,
                                    modifier = Modifier
                                        .background(
                                            color = Color(0xffCE5A01).copy(alpha = 0.2f),
                                            shape = CircleShape,
                                        )
                                        .aspectRatio(1f)
                                        .sharedElement(
                                            state = rememberSharedContentState(key = "image/${team.image}"),
                                            animatedVisibilityScope = animatedVisibilityScope,
                                            boundsTransform = { _, _ ->
                                                tween(durationMillis = 1500)
                                            }
                                        )
                                )
                            }
                        })


                }

            }

        }
    }


}
