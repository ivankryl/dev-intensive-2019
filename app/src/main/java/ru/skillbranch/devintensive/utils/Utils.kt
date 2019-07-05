package ru.skillbranch.devintensive.utils

import android.provider.ContactsContract

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

    fun transliteration(payload: String, divider: String = " "): String {
        var nickname = payload.replace(Regex("[абвгдеёжзийклмнопрстуфхцчшщъыьэюя АБВГДЕЁЖЗИЙКЛМНОПРСТУФХЦЧШЩЪЫЬЭЮЯ]")) {
            when (it.value) {
                "а" -> "a"
                "б" -> "b"
                "в" -> "v"
                "г" -> "g"
                "д" -> "d"
                "е" -> "e"
                "ё" -> "e"
                "ж" -> "zh"
                "з" -> "z"
                "и" -> "i"
                "й" -> "i"
                "к" -> "k"
                "л" -> "l"
                "м" -> "m"
                "н" -> "n"
                "о" -> "o"
                "п" -> "p"
                "р" -> "r"
                "с" -> "s"
                "т" -> "t"
                "у" -> "u"
                "ф" -> "f"
                "х" -> "h"
                "ц" -> "c"
                "ч" -> "ch"
                "ш" -> "sh"
                "щ" -> "sh"
                "ъ" -> ""
                "ы" -> "i"
                "ь" -> ""
                "э" -> "e"
                "ю" -> "yu"
                "я" -> "ya"
                " " -> "_"
                "А" -> "A"
                "Б" -> "B"
                "В" -> "V"
                "Г" -> "G"
                "Д" -> "D"
                "Е" -> "E"
                "Ё" -> "E"
                "Ж" -> "ZH"
                "З" -> "Z"
                "И" -> "I"
                "Й" -> "I"
                "К" -> "K"
                "Л" -> "L"
                "М" -> "M"
                "Н" -> "N"
                "О" -> "O"
                "П" -> "P"
                "Р" -> "R"
                "С" -> "S"
                "Т" -> "T"
                "У" -> "U"
                "Ф" -> "F"
                "Х" -> "H"
                "Ц" -> "C"
                "Ч" -> "CH"
                "Ш" -> "SH"
                "Щ" -> "SH"
                "Ъ" -> ""
                "Ы" -> "I"
                "Ь" -> ""
                "Э" -> "E"
                "Ю" -> "YU"
                "Я" -> "YA"
                else -> it.value
            }
        }

        return nickname
    }

    fun toInitials(firstName: String?, lastName: String?): String? {
        var fName:String = if (firstName != null) firstName else "Null"
        val fN = fName[0]
        var lName = if (lastName != null) lastName else "Null"
        val lN = lName[0]
        var initials:String = "$fN$lN"

        return initials
    }
}