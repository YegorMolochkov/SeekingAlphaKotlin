package com.yegor.seekingalpha.seekingalpha

import android.app.Application
import com.squareup.picasso.OkHttpDownloader
import com.squareup.picasso.Picasso


class ApplicationSingletonKotlin : Application() {

    private val CACHE_SIZE = 250000000L

    override fun onCreate() {
        super.onCreate()
        val picasso = Picasso.Builder(this).downloader(OkHttpDownloader(cacheDir, CACHE_SIZE)).build()
        picasso.setIndicatorsEnabled(true)
        Picasso.setSingletonInstance(picasso)
    }
}