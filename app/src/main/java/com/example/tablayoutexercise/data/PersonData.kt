package com.example.tablayoutexercise.data

import com.example.tablayoutexercise.R

object PersonData {

    fun getImage() : List<PersonModel> = listOf(
        PersonModel(R.drawable.person1),
        PersonModel(R.drawable.person2),
        PersonModel(R.drawable.person3),
        PersonModel(R.drawable.person4),
        PersonModel(R.drawable.person5),
    )
}