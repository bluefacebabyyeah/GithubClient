package com.example.githubclient.ui.main

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.domain.models.User
import com.example.githubclient.R
import com.example.githubclient.databinding.FragmentUsersBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class UsersFragment : Fragment(R.layout.fragment_users) {
    private val binding by viewBinding(FragmentUsersBinding::bind)
    private val adapter = UsersAdapter(::toRepoPage)
    private val viewModel by viewModels<UsersViewModel>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.list.adapter = adapter
        binding.list.layoutManager = LinearLayoutManager(requireContext())
        binding.buttonSearch.setOnClickListener {
            viewModel.searchUsers(binding.inputSearch.text.toString())
        }
        viewModel.users.observe(viewLifecycleOwner){
            adapter.submitList(it)
        }
        viewModel.loading.observe(viewLifecycleOwner){
            binding.progressLoading.isVisible = it
        }
        viewModel.error.observe(viewLifecycleOwner){
            if (it != null) {
                Toast.makeText(requireContext(), it, Toast.LENGTH_LONG).show()
            }
        }
    }

    private fun toRepoPage(it: User) {
        findNavController().navigate(
            resId = R.id.action_usersFragment_to_reposFragment,
            args = ReposFragmentArgs(it).toBundle(),
        )
    }
}