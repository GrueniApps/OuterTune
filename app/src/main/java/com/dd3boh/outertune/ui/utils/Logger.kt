package de.grueniapps.androidutils.utils

import android.util.Log

fun <T> logCat(message: T,tag: Any = "!!!-Logger-!!!"): T{
    val stackTraceElement = Thread.currentThread().stackTrace[4]
    val fileName = stackTraceElement.fileName
    val lineNumber = stackTraceElement.lineNumber
    val transformedMessage = "$message\n   at $fileName:$lineNumber"
    Log.i(tag.toString(),transformedMessage)
    return message
}