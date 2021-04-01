package com.applocum.fitzoh.ui.calender.models

import java.io.Serializable

class SessionDay(
    sessionname:String="",
    image: Int =0,
    sessiontitle:String="",
    trainername:String="",
    time1:String="",
    time2:String="",
    time3:String=""):Serializable {
    var sSessionname=sessionname
    var simage=image
    var sSessiontilte=sessiontitle
    var sTrainername=trainername
    var sTime1=time1
    var sTime2=time2
    var sTime3=time3

}