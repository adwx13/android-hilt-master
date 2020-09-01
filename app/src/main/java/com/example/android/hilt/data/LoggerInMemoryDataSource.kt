package com.example.android.hilt.data

import dagger.hilt.android.scopes.ActivityScoped
import java.util.*
import javax.inject.Inject

@ActivityScoped
class LoggerInMemoryDataSource: LoggerDataSource {

//    Memory에 저장만할 정보
    @Inject
    constructor() {

    }

    private val logs = LinkedList<Log>()

    override fun addLog(msg: String) {
        logs.addFirst(Log(msg, System.currentTimeMillis()))
    }

    override fun getAllLogs(callback: (List<Log>) -> Unit) {
        callback(logs)
    }

    override fun removeLogs() {
        logs.clear()
    }

}