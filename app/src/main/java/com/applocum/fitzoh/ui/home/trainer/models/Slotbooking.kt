package com.applocum.fitzoh.ui.home.trainer.models

import java.io.Serializable

class Slotbooking(date:String="",starttime:String="",endtime:String="",time:String="") :Serializable {
    var id:Int=0
    var slotdate=date
    var slotstarttime=starttime
    var slotendtime=endtime
    var sTime=time
}