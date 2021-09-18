package com.ebit.stackflow

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.ebit.stackflow.data.model.NetworkStatus
import com.ebit.stackflow.data.model.ResponseState
import com.ebit.stackflow.data.repository.QuestionRepository
import com.ebit.stacks.data.model.Question
import rx.Observable
import rx.android.schedulers.AndroidSchedulers

class MainViewModel(private val repo: QuestionRepository) : ViewModel(){

        private val _responseState = MutableLiveData<ResponseState<List<Question>>>()
        val responseState: LiveData<ResponseState<List<Question>>>
            get() = _responseState

        init {
            fetchData()
        }

        private fun fetchData() {
            _responseState.value = ResponseState(status = NetworkStatus.LOADING)
            repo.getAllQuestions().map {
                it.questions
            }.flatMap { items ->  Observable.just(items) }
                .onErrorResumeNext { throwable -> Observable.just(null) }
                .observeOn(AndroidSchedulers.mainThread())
                .doOnTerminate {
                    //_responseState.value = ResponseState(status = NetworkStatus.TERMINATED)
                }
                .subscribe({
                     _responseState.value = ResponseState(data = it, status = NetworkStatus.SUCCESS)
                 }, {
                     _responseState.value = ResponseState(status = NetworkStatus.FAILED, error = it.message)
                 })
        }


}