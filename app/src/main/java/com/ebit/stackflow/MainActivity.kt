package com.ebit.stackflow

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.ebit.stackflow.app.BaseActivity
import com.ebit.stackflow.data.model.NetworkStatus
import org.koin.androidx.viewmodel.ext.android.viewModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivity() {
    private val viewModel by viewModel<MainViewModel>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewModel.responseState.observe(this,  {
            when(it.status){
                NetworkStatus.LOADING ->{
                    alert("loading")
                }
                NetworkStatus.SUCCESS ->{
                    alert(it.data?.size)
                }
                NetworkStatus.FAILED ->{
                    alert("failed because: ${it.error}")
                }
            }
        })
    }
}