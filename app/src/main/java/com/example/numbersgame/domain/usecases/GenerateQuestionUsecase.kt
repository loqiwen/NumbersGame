package com.example.numbersgame.domain.usecases

import com.example.numbersgame.domain.entities.GameSettings
import com.example.numbersgame.domain.entities.Question
import com.example.numbersgame.domain.repository.GameRepository

class GenerateQuestionUsecase(
    private val repository: GameRepository
) {

    operator fun invoke(maxSumValue: Int): Question {
        return repository.generateQuestion(maxSumValue, COUNT_OF_OPTIONS)
    }

    private companion object {
        private const val COUNT_OF_OPTIONS = 6
    }
}