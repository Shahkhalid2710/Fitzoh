package com.applocum.fitzoh.ui.home.models

import java.io.Serializable

class CategoryRaw(name:String,list: ArrayList<Categories>) :Serializable{
    var cName=name
    var mylist=list

}