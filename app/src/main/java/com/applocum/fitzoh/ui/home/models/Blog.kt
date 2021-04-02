package com.applocum.fitzoh.ui.home.models

import java.io.Serializable

class Blog(image: String ="", level:String="", description:String="",video:String="") :Serializable{
    var bImage=image
    var bLevel=level
    var bDescription=description
    var bVideo=video
    var id:Int=0

}