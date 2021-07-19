package com.captaindeer.rookmotionchallenge.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.captaindeer.rookmotionchallenge.data.local.entities.UserEntity
import com.captaindeer.rookmotionchallenge.databinding.FragmentHomeBinding

class HomeFragment : Fragment(), HomeInterface.View {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    private var presenter: HomePresenter? = null

    private var users = arrayListOf<UserEntity>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        presenter = HomePresenter(requireContext(), this)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.rvHome.setHasFixedSize(true)
        binding.rvHome.layoutManager = LinearLayoutManager(requireContext())

        presenter?.getAllUsers()
    }

    override fun setListUsers(users: ArrayList<UserEntity>) {
//        TODO("Not yet implemented")
    }

    override fun onError(msg: String) {
        Toast.makeText(requireContext(), msg, Toast.LENGTH_SHORT).show()
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter?.onCancel()
    }

    override fun onStop() {
        super.onStop()
        presenter?.onCancel()

    }
}