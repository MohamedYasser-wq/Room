package com.example.room.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.example.room.Data.UserViewModel
import com.example.room.R
import com.example.room.Shared.SharedPrefs
import com.example.room.databinding.FragmentLoginBinding

class LoginFragment : Fragment() {
    lateinit var binding: FragmentLoginBinding
    lateinit var navController: NavController
    lateinit var viewModel: UserViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding= FragmentLoginBinding.inflate(inflater)
        // Inflate the layout for this fragment
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navController= Navigation.findNavController(view)


        binding.BtnLogin.setOnClickListener {
            val email=binding.EmailEdt.text.toString()
            val pass=binding.PassEdt.text.toString()
            val sharedPreferences= SharedPrefs.apply { init(requireContext()) }
            SharedPrefs.setUserEmail(email)
            SharedPrefs.setUserPass(pass)
            Toast.makeText(requireContext(), SharedPrefs.getUserEmail(), Toast.LENGTH_LONG).show()



            Validate(email,pass)
        }


    }
    fun Validate(email: String, pass: String) {
        if (email == "" || pass == "") {
            Toast.makeText(requireContext(), "Enter All Field", Toast.LENGTH_LONG).show()
        } else {
            viewModel = ViewModelProvider(this).get(UserViewModel::class.java)
            viewModel.readAllData.observe(viewLifecycleOwner, Observer { users ->
                // Check if the user exists in the list
                val userExists = users.any { user ->
                    user.Email == email && user.password == pass
                }

                if (userExists) {
                    // User with provided email and password exists
                    Toast.makeText(requireContext(), "User exists!", Toast.LENGTH_LONG).show()
                    navController.navigate(R.id.action_loginFragment_to_listFragment)

                } else {
                    // No matching user found
                    Toast.makeText(requireContext(), "User does not exist!", Toast.LENGTH_LONG).show()
                }
            })
        }
    }



}