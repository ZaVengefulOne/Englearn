package com.example.englearn.data.DI

import android.os.Bundle
import android.os.PersistableBundle
import androidx.appcompat.app.AppCompatActivity
import javax.inject.Inject

class CalculatorActivity: AppCompatActivity() {
    @Inject lateinit var sumUseCase: SumUseCase

    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?)
    {
        super.onCreate(savedInstanceState, persistentState)
//        DaggerCalculatorComponent.builder().build()
//            .inject(this)
    }
}