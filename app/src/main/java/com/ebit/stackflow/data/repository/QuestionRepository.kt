package com.ebit.stackflow.data.repository

import com.ebit.stackflow.data.network.QuestionService

class QuestionRepository(private val api: QuestionService) {
        fun getAllQuestions(page:Int = 1) = api.getQuestions(page = page)
}