package com.appsuki.app.ui.auth

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.appsuki.app.R
import com.appsuki.app.data.repository.AuthRepository
import com.appsuki.app.databinding.FragmentLoginBinding

class LoginFragment : Fragment() {
    val parent: AuthActivity by lazy { activity as AuthActivity }
    val viewModel: AuthViewModel by lazy { AuthViewModel(AuthRepository(parent)) }
    lateinit var binding: FragmentLoginBinding

     override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
         binding = FragmentLoginBinding.inflate(inflater, container, false)
         binding.lifecycleOwner = this
         binding.viewModel = viewModel
         return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init()

        observe()
    }

    private fun init() {
        binding.buttonRegister.setOnClickListener {
            findNavController().navigate(LoginFragmentDirections.actionLoginFragmentToRegisterFragment())
        }
    }

    private fun observe() {
      viewModel.authLogin.observe(viewLifecycleOwner) {
          if (it.isConsumed) {
              Log.i("Login", "isConsumed")
          } else if (!it.isSuccess) {
              Toast.makeText(parent, it.message, Toast.LENGTH_SHORT).show()
          } else {
              Toast.makeText(parent, it.message, Toast.LENGTH_SHORT).show()
              it.data?.let { it1 -> parent.onSuccess(it1) }
          }
          it.isConsumed = true


      }
    }
}