package com.paddington.webptestactivity

import android.graphics.Bitmap
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.integration.webp.decoder.WebpDrawable
import com.bumptech.glide.integration.webp.decoder.WebpDrawableTransformation
import com.bumptech.glide.load.Transformation
import com.bumptech.glide.load.resource.bitmap.CenterCrop
import com.bumptech.glide.request.RequestOptions

/**
 * <pre>
 *     author : paddington
 *     e-mail : paddington.699@gmail.com
 *     time   : 2020/06/15
 *     desc   :
 *     version: 1.0
 * </pre>
 */

fun ImageView.loadWebp(url: String) {
    val centerCrop: Transformation<Bitmap> = CenterCrop()
    Glide.with(context)
        .load(url)
        .optionalTransform(centerCrop)
        .optionalTransform(WebpDrawable::class.java, WebpDrawableTransformation(centerCrop))
        .apply(RequestOptions())
        .into(this)
}

fun ImageView.load(url: String) {
    Glide.with(context)
        .load(url)
        .apply(RequestOptions())
        .into(this)
}