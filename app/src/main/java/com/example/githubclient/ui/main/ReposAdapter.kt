package com.example.githubclient.ui.main

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.domain.models.SpecificUserRepos
import com.example.githubclient.R
import com.example.githubclient.databinding.ItemRepoBinding

class MyRepoViewHolder(val binding: ItemRepoBinding): RecyclerView.ViewHolder(binding.root) {
    fun bind(repo: SpecificUserRepos){
        binding.repoName.text = repo.name
        binding.branch.text = repo.defaultFork
        binding.forks.text = repo.countForks
        binding.commits.text = repo.lastDateCommit
        binding.description.text = repo.description
        binding.language.text = repo.language
        binding.stars.text = repo.starsCount
    }
}
class ReposAdapter: ListAdapter<SpecificUserRepos, MyRepoViewHolder>(
    object: DiffUtil.ItemCallback<SpecificUserRepos>(){
        override fun areItemsTheSame(
            oldItem: SpecificUserRepos,
            newItem: SpecificUserRepos
        ): Boolean {
            return oldItem==newItem
        }

        override fun areContentsTheSame(
            oldItem: SpecificUserRepos,
            newItem: SpecificUserRepos
        ): Boolean {
            return oldItem == newItem
        }

    }
) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyRepoViewHolder {
        val itemView =
            LayoutInflater.from(parent.context)
                .inflate(R.layout.item_repo, parent, false)
        return MyRepoViewHolder(ItemRepoBinding.bind(itemView))
    }

    override fun onBindViewHolder(holder: MyRepoViewHolder, position: Int) {
        val item = getItem(position)
        holder.bind(item)
    }
}