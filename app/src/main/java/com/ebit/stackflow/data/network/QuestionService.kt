package com.ebit.stackflow.data.network

import com.ebit.stackflow.app.Constants.stackKey
import com.ebit.stacks.data.model.Question
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.*
import rx.Observable


interface QuestionService {
    @Headers(
        "Accept: application/json",
        "Content-Type: application/json",
        "Platform: android")
    //@FormUrlEncoded //this is a must for @Field annotations
    @GET("questions") //apiKey + ext
    fun getQuestions(
        @Query("page") page:Int = 1,
        @Query("order") order:String = "DESC",
        @Query("sort") sort:String = "activity",
        @Query("site") site:String = "stackoverflow",
        @Query("key") key: String = stackKey
    ): Observable<Question>

/*    @FormUrlEncoded //this is a must for @Field annotations
    @POST("/2.3/questions?page=1&order=desc&sort=activity&site=stackoverflow") //apiKey + ext
    fun getQuestionsByUser(
        @Field("authorization") authorization: String,
        @Field("user_id") user_id: String,
        @Field("user_token") user_token: String
    ): Observable<Question> */

}