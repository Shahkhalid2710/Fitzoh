package com.applocum.fitzoh.ui.home.models

import java.io.Serializable

class FitnessTest(time:String="",result:String="",comment:String="") :Serializable{

    var fTime=time
    var fResult=result
    var fComment=comment
    var id:Int=0

}