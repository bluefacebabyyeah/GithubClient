package com.example.githubclient.ui.main

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.domain.models.UserGithubRepositoryInfo
import com.example.githubclient.R
import com.example.githubclient.databinding.ItemRepoBinding

class MyRepoViewHolder(private val binding: ItemRepoBinding): RecyclerView.ViewHolder(binding.root) {
    fun bind(repo: UserGithubRepositoryInfo){
        binding.repoName.text = repo.name
        binding.branch.text = repo.defaultBranch
        binding.forks.text = itemView.context.getString(R.string.repo_item_forks, repo.countForks.toString())
        binding.commits.text = repo.lastDateCommit
        binding.description.text = repo.description
        binding.language.text = repo.language
        binding.stars.text = itemView.context.getString(R.string.repo_item_stars, repo.starsCount.toString())
    }
}
class ReposAdapter: ListAdapter<UserGithubRepositoryInfo, MyRepoViewHolder>(
    object: DiffUtil.ItemCallback<UserGithubRepositoryInfo>(){
        override fun areItemsTheSame(
            oldItem: UserGithubRepositoryInfo,
            newItem: UserGithubRepositoryInfo
        ): Boolean {
            return oldItem==newItem
        }

        override fun areContentsTheSame(
            oldItem: UserGithubRepositoryInfo,
            newItem: UserGithubRepositoryInfo
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