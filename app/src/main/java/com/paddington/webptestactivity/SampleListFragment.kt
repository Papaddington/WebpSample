package com.paddington.webptestactivity

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import kotlinx.android.synthetic.main.fragment_sample.*
import java.lang.reflect.Type

/**
 * <pre>
 *     author : paddington
 *     e-mail : paddington.699@gmail.com
 *     time   : 2020/06/14
 *     desc   :
 *     version: 1.0
 * </pre>
 */
class SampleListFragment :Fragment() {
    private lateinit var mAdapter: SampleAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_sample, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        mAdapter = SampleAdapter()

        recyclerView.apply {
            layoutManager = StaggeredGridLayoutManager(2, RecyclerView.VERTICAL)
            adapter = mAdapter
            mAdapter.setPreLoadNumber(12)
        }

        //Test
        val json = Utils.getJson(requireContext(), "test.json")
        val gson = Gson()
        val type: Type = object : TypeToken<ArrayList<TestBean>>() {}.type
        val list: List<TestBean> = gson.fromJson(json, type)

        mAdapter.setNewData(list)
    }
}