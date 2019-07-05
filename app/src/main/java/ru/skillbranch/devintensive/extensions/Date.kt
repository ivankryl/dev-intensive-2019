package ru.skillbranch.devintensive.extensions

import ru.skillbranch.devintensive.models.User
import java.lang.IllegalStateException
import java.text.SimpleDateFormat
import java.util.*

/**
 *  Created by Mason_Ivan on 03.07.2019
 */
const val SECOND = 1000L
const val MINUTE = 60 * SECOND
const val HOUR = 60 * MINUTE
const val DAY = 24 * HOUR

fun Date.format(pattern:String="HH:mm:ss dd.MM.yy"):String {
    val dateFormat = SimpleDateFormat(pattern, Locale("ru"))
    return dateFormat.format(this)
}

fun Date.add(value:Int, units: TimeUnits = TimeUnits.SECOND) : Date {
    var time = this.time

    time +=when (units) {
        TimeUnits.SECOND-> value* SECOND
        TimeUnits.MINUTE-> value* MINUTE
        TimeUnits.HOUR-> value* HOUR
        TimeUnits.DAY-> value* DAY
    }
    this.time = time
    return this
}

enum class TimeUnits{
    SECOND,
    MINUTE,
    HOUR,
    DAY
}

fun Date.humanizeDiff(date:Date = Date()): String {

    var interVal = ""

    //
    var intVal= (date.time-this.time)/1000L

    // считаем сколько минут/часов/дней
    var intMinute = intVal/60
    var intHour= intVal/3600
    var intDay = intVal/86400

    // определяем окончание
    var endDay =""
    var endHour =""
    var endMinute =""

    when {
        intDay <= 0 -> endDay =""
        intDay <= 1 -> endDay ="день"
        intDay <= 4 -> endDay ="дня"
        intDay <= 20 -> endDay ="дней"
        intDay <= 100 -> when {
            intDay%10 <= 0 -> endDay ="дней"
            intDay%10 <= 1 -> endDay ="день"
            intDay%10 <= 4 -> endDay ="дня"
            else -> endDay ="дней"
        }
        intDay <= 101 -> endDay ="день"
        intDay <= 104 -> endDay ="дня"
        intDay <= 120 -> endDay ="дней"
        intDay <= 200 -> when {
            intDay%10 <= 0 -> endDay ="дней"
            intDay%10 <= 1 -> endDay ="день"
            intDay%10 <= 4 -> endDay ="дня"
            else -> endDay ="дней"
        }
        intDay <= 201 -> endDay ="день"
        intDay <= 204 -> endDay ="дня"
        intDay <= 220 -> endDay ="дней"
        intDay <= 300 -> when {
            intDay%10 <= 0 -> endDay ="дней"
            intDay%10 <= 1 -> endDay ="день"
            intDay%10 <= 4 -> endDay ="дня"
            else -> endDay ="дней"
        }
        intDay <= 301 -> endDay ="день"
        intDay <= 304 -> endDay ="дня"
        intDay <= 320 -> endDay ="дней"
        intDay <= 400 -> when {
            intDay%10 <= 0 -> endDay ="дней"
            intDay%10 <= 1 -> endDay ="день"
            intDay%10 <= 4 -> endDay ="дня"
            else -> endDay ="дней"
        }
        else -> endDay = "дней"
    }

    when {
        intHour <= 0 -> endHour = ""
        intHour <= 1 -> endHour = "час"
        intHour <= 4 -> endHour = "часа"
        intHour <= 20 -> endHour = "часов"
        intHour <= 100 -> when {
            intHour % 10 <= 0 -> endHour = "часов"
            intHour % 10 <= 1 -> endHour = "час"
            intHour % 10 <= 4 -> endHour = "часа"
            else -> endHour = "часов"
        }
        else -> endHour = "часов"
    }

    when {
        intMinute <= 0 -> endMinute = ""
        intMinute <= 1 -> endMinute = "у"
        intMinute <= 4 -> endMinute = "ы"
        intMinute <= 20 -> endMinute = ""
        intMinute <= 100 -> when {
            intMinute % 10 <= 0 -> endMinute = ""
            intMinute % 10 <= 1 -> endMinute = "у"
            intMinute % 10 <= 4 -> endMinute = "ы"
            else -> endMinute = ""
        }
        else -> endMinute = ""
    }


    // определяем ответ
    when  {
        intVal <= 1 -> interVal = "только что "
        intVal <= 45 -> interVal = "несколько секунд назад"
        intVal <= 75 -> interVal = "минуту назад"
        intVal <= 2700 -> interVal = "$intMinute минут$endMinute назад"
        intVal <= 4500 -> interVal = "час назад"
        intVal <= 79200 -> interVal = "$intHour $endHour назад"
        intVal <= 93600 -> interVal = "день назад"
        intVal <= 31104000 -> interVal = "$intDay $endDay назад"
        else -> interVal = "более года назад"
    }



    return interVal
}

