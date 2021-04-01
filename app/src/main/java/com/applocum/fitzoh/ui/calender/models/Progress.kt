package com.applocum.fitzoh.ui.calender.models

import android.os.Parcelable
import java.io.Serializable

class Progress(height: String? ="", weight: String? ="", bodyfat: String? ="", chest: String? ="", arm: String? ="") :Serializable{
    var uHeight=height
    var uWeight=weight
    var uBodyfat=bodyfat
    var uChest=chest
    var uArm=arm
    var id:Int=0
}