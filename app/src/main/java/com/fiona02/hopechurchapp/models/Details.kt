package com.fiona02.hopechurchapp.models

class Details {
    var name:String=""
    var phonenumber:String=""
    var type:String=""
    var date:String=""
    var time:String=""
    var id:String=""

    constructor(name:String,phonenumber:String,type:String,date:String,time:String,id:String){
        this.name=name
        this.phonenumber=phonenumber
        this.type=type
        this.date=date
        this.time=time
        this.id=id
    }
    constructor()
}