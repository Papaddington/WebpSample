package com.paddington.webptestactivity

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.fragment_demo_single.*

/**
 * <pre>
 *     author : paddington
 *     e-mail : paddington.699@gmail.com
 *     time   : 2020/06/15
 *     desc   :
 *     version: 1.0
 * </pre>
 */
class SampleSingleFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_demo_single, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val ratio = 720 / 1268f

        val url =
            "https://video.billionbottle.com/d6e66dbb883a48f989b1b1d0e035bbbf/image/dynamic/71fcdca947d144b883949bbe368d60c3.gif" + "?x-oss-process=image/resize,w_320/format,webp"

        imgSample.setAspectRatio(ratio)
        imgSample.loadWebp(url)


    }
}