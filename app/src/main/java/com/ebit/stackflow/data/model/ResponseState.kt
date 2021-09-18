package com.ebit.stackflow.data.model

data class  ResponseState <T> (var data:T?=null,
                               var status:NetworkStatus = NetworkStatus.FAILED,
                               var error:String? = null)

enum class NetworkStatus { LOADING, SUCCESS, FAILED }