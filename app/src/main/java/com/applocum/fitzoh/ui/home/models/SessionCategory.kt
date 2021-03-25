package com.applocum.fitzoh.ui.home.models

import java.io.Serializable

class SessionCategory(image:String="",name:String="",status:Int=0):Serializable {
    var sImage=image
    var sName=name
    var sStatus=status
    var id:Int=0
}