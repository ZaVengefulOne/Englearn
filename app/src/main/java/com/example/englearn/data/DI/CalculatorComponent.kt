package com.example.englearn.data.DI
import com.example.englearn.data.DI.CalculatorActivity
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [CalculatorModule::class])
interface CalculatorComponent {

    fun inject(calculatorActivity: CalculatorActivity)

}