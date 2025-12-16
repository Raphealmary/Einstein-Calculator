package com.einstein.calculator

import android.content.res.Configuration
import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.background
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyHorizontalGrid
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem

import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.DialogProperties
import com.einstein.calculator.ui.theme.EinsteinCalculatorTheme
import java.text.DecimalFormat

@Composable
fun layout() {
    EinsteinCalculatorTheme {

        var calculation by remember { mutableStateOf("") }
        var result by remember { mutableStateOf("") }
        var num1 by remember { mutableStateOf("") }
        var num2 by remember { mutableStateOf("") }
        var operator by remember { mutableStateOf("") }


        Column(
            modifier = Modifier.fillMaxSize(),

            verticalArrangement = Arrangement.SpaceBetween

        ) {


//first layer
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceEvenly,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Button(
                    onClick = {}, colors = ButtonDefaults.buttonColors(
                        containerColor = Color.Transparent,
                        contentColor = MaterialTheme.colorScheme.onPrimary
                    ), shape = RoundedCornerShape(5.dp)
                ) {
                    Icon(painterResource(R.drawable.close_fullscreen), contentDescription = null)
                }
                Button(
                    onClick = {},

                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color.Transparent, contentColor = Color.White
                    ), shape = RoundedCornerShape(10.dp)
                ) {
                    Icon(
                        painterResource(R.drawable.equal),
                        contentDescription = null,
                        modifier = Modifier.background(MaterialTheme.colorScheme.secondary)
                    )
                }
                Button(
                    onClick = {}, colors = ButtonDefaults.buttonColors(
                        containerColor = Color.Transparent,
                        contentColor = MaterialTheme.colorScheme.onPrimary
                    ), shape = RoundedCornerShape(5.dp)
                ) {
                    Icon(painterResource(R.drawable.bars), contentDescription = null)
                }

                ///put the 3 dot button Here
                TextButton(onClick = {}) {
                    Dropdown()
                }
                ///put the 3 dot button Here

            }
            //second layer
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.End,
            ) {
                Column(
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.End
                ) {
                    Text(
                        //"himan",
//                        DecimalFormat("#,##0.####")
//                            .format(num2.toDouble()).toString(),
                        textView(operator, num2, num1),
                        fontSize = 40.sp,
                        textAlign = TextAlign.Right,
                        color = MaterialTheme.colorScheme.onPrimaryContainer,
                        fontWeight = FontWeight.Medium,
                        modifier = Modifier
                            .padding(15.dp)
                            .horizontalScroll(rememberScrollState())
                    )
                    Text(
                        result,

                        fontSize = 70.sp,
                        textAlign = TextAlign.Right,
                        color = MaterialTheme.colorScheme.onPrimary,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier
                            .padding(15.dp)
                            .horizontalScroll(rememberScrollState()),

                        )
                }
            }
            //last layer
            Row(
                modifier = Modifier

                    .fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceEvenly,


                ) {
                LazyHorizontalGrid(
                    rows = GridCells.Fixed(5),
                    contentPadding = PaddingValues(10.dp),
                    verticalArrangement = Arrangement.spacedBy(12.dp),
                    horizontalArrangement = Arrangement.SpaceEvenly,
                    modifier = Modifier
                        .height(450.dp)
                        .fillMaxWidth()
                ) {
                    //first five
                    item {
                        Button(
                            onClick = {
                                calculation = ""
                                result = ""
                                num1 = ""
                                num2 = ""
                                operator = ""
                            },
                            colors = ButtonDefaults.buttonColors(
                                containerColor = MaterialTheme.colorScheme.onSecondary,
                                contentColor = MaterialTheme.colorScheme.onPrimary
                            ),
                            shape = RoundedCornerShape(15.dp),
                            modifier = Modifier

                        ) {
                            Text("C", fontSize = 30.sp)
                        }

                    }
                    item {
                        Button(
                            onClick = {
                                num1 += "7"
                            },
                            colors = ButtonDefaults.buttonColors(
                                containerColor = MaterialTheme.colorScheme.tertiary,
                                contentColor = MaterialTheme.colorScheme.onTertiary
                            ),
                            shape = RoundedCornerShape(15.dp),
                            modifier = Modifier

                        ) {
                            Text("7", fontSize = 30.sp)
                        }
                    }
                    item {
                        Button(
                            onClick = {
                                num1 += "4"
                            },
                            colors = ButtonDefaults.buttonColors(
                                containerColor = MaterialTheme.colorScheme.tertiary,
                                contentColor = MaterialTheme.colorScheme.onTertiary
                            ),
                            shape = RoundedCornerShape(15.dp),
                            modifier = Modifier

                        ) {
                            Text("4", fontSize = 30.sp)
                        }
                    }
                    item {
                        Button(
                            onClick = {
                                num1 += "1"
                            },
                            colors = ButtonDefaults.buttonColors(
                                containerColor = MaterialTheme.colorScheme.tertiary,
                                contentColor = MaterialTheme.colorScheme.onTertiary
                            ),
                            shape = RoundedCornerShape(15.dp),
                            modifier = Modifier

                        ) {
                            Text("1", fontSize = 30.sp)
                        }
                    }
                    item {
                        TextButton(
                            onClick = {},
                            colors = ButtonDefaults.buttonColors(
                                containerColor = Color.Transparent,
                                contentColor = MaterialTheme.colorScheme.secondary
                            ),
                            shape = RoundedCornerShape(15.dp),
                            modifier = Modifier

                        ) {
                            Icon(
                                painterResource(R.drawable.sync),
                                contentDescription = null,
                                modifier = Modifier.size(40.dp)
                            )
                        }
                    }
                    //first five

                    item {

                        TextButton(
                            onClick = {},
                            colors = ButtonDefaults.buttonColors(
                                containerColor = MaterialTheme.colorScheme.onSecondary,
                                contentColor = MaterialTheme.colorScheme.onPrimary
                            ),
                            shape = RoundedCornerShape(15.dp),
                            modifier = Modifier

                        ) {
                            Icon(
                                painterResource(R.drawable.clear),
                                contentDescription = null,
                                modifier = Modifier.size(40.dp)
                            )
                        }
                    }
                    item {
                        Button(
                            onClick = {
                                num1 += "8"
                            },
                            colors = ButtonDefaults.buttonColors(
                                containerColor = MaterialTheme.colorScheme.tertiary,
                                contentColor = MaterialTheme.colorScheme.onTertiary
                            ),
                            shape = RoundedCornerShape(15.dp),
                            modifier = Modifier

                        ) {
                            Text("8", fontSize = 30.sp)
                        }
                    }
                    item {
                        Button(
                            onClick = {
                                num1 += "5"
                            },
                            colors = ButtonDefaults.buttonColors(
                                containerColor = MaterialTheme.colorScheme.tertiary,
                                contentColor = MaterialTheme.colorScheme.onTertiary
                            ),
                            shape = RoundedCornerShape(15.dp),
                            modifier = Modifier

                        ) {
                            Text("5", fontSize = 30.sp)
                        }
                    }
                    item {
                        Button(
                            onClick = {
                                num1 += "2"
                            },
                            colors = ButtonDefaults.buttonColors(
                                containerColor = MaterialTheme.colorScheme.tertiary,
                                contentColor = MaterialTheme.colorScheme.onTertiary
                            ),
                            shape = RoundedCornerShape(15.dp),
                            modifier = Modifier

                        ) {
                            Text("2", fontSize = 30.sp)
                        }
                    }
                    item {
                        Button(
                            onClick = {
                                num1 += "0"
                            },
                            colors = ButtonDefaults.buttonColors(
                                containerColor = MaterialTheme.colorScheme.tertiary,
                                contentColor = MaterialTheme.colorScheme.onTertiary
                            ),
                            shape = RoundedCornerShape(15.dp),
                            modifier = Modifier

                        ) {
                            Text("0", fontSize = 30.sp)
                        }
                    }


                    item {
                        Button(
                            onClick = {
                                num2 = num1
                                num1 = ""
                                if (num2 == "" && num1 == "") {
                                    result = ""
                                } else {
                                    operator = "÷"
                                }
                            },
                            colors = ButtonDefaults.buttonColors(
                                containerColor = MaterialTheme.colorScheme.secondary,
                                contentColor = Color.White
                            ),
                            shape = RoundedCornerShape(15.dp),
                            modifier = Modifier

                        ) {
                            Text("÷", fontSize = 30.sp)
                        }
                    }
                    item {
                        Button(
                            onClick = {
                                num1 += "9"
                            },
                            colors = ButtonDefaults.buttonColors(
                                containerColor = MaterialTheme.colorScheme.tertiary,
                                contentColor = MaterialTheme.colorScheme.onTertiary
                            ),
                            shape = RoundedCornerShape(15.dp),
                            modifier = Modifier

                        ) {
                            Text("9", fontSize = 30.sp)
                        }
                    }
                    item {
                        Button(
                            onClick = {
                                num1 += "6"
                            },
                            colors = ButtonDefaults.buttonColors(
                                containerColor = MaterialTheme.colorScheme.tertiary,
                                contentColor = MaterialTheme.colorScheme.onTertiary
                            ),
                            shape = RoundedCornerShape(15.dp),
                            modifier = Modifier

                        ) {
                            Text("6", fontSize = 30.sp)
                        }
                    }
                    item {

                        Button(
                            onClick = {
                                num1 += "3"
                            },
                            colors = ButtonDefaults.buttonColors(
                                containerColor = MaterialTheme.colorScheme.tertiary,
                                contentColor = MaterialTheme.colorScheme.onTertiary
                            ),
                            shape = RoundedCornerShape(15.dp),
                            modifier = Modifier

                        ) {
                            Text("3", fontSize = 30.sp)
                        }
                    }
                    item {
                        Button(
                            onClick = {
                                num1 += "."
                            },
                            colors = ButtonDefaults.buttonColors(
                                containerColor = MaterialTheme.colorScheme.tertiary,
                                contentColor = MaterialTheme.colorScheme.onTertiary
                            ),
                            shape = RoundedCornerShape(15.dp),
                            modifier = Modifier

                        ) {
                            Text(".", fontSize = 45.sp)
                        }
                    }


                    item {
                        Button(
                            onClick = {
                                num2 = num1
                                num1 = ""
                                if (num2 == "" && num1 == "") {
                                    result = ""
                                } else {
                                    operator = "*"
                                }

                            },

                            modifier = Modifier,

                            colors = ButtonDefaults.buttonColors(
                                containerColor = MaterialTheme.colorScheme.secondary,
                                contentColor = Color.White
                            ),
                            shape = RoundedCornerShape(15.dp)
                        ) {
                            Icon(
                                Icons.Default.Clear,
                                contentDescription = null,
                                modifier = Modifier.size(40.dp)
                            )
                        }
                    }
                    item {
                        Button(
                            onClick = {
                                num2 = num1
                                num1 = ""
                                if (num2 == "" && num1 == "") {
                                    result = ""
                                } else {
                                    operator = "-"
                                }
                            },
                            colors = ButtonDefaults.buttonColors(
                                containerColor = MaterialTheme.colorScheme.secondary,
                                contentColor = Color.White
                            ),
                            shape = RoundedCornerShape(15.dp),
                            modifier = Modifier

                        ) {
                            Icon(
                                painterResource(R.drawable.minus),
                                contentDescription = null,
                                modifier = Modifier.size(40.dp)
                            )
                        }
                    }
                    item {
                        Button(
                            onClick = {
                                num2 = num1
                                num1 = ""
                                if (num2 == "" && num1 == "") {
                                    result = ""
                                } else {
                                    operator = "+"
                                }
                            },
                            colors = ButtonDefaults.buttonColors(
                                containerColor = MaterialTheme.colorScheme.secondary,
                                contentColor = Color.White
                            ),
                            shape = RoundedCornerShape(15.dp),
                            modifier = Modifier
                        ) {
                            Icon(
                                Icons.Default.Add,
                                contentDescription = null,
                                modifier = Modifier.size(40.dp)
                            )
                        }
                    }
                    item {
                        Button(
                            onClick = {
                                var verify = Calculation(operator, num1, num2).removeSuffix(".0")

                                if (verify == "NaN") {
                                    result = "0"

                                } else {
                                    result = Calculation(operator, num1, num2).removeSuffix(".0")

                                }
                            },
                            colors = ButtonDefaults.buttonColors(
                                containerColor = MaterialTheme.colorScheme.secondary,
                                contentColor = Color.White,
                            ),
                            shape = RoundedCornerShape(15.dp),
                            modifier = Modifier

                        ) {
                            Icon(
                                painterResource(R.drawable.equal),
                                contentDescription = null,
                                modifier = Modifier.size(40.dp)
                            )
                        }


                    }

                }
            }


        }

    }
}


@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES or Configuration.UI_MODE_TYPE_NORMAL)
@Composable
private fun show() {
    layout()
}

