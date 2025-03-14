package de.grueniapps.androidutils.utils

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
private const val defaultIgnoreDelay = 400
class MonkeyClicker(
    var ignoreDelay: Int = defaultIgnoreDelay
){
    private var lastEventTimestamp = 0L
    private val now: Long
        get() = System.currentTimeMillis()
    private val elapsedTime: Long
        get() = now-lastEventTimestamp
    fun processEvent(
        onIgnoredClick: (remainingDelay: Int)->Unit = {},
        onClick: ()->Unit
    ){
        if (elapsedTime>ignoreDelay){
            lastEventTimestamp = now
            onClick()
        }else{
            onIgnoredClick((ignoreDelay-elapsedTime).toInt())
        }
    }

}

@Composable
fun rememberMonkeyClicker(ignoreDelay: Int = defaultIgnoreDelay):MonkeyClicker{
    return remember {
        MonkeyClicker(ignoreDelay)
    }
}
