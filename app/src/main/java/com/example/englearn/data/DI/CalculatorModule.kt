package com.example.englearn.data.DI

import com.example.englearn.data.DI.SumUseCase
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
interface CalculatorModule {
    @Provides
    @Singleton
    fun sumUseCase(): SumUseCase = SumUseCase()
}