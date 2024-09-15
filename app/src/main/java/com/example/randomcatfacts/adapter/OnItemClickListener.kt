package com.example.randomcatfacts.adapter

interface OnItemClickListener {
    fun onButtonClick(imageUrl: String, fact: String, currentState: Boolean)
}