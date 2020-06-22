package com.paddington.webptestactivity

import android.content.Context
import android.os.Build
import androidx.annotation.RequiresApi
import com.bumptech.glide.GlideBuilder
import com.bumptech.glide.annotation.GlideModule
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPoolAdapter
import com.bumptech.glide.load.engine.bitmap_recycle.LruBitmapPool
import com.bumptech.glide.load.engine.bitmap_recycle.SizeConfigStrategy
import com.bumptech.glide.load.engine.cache.MemorySizeCalculator
import com.bumptech.glide.module.AppGlideModule
import java.lang.reflect.InvocationTargetException

@GlideModule
class WebpAppModule : AppGlideModule() {

    override fun applyOptions(context: Context, builder: GlideBuilder) {
        super.applyOptions(context, builder)

        val memorySizeCalculator = MemorySizeCalculator.Builder(context).build()
        val size = memorySizeCalculator.bitmapPoolSize
        val bitmapPool = if (size > 0) {
            val pool = LruBitmapPool(size.toLong())
            fixBitmapPoolStrategy(pool)
            pool
        } else {
            BitmapPoolAdapter()
        }
        builder.setMemorySizeCalculator(memorySizeCalculator)
        builder.setBitmapPool(bitmapPool)
    }

    fun fixBitmapPoolStrategy(bitmapPool: LruBitmapPool): Boolean {
        if (Build.VERSION.SDK_INT < 29) {
            return false
        }
        try {
            val field = bitmapPool.javaClass.getDeclaredField("strategy")
            field.isAccessible = true
            val strategy = field[bitmapPool]
            if (strategy is SizeConfigStrategy) {
                val newStrategy = getDefaultStrategy()
                if (newStrategy != null) {
                    field[bitmapPool] = newStrategy
                    return true
                }
            }
        } catch (e: NoSuchFieldException) {
            e.printStackTrace()
        } catch (e: IllegalAccessException) {
            e.printStackTrace()
        }
        return false
    }

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    private fun getDefaultStrategy(): Any? {
        var clsName = SizeConfigStrategy::class.java.name
        if (Build.VERSION.SDK_INT >= 29) {
            clsName = "com.bumptech.glide.load.engine.bitmap_recycle.AttributeStrategy"
        } else if (Build.VERSION.SDK_INT < Build.VERSION_CODES.KITKAT) {
            clsName = "com.bumptech.glide.load.engine.bitmap_recycle.AttributeStrategy"
        }
        try {
            val clazz = Class.forName(clsName)
            val constructor = clazz.getDeclaredConstructor()
            constructor.isAccessible = true
            return constructor.newInstance()
        } catch (e: ClassNotFoundException) {
            e.printStackTrace()
        } catch (e: NoSuchMethodException) {
            e.printStackTrace()
        } catch (e: IllegalAccessException) {
            e.printStackTrace()
        } catch (e: InstantiationException) {
            e.printStackTrace()
        } catch (e: InvocationTargetException) {
            e.printStackTrace()
        }
        return null
    }
}
