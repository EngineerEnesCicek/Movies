package com.example.movie.core.functions

import com.example.movie.data.entitiy.Genre
import com.example.movie.data.entitiy.KeywordModel


fun setString(textt:String):String{
    return textt.substring(0,1).uppercase()+textt.substring(1).lowercase()
}
fun getGenres(genreList:ArrayList<Genre>):String{
    var genres=""
    genreList.forEach{
        genres+=" ${it.name}"
    }
    return genres
}
fun getKeywords(keywordsList: ArrayList<KeywordModel>):String{
    var keywords=""
    keywordsList.forEach{
        keywords+=" ${it.name?.let { it1 -> setString(it1) }}"
    }
    return keywords
}
fun getGender(number:Int):String{
    return if (number==2){
        "MALE"
    }else{
        "FEMALE"
    }
}
