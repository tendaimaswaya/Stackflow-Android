package com.ebit.stacks.data.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import java.util.ArrayList

data class Question(
    val answer_count: Int,
    val content_license: String,
    val creation_date: Int,
    val is_answered: Boolean,
    val last_activity_date: Int,
    val link: String,
    val owner: Owner,
    val question_id: Int,
    val score: Int,
    val tags: List<String>,
    val title: String,
    val view_count: Int
){
    @SerializedName("items")
    @Expose
    var questions: List<Question> = ArrayList()

    @SerializedName("hasMore")
    @Expose
    var hasMore: Boolean = false
}