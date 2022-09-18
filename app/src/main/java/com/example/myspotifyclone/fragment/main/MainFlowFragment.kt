package com.example.myspotifyclone.fragment.main

import androidx.navigation.NavController
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.myspotifyclone.R
import com.example.myspotifyclone.databinding.FlowFragmentMainBinding
import com.example.myspotifyclone.fragment.BaseFlowFragment

class MainFlowFragment: BaseFlowFragment(R.layout.flow_fragment_main, R.id.nav_host_fragment_main) {
    private val binding by viewBinding(FlowFragmentMainBinding::bind)

    override fun setupNavigation(navController: NavController) {
        super.setupNavigation(navController)
    }
}