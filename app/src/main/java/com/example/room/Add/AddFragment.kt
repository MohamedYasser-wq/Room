package com.example.room.Add

import android.os.Bundle
import android.provider.ContactsContract.CommonDataKinds.Email
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.example.room.Data.User
import com.example.room.Data.UserViewModel
import com.example.room.R
import com.example.room.databinding.FragmentAddBinding

class AddFragment : Fragment() {

    lateinit var viewModel: UserViewModel
    lateinit var navController: NavController

    lateinit var binding: FragmentAddBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding=FragmentAddBinding.inflate(inflater)
        // Inflate the layout for this fragment

        viewModel=ViewModelProvider(this).get(UserViewModel::class.java)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navController= Navigation.findNavController(view)
        binding.BtnAdd.setOnClickListener {

            val Name=binding.EdtName.text.toString()
            val Phone=binding.EdtPhone.text.toString()
            val email=binding.EdtEmail.text.toString()
            val pass=binding.EdtPass.text.toString()
            val user=User(0,Name,pass,email,Phone)
            AddNewCar(user)

        }

    }
    fun AddNewCar(user: User){

        if(user.Name==""||user.Email==""||user.password==""||user.phone==""){

            Toast.makeText(requireContext(),"Enter All Field",Toast.LENGTH_LONG).show()

        }
        else if(!user.Email.contains("@"))
        {

            Toast.makeText(requireContext(),"Email not contain @",Toast.LENGTH_LONG).show()
        }
        else if(user.phone.length!=11)
        {

            Toast.makeText(requireContext(),"Phone should be 11 number",Toast.LENGTH_LONG).show()

        }
        else {
            viewModel = ViewModelProvider(this).get(UserViewModel::class.java)
            viewModel.addUser(user)
            navController.navigate(R.id.action_addFragment_to_listFragment)
             }

    }


}