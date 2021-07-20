package com.captaindeer.rookmotionchallenge.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.captaindeer.rookmotionchallenge.R
import com.captaindeer.rookmotionchallenge.data.local.entities.UserEntity
import com.captaindeer.rookmotionchallenge.ui.adapters.viewholder.UsersViewHolder
import com.captaindeer.rookmotionchallenge.ui.home.HomeFragmentDirections

class UsersAdapter(private var users: ArrayList<UserEntity>) :
    RecyclerView.Adapter<UsersViewHolder>() {

    fun updateData(users: ArrayList<UserEntity>) {
        this.users = users
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UsersViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return UsersViewHolder(
            layoutInflater.inflate(R.layout.item_user, parent, false)
        )
    }

    override fun onBindViewHolder(holder: UsersViewHolder, position: Int) {
        val user = users[position]

        holder.bind(user.first_name, user.last_name, user.email, user.avatar)
        holder.itemView.setOnClickListener {
            val action = HomeFragmentDirections.navigateToDetailFragment(user.id)
            Navigation.findNavController(it).navigate(action)
        }
    }

    override fun getItemCount(): Int = users.size
}