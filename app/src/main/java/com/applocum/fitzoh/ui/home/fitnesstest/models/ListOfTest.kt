package com.applocum.fitzoh.ui.home.fitnesstest.models

import java.io.Serializable

class ListOfTest(name:String="", image: String ="", description:String="",listvideo:String=""):Serializable {

    var id:Int=0
    var Listname=name
    var Listimage=image
    var Listdescription=description
    var Listvideo=listvideo
}