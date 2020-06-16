package com.paddington.webptestactivity

import com.chad.library.adapter.base.entity.MultiItemEntity
import com.google.gson.annotations.SerializedName

/**
 * <pre>
 *     author : paddington
 *     e-mail : paddington.699@gmail.com
 *     time   : 2020/06/13
 *     desc   :
 *     version: 1.0
 * </pre>
 */
data class TestBean(
    @SerializedName("wineArticleImageUrl")
    val url: String,
    @SerializedName("summaryUrl")
    val gifUrl: String = ""
) : MultiItemEntity {
    fun isGif(): Boolean {
        return gifUrl.isNotEmpty()
    }

    override fun getItemType(): Int {
        return 1
    }
}
