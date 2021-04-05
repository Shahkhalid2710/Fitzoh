package com.applocum.fitzoh.ui.home.nutrition.models

import java.io.Serializable

class NutritionMeal(name:String="",time:String="",food:String="",noserving:String="",servingsize:String=""):Serializable {
    var id:Int=0
    var nName=name
    var nTime=time
    var nFood=food
    var nNoofserving=noserving
    var nServingsize=servingsize
}