package com.applocum.fitzoh.ui.home.createcalender.models

import java.io.Serializable

class Sessionbooking(
    date:String="",
    starttime:String="",
    endtime:String="",
    time:String =""):Serializable {
    var id:Int=0
    var sDate=date
    var sStarttime=starttime
    var sEndtime=endtime
    var sTime=time
}