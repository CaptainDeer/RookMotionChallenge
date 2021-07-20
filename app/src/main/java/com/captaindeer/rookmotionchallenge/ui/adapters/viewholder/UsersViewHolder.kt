package com.captaindeer.rookmotionchallenge.ui.adapters.viewholder

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.captaindeer.rookmotionchallenge.databinding.ItemUserBinding
import com.squareup.picasso.Picasso

class UsersViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    private val binding = ItemUserBinding.bind(view)

    fun bind(name: String, lastName: String, email: String, avatar: String) {

        binding.name.text = name + " " + lastName
        binding.email.text = email
        Picasso.get().load(avatar).into(binding.ivUser)
    }
}