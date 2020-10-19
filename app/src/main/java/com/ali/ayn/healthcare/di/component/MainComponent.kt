package com.ali.ayn.healthcare.di.component

import com.ali.ayn.healthcare.activity.bmiCalculator.BMICalculatorActivity
import com.ali.ayn.healthcare.activity.bmiResult.BMIResultActivity
import com.ali.ayn.healthcare.activity.bmiSaved.BmiSavedActivity
import com.ali.ayn.healthcare.activity.heightCalculator.HeightCalculatorActivity
import com.ali.ayn.healthcare.activity.heightResult.HeightResultActivity
import com.ali.ayn.healthcare.activity.main.MainActivity
import com.ali.ayn.healthcare.di.module.ContextModule
import dagger.Component

@Component(modules = [ContextModule::class])
interface MainComponent {

    fun inject(mainActivity: MainActivity)

    fun inject(bmiCalculatorActivity: BMICalculatorActivity)

    fun inject(bmiResultActivity: BMIResultActivity)

    fun inject(heightCalculatorActivity: HeightCalculatorActivity)

    fun inject(heightResultActivity: HeightResultActivity)

    fun inject(bmiSavedActivity: BmiSavedActivity)
}