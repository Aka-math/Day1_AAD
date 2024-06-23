package com.example.myapplication.network

import com.squareup.moshi.Json
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

//serialization -- deflate big baloon carry it.. deserialzation- inflate it back
//autocad- no cd , floppy drive-- 1.44MB, mark sl no 1,2..
//java obj into storeable format file

//work breakdown structure -- tasks -- independently testable, discreet, small

//@Serializable
data class MarsPhoto(
    val id: String,
    @Json(name = "img_src")
    //@SerialName(value = "img_src")
    val imgSrc: String
)
