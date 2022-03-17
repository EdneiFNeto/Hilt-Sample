package com.example.hilt.util

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class LauncherUtil<T>(
    private val inprogress: () -> T,
    private val finish: (t: T?) -> Unit
) {

    private var t: T? = null
    private var scope: CoroutineScope = CoroutineScope(Dispatchers.IO)

    fun execute() {
        scope.launch {
            t = inprogress()
            withContext(Dispatchers.Main) {
                finish(t)
            }
        }
    }
}