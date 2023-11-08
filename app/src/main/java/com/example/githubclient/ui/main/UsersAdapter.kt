package com.example.githubclient.ui.main

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBinding
import com.bumptech.glide.Glide
import com.example.domain.models.User
import com.example.githubclient.R
import com.example.githubclient.databinding.ItemUserBinding

class MyViewHolder(private val binding: ItemUserBinding): RecyclerView.ViewHolder(binding.root) {
    fun bind(user: User){
        Glide.with(itemView.context)
            .load(user.imageUrl)
            .into(binding.avatar)
        binding.followers.text = itemView.context
            .getString(R.string.followers_count, user.followersCount.toString())
        binding.username.text = user.userName
        binding.root.setOnClickListener{
            (bindingAdapter as UsersAdapter).onClick(user)
        }
    }
}

class UsersAdapter(
    val onClick : (User)->Unit
): ListAdapter<User, MyViewHolder>(
    object: DiffUtil.ItemCallback<User>(){
        override fun areItemsTheSame(oldItem: User, newItem: User): Boolean {
            return oldItem == newItem
        }
        override fun areContentsTheSame(oldItem: User, newItem: User): Boolean {
            return oldItem == newItem
        }
    }
) {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView =
            LayoutInflater.from(parent.context)
                .inflate(R.layout.item_user, parent, false)
        return MyViewHolder(ItemUserBinding.bind(itemView))
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val item = getItem(position)
        holder.bind(item)
    }
}