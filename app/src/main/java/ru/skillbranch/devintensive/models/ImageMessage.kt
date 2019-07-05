package ru.skillbranch.devintensive.models

import ru.skillbranch.devintensive.extensions.humanizeDiff
import java.util.*

/**
 *  Created by Mason_Ivan on 05.07.2019
 */

class ImageMessage (
    id:String,
    from:User?,
    chat:Chat,
    isIncoming: Boolean = false,
    date: Date = Date(),
    var image: String?

) : BaseMessage(id, from, chat, isIncoming, date) {
    override fun formatMessage(): String = "id:$id ${from?.firstName} " +
            "${if (isIncoming) "получил" else "отправил"} изображение \"$image\" ${date.humanizeDiff()}"
}