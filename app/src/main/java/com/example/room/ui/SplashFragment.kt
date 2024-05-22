package com.example.room.ui

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.room.R
import com.example.room.Shared.SharedPrefs

class SplashFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_splash, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Handler(Looper.getMainLooper()).postDelayed({
            // Navigate to SecondFragment
            val sharedPreferences = SharedPrefs.apply { init(requireContext()) }
            if (sharedPreferences.getUserEmail()!!.isNotEmpty() && sharedPreferences.getUserPass()!!.isNotEmpty()) {
                // If both email and password are not empty, navigate to the listFragment
                findNavController().navigate(R.id.action_splashFragment_to_listFragment)
            } else {
                // If either email or password is empty, navigate to the loginFragment
                findNavController().navigate(R.id.action_splashFragment_to_loginFragment)
            }
        }, 3000)




    }

}