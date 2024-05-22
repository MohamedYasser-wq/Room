package com.example.room.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.room.R
import com.example.room.Shared.SharedPrefs
import com.example.room.Shared.SharedPrefs2
import com.example.room.databinding.FragmentDetailsBinding
import com.example.room.databinding.FragmentListBinding


class DetailsFragment : Fragment() {
    lateinit var binding: FragmentDetailsBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding= FragmentDetailsBinding.inflate(inflater)
        // Inflate the layout for this fragment
        return binding.root





    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val sharedPreferences= SharedPrefs2.apply { init(requireContext()) }
        binding.email.text=sharedPreferences.getUserEmail()
        binding.Name.text=sharedPreferences.getUserName()
        binding.phone.text=sharedPreferences.getUserphone()
        binding.pass.text=sharedPreferences.getUserPass()

    }


}