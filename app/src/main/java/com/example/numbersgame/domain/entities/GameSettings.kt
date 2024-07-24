package com.example.numbersgame.domain.entities

data class GameSettings(
    val maxSumValue : Int,
    val minCountOfRightAnswers : Int,
    val minPercentOfRightAnswers : Int,
    val gameTimeSeconds : Int
)