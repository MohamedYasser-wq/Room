package com.example.room.list
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.room.Data.User
import com.example.room.Data.UserViewModel
import com.example.room.R
import com.example.room.Shared.SharedPrefs
import com.example.room.Shared.SharedPrefs2
import com.example.room.Shared.SharedPrefs2.init
import com.example.room.databinding.FragmentListBinding

class ListFragment : Fragment(), OncCicked {
    lateinit var binding: FragmentListBinding
    var adapter: RecUser = RecUser()
   lateinit var viewModel:UserViewModel


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding=FragmentListBinding.inflate(inflater)
        // Inflate the layout for this fragment
        return binding.root
         }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel=ViewModelProvider(this).get(UserViewModel::class.java)
      viewModel.readAllData.observe(viewLifecycleOwner, Observer {user->

          adapter.setUserList(user)
          binding.rec.adapter=adapter
          adapter.oncCicked=this



      })

        binding.floatingActionButtonLogout.setOnClickListener {


            val sharedPreferences=SharedPrefs.apply { init(requireContext()) }
            sharedPreferences.setUserEmail("")
            sharedPreferences.setUserPass("")
            findNavController().navigate(R.id.action_listFragment_to_splashFragment)

        }

    binding.floatingActionButton.setOnClickListener {

        findNavController().navigate(R.id.action_listFragment_to_addFragment)


    }
    }

    override fun onClicked(user: User) {

        val sharedPreferences= SharedPrefs2.apply { init(requireContext()) }

            SharedPrefs2.setUserEmail(user.Email)
            SharedPrefs2.setUserPass(user.password)
            SharedPrefs2.setUserName(user.Name)
            SharedPrefs2.setUserphone(user.phone)
            Toast.makeText(requireContext(), SharedPrefs.getUserphone(), Toast.LENGTH_LONG).show()

        findNavController().navigate(R.id.action_listFragment_to_detailsFragment)


    }

}