package com.example.android.devbyteviewer.work

import android.content.Context
import androidx.work.CoroutineWorker
import androidx.work.WorkerParameters
import com.example.android.devbyteviewer.database.VideoDb
import com.example.android.devbyteviewer.repository.VideoRepository
import retrofit2.HttpException

class RefreshDataWorker(appContext: Context, params: WorkerParameters)
    : CoroutineWorker(appContext, params) {
    companion object {
        const val WORK_NAME = "RefreshDataWorker"
    }
    override suspend fun doWork(): Payload {
        val database = VideoDb.getDb(applicationContext)
        val repo = VideoRepository(database)

        return try {
            repo.refreshVideos()
            Payload(Result.SUCCESS)
        } catch (e: HttpException) {
            Payload(Result.RETRY)
        }
    }
}
