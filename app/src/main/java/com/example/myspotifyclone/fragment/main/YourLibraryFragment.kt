package com.example.myspotifyclone.fragment.main

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.myspotifyclone.R
import com.example.myspotifyclone.adapters.YourLibraryAdapter
import com.example.myspotifyclone.databinding.FragmentYourLibraryBinding
import com.example.myspotifyclone.models.YourLibrary


class YourLibraryFragment : Fragment() {

    private val binding by viewBinding(FragmentYourLibraryBinding::bind)
    private val TAG = this::class.java.simpleName

    private val yourLibraryAdapter by lazy { YourLibraryAdapter() }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViews()
    }

    private fun initViews() {
        val st = StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)
        binding.rvYourLibrary.layoutManager = st
        binding.rvYourLibrary.adapter = yourLibraryAdapter
        yourLibraryAdapter.submitList(getYourLibrary())
    }

    private fun getYourLibrary(): ArrayList<YourLibrary> {
        var item: ArrayList<YourLibrary> = ArrayList()

        item.add(
            YourLibrary(
                "https://images.unsplash.com/photo-1656191341869-b7601af5dc06?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=387&q=80",
                "Street Photography"
            )
        )
        item.add(
            YourLibrary(
                "https://images.unsplash.com/photo-1655404489984-ef142d5f15eb?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=1074&q=80",
                "Spirituality"
            )
        )
        item.add(
            YourLibrary(
                "https://images.unsplash.com/photo-1655461326824-36a8625570cd?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=387&q=80",
                "Travel"
            )
        )
        item.add(
            YourLibrary(
                "https://images.unsplash.com/photo-1655576751811-ec945b9e023e?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=388&q=80",
                "Arts & Culture"
            )
        )
        item.add(
            YourLibrary(
                "https://images.unsplash.com/photo-1651782174492-75e4db588b3d?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=449&q=80",
                "Car"
            )
        )
        item.add(
            YourLibrary(
                "https://images.unsplash.com/photo-1654538488705-6bf531793862?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=435&q=80",
                "Coding"
            )
        )

        return item
    }


}