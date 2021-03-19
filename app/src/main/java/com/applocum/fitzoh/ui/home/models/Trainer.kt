package com.applocum.fitzoh.ui.home.models

import java.io.Serializable

class Trainer(name:String="",image:String="",experience:String="",language:String="",about:String="",sessions:String="") :Serializable {

    var id:Int=0
    var trainername=name
    var trainerimage=image
    var trainerexperince=experience
    var trainerlanguage=language
    var trainerabout=about
    var trainersessions=sessions

}