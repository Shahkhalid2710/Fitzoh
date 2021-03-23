package com.applocum.fitzoh.ui.home.models

import java.io.Serializable

class Categories(image:String="", description:String="",video:String=""):Serializable {
    var cImage=image
    var cDescription=description
    var cVideo=video
    var id:Int=0
}