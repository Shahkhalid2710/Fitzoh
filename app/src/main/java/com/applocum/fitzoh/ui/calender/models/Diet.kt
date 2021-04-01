package com.applocum.fitzoh.ui.calender.models

import java.io.Serializable

class Diet(timename:String="",item1:String="",no1:String="",status1:Int=0,item2:String="",no2:String="",status2:Int=0):Serializable {
    var dItem1=item1
    var dItem2=item2
    var dNo1=no1
    var dNo2=no2
    var dStatus1=status1
    var dStatus2=status2
    var dTimename=timename
    var id:Int=0

}