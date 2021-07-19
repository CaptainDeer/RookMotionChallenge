package com.captaindeer.rookmotionchallenge.ui.forgotpassword

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.DialogFragment
import com.captaindeer.rookmotionchallenge.databinding.DialogForgotPasswordBinding
import com.google.firebase.auth.FirebaseAuth

class ForgotPasswordDialog : DialogFragment() {

    private var _binding: DialogForgotPasswordBinding? = null
    private val binding get() = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = DialogForgotPasswordBinding.inflate(inflater, container, false)

        binding.btnAccept.setOnClickListener {
            if (binding.etEmailReset.text.isNullOrBlank()) {
                onError("Please type your e-mail")
            } else {
                FirebaseAuth.getInstance()
                    .sendPasswordResetEmail(binding.etEmailReset.text.toString())
                    .addOnCompleteListener { task ->
                        if (task.isSuccessful) {
                            onSuccess()
                        } else {
                            onError(task.exception.toString())
                        }
                    }
            }
        }
        binding.btnCancel.setOnClickListener {
            dismiss()
        }
        return binding.root
    }

    private fun onSuccess() {
        dismiss()
        Toast.makeText(requireContext(), "Verify your E-mail", Toast.LENGTH_SHORT).show()
    }

    private fun onError(msg: String) {
        Toast.makeText(requireContext(), msg, Toast.LENGTH_SHORT).show()
    }
}