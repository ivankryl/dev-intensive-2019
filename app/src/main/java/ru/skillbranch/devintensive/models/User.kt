package ru.skillbranch.devintensive.models

import java.util.*

/**
 *  Created by Mason_Ivan on 01.07.2019
 */
class User (
    val id: String,
    var firstName: String?,
    var lastName: String?,
    var avatar: String?,
    var rating: Int = 0,
    var respect: Int = 0,
    val lastVisit: Date? = null,
    val isOnline: Boolean = false

) {

    constructor(id: String, firstName: String?, lastName: String?) : this (
        id = id,
        firstName = firstName,
        lastName = lastName,
        avatar = null
    )

        constructor(id:String) : this(id, "John", "Doe" )

    init {

        println("It's Alive!!! \n" +
                "${if(lastName==="Doe") "His name is $firstName $lastName" else "And his name is $firstName $lastName!!!"} \n" )
    }


    companion object Factory{
        private var lastId : Int = -1
        fun makeUser (fullname:String?) : User{
            lastId++

            var parts : List<String>? = fullname?.split(" ")

            var firstName = parts?.getOrNull(0) ?: ""
            var lastName = parts?.getOrNull(1) ?: "unknown"

            return User(id = "$lastId", firstName = firstName, lastName = lastName)
        }
    }

}
