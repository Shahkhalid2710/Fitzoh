package com.applocum.fitzoh.ui.home.models

import java.io.Serializable

class CategoryRaw(name:String="",var list: ArrayList<Categories> =ArrayList()) :Serializable{
    var cName=name
    var mylist=list
    var id:Int=0

}