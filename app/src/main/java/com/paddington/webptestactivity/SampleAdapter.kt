package com.paddington.webptestactivity

import android.graphics.Bitmap
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.integration.webp.decoder.WebpDrawable
import com.bumptech.glide.integration.webp.decoder.WebpDrawableTransformation
import com.bumptech.glide.load.Transformation
import com.bumptech.glide.load.resource.bitmap.CenterCrop
import com.bumptech.glide.request.RequestOptions
import com.chad.library.adapter.base.BaseMultiItemQuickAdapter
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.BaseViewHolder
import kotlinx.android.synthetic.main.item_sample.view.*

/**
 * <pre>
 *     author : paddington
 *     e-mail : paddington.699@gmail.com
 *     time   : 2020/06/13
 *     desc   :
 *     version: 1.0
 * </pre>
 */

class SampleAdapter(private var urlList: MutableList<TestBean> = mutableListOf()) :
    BaseMultiItemQuickAdapter<TestBean, BaseViewHolder>(urlList) {

    init {
        addItemType(1, R.layout.item_sample)
    }

    override fun convert(holder: BaseViewHolder, item: TestBean) {
        // calculate the ratio
        val ratio = getWithAndHeight(item.url)
        with(holder.itemView) {
            ivSample.setAspectRatio(1 / ratio)
            if (item.isGif()) {
                ivSample.loadWebp(item.gifUrl + "?x-oss-process=image/resize,w_320/format,webp")
            } else {
                ivSample.load(item.url + "?x-oss-process=image/resize,w_320/format,webp")
            }
            ivSample.scaleType = ImageView.ScaleType.CENTER_CROP
        }
    }
}