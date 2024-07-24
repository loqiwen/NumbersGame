package com.example.numbersgame.data

import com.example.numbersgame.domain.entities.GameSettings
import com.example.numbersgame.domain.entities.Level
import com.example.numbersgame.domain.entities.Question
import com.example.numbersgame.domain.repository.GameRepository
import kotlin.math.max
import kotlin.math.min
import kotlin.random.Random

object GameRepositoryImpl : GameRepository {

    private const val MIN_SUM_VALUE = 2
    private const val MIN_ANSWER_VALUE = 1

    override fun generateQuestion(maxSumValue: Int, countOfOptions: Int): Question {
        val sum = Random.nextInt(MIN_SUM_VALUE, maxSumValue + 1)
        val visibleNumber = Random.nextInt(MIN_ANSWER_VALUE, sum)
        val options = HashSet<Int>()
        val rightAnswer = sum - visibleNumber
        options.add(rightAnswer)
        val from = max(rightAnswer - countOfOptions, MIN_ANSWER_VALUE)
        val until = min(maxSumValue, rightAnswer + countOfOptions)
        for (i in 0..<countOfOptions) {
            val notRightAnswer = Random.nextInt(from, until)
            options.add(notRightAnswer)
        }
        val question = Question(
            sum = sum,
            visibleNumber = visibleNumber,
            options = options.toList()
        )

        return question
    }

    override fun getGameSettings(level: Level): GameSettings {
        return when (level) {
            Level.TEST -> GameSettings(
                10,
                3,
                50,
                10
            )

            Level.EASY -> GameSettings(
                10,
                10,
                70,
                60
            )

            Level.NORMAL -> GameSettings(
                20,
                20,
                80,
                40
            )

            Level.HARD -> GameSettings(
                30,
                30,
                90,
                40
            )
        }
    }
}