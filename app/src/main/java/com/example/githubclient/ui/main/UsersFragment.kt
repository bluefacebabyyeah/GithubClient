package com.example.githubclient.ui.main

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModel
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.githubclient.R
import com.example.githubclient.databinding.FragmentUsersBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class UsersFragment : Fragment(R.layout.fragment_users) {
    private val binding by viewBinding(FragmentUsersBinding::bind)
    private val adapter = UsersAdapter{
            findNavController()
                .navigate(R.id.action_usersFragment_to_reposFragment, ReposFragmentArgs(it)
                    .toBundle())
    }
    private val viewModel by viewModels<UsersViewModel>()
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.list.adapter = adapter
        binding.list.layoutManager = LinearLayoutManager(requireContext())
        binding.buttonSearch.setOnClickListener {
            viewModel.searchUser(binding.inputSearch.text.toString())
        }
        viewModel.users.observe(viewLifecycleOwner){
            adapter.submitList(it)
        }

    }
}