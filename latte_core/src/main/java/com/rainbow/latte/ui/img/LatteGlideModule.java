package com.rainbow.latte.ui.img;

import android.content.Context;
import android.support.annotation.NonNull;
import android.util.Log;

import com.bumptech.glide.GlideBuilder;
import com.bumptech.glide.annotation.GlideModule;
import com.bumptech.glide.load.DecodeFormat;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.engine.cache.InternalCacheDiskCacheFactory;
import com.bumptech.glide.load.engine.executor.GlideExecutor;
import com.bumptech.glide.module.AppGlideModule;
import com.bumptech.glide.request.RequestOptions;
import com.rainbow.latte.util.logger.LatteLogger;

import static com.bumptech.glide.load.engine.executor.GlideExecutor.newDiskCacheExecutor;
import static com.bumptech.glide.load.engine.executor.GlideExecutor.newSourceExecutor;

/**
 * Latte-Core
 * Created By Rainbow on 2019/4/30.
 */
@GlideModule
public final class LatteGlideModule extends AppGlideModule {
    @Override
    public void applyOptions(@NonNull Context context, @NonNull GlideBuilder builder) {
        // 配置Glide默认参数
        builder.setDefaultRequestOptions(
                new RequestOptions()
                        .centerCrop()   // 中心裁剪
                        .diskCacheStrategy(DiskCacheStrategy.AUTOMATIC));   // 磁盘缓存策略

        // 自定义缓存目录，磁盘缓存给150M 另外一种设置缓存方式
        builder.setDiskCache(new InternalCacheDiskCacheFactory(context,
                InternalCacheDiskCacheFactory.DEFAULT_DISK_CACHE_DIR, 150 * 1024 * 1024));

        // 配置图片缓存格式 默认格式为8888
        builder.setDefaultRequestOptions(RequestOptions.formatOf(DecodeFormat.PREFER_ARGB_8888));

        // 未捕获异常策略
        final GlideExecutor.UncaughtThrowableStrategy myUncaughtThrowableStrategy = t -> {
            LatteLogger.e("GlideApp", t.getMessage());
        };
        builder.setDiskCacheExecutor(newDiskCacheExecutor(myUncaughtThrowableStrategy));
        builder.setResizeExecutor(newSourceExecutor(myUncaughtThrowableStrategy));

        // Glide 日志等级
        builder.setLogLevel(Log.WARN);
    }
}
