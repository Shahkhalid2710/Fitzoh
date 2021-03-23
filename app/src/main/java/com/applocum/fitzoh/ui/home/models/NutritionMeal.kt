package com.applocum.fitzoh.ui.home.models

import java.io.Serializable

class NutritionMeal(name:String="",time:String=""):Serializable {
    var id:Int=0
    var nName=name
    var nTime=time
}