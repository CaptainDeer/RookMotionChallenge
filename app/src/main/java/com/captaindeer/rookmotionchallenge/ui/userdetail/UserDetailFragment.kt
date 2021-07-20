package com.captaindeer.rookmotionchallenge.ui.userdetail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.captaindeer.rookmotionchallenge.data.local.entities.UserEntity
import com.captaindeer.rookmotionchallenge.databinding.FragmentUserDetailBinding
import com.squareup.picasso.Picasso

class UserDetailFragment : Fragment(), UserDetailInterface.View {

    private val args: UserDetailFragmentArgs by navArgs()
    private var _binding: FragmentUserDetailBinding? = null
    private val binding get() = _binding!!
    private var presenter: UserDetailPresenter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        presenter = UserDetailPresenter(requireContext(), this)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentUserDetailBinding.inflate(inflater, container, false)
        val myNumber = args.userId
        presenter?.getUserDetail(myNumber)
        return binding.root
    }

    override fun setUserInfo(userEntity: UserEntity) {
        binding.tvUserId.text = userEntity.id.toString()
        binding.tvUserName.text = userEntity.first_name.toString()
        binding.tvUserLastName.text = userEntity.last_name.toString()
        binding.tvUserEmail.text = userEntity.email
        Picasso.get().load(userEntity.avatar).into(binding.ivUserDetail)
    }
}