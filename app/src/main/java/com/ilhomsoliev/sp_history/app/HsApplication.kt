package com.ilhomsoliev.sp_history.app

import android.app.Application
import coil.ImageLoader
import coil.ImageLoaderFactory
import coil.disk.DiskCache
import coil.memory.MemoryCache


class HsApplication : Application(), ImageLoaderFactory {
    override fun newImageLoader() = ImageLoader
        .Builder(this)
        .respectCacheHeaders(false)
        .diskCache {
            DiskCache.Builder()
                .directory(
                    this.cacheDir.resolve(
                        "image_cache"
                    )
                )
                .maxSizePercent(0.25)
                .build()
        }
        .memoryCache {
            MemoryCache.Builder(this)
                .maxSizePercent(0.25)
                .build()
        }
        .build()

}