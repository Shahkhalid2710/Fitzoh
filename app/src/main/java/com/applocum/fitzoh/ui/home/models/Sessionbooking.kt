package com.applocum.fitzoh.ui.home.models

import java.io.Serializable

class Sessionbooking(date:String="",starttime:String="",endtime:String=""):Serializable {
    var id:Int=0
    var sDate=date
    var sStarttime=starttime
    var sEndtime=endtime
}