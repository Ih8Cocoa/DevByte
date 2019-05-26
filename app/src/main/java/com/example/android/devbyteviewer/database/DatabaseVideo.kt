package com.example.android.devbyteviewer.database

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.android.devbyteviewer.network.NetworkVideo

@Entity
data class DatabaseVideo(
        @PrimaryKey
        val url: String,
        val updated: String,
        val title: String,
        val description: String,
        val thumbnail: String
) {
    constructor(netVideo: NetworkVideo) : this(
            netVideo.url, netVideo.updated, netVideo.title,
            netVideo.description, netVideo.thumbnail
    )
}