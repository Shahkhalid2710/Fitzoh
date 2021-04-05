package com.applocum.fitzoh.ui.home.fitnesstest.models

import java.io.Serializable

class FitnessTest(date:String="",time:String="",result:String="",comment:String="") :Serializable{

    var fTime=time
    var fResult=result
    var fComment=comment
    var fDate=date
    var id:Int=0
}