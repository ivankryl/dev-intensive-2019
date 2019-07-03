package ru.skillbranch.devintensive.utils

/**
 *  Created by Mason_Ivan on 03.07.2019
 */
object Utils {
    fun parseFullName (fullName:String?) :Pair<String?, String?>{

        var parts : List<String>? = fullName?.split(" ")

        var firstName = parts?.getOrNull(0) ?: "null"
        var lastName = parts?.getOrNull(1) ?: "null"

        if (firstName == "") firstName = "null"
        if (lastName == "") lastName = "null"

//        return Pair(firstName, lastName)
        return firstName to lastName
    }
}