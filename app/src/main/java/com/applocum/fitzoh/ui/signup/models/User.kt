package com.applocum.fitzoh.ui.signup.models

import java.io.Serializable

class User(var name :String?="",var email:String?="",
           var no:String?="",var dob:String?="",
           var gender:String?="",var height:String?="",
           var weight:String?="",
           var dailyactivity:String?="",
           var mealtype:String?="",
           var currentbodyfat:String?=""): Serializable {

    var id:Int=0
    var userName=name
    var userEmail=email
    var userMobileNumber=no
    var userDOB=dob
    var userGender=gender
    var userHeight=height
    var userWeight=weight
    var userdDailyActivity=dailyactivity
    var userMealType=mealtype
    var userCurrentBodyFat=currentbodyfat

}