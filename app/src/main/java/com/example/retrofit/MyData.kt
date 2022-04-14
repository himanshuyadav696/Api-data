package com.example.retrofit

class MyData : ArrayList<MyData.MyDataItem>(){
    data class MyDataItem(
        val id: Int,
        val name: String,
        val profileImage: String,
        val qualification: List<String>,
        val subjects: List<String>
    )
}