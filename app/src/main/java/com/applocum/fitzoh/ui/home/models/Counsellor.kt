package com.applocum.fitzoh.ui.home.models

import java.io.Serializable

class Counsellor(name:String="",image:String="",experience:String="",language:String="",about:String="",price:String=""):Serializable {

    var id:Int=0
    var counsellorname=name
    var counsellorimage=image
    var counsellorexperience=experience
    var counsellorlanguage=language
    var counsellorabout=about
    var counsellorprice=price
}