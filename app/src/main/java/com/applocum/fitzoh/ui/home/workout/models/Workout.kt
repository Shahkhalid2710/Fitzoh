package com.applocum.fitzoh.ui.home.workout.models

import java.io.Serializable

class Workout(name:String="", about:String="", image: String ="", video:String="",status:Int =0):Serializable {

    var wName=name
    var wAbout=about
    var wImage=image
    var wVideo=video
    var wStatus=status
    var id:Int=0

}