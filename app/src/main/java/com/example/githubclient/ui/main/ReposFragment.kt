package com.example.githubclient.ui.main

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.githubclient.R
import com.example.githubclient.databinding.FragmentReposBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ReposFragment: Fragment(R.layout.fragment_repos) {
    private val binding by viewBinding(FragmentReposBinding::bind)
    private val adapter = ReposAdapter()
    private val viewModel by viewModels<ReposViewModel>()
    private val args by navArgs<ReposFragmentArgs>()
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.list.adapter = adapter
        binding.list.layoutManager = LinearLayoutManager(requireContext())
        binding.owner.text = args.user.userName
        viewModel.getRepo(userName = args.user.userName)
        viewModel.repos.observe(viewLifecycleOwner){
            adapter.submitList(it)
        }
    }
}