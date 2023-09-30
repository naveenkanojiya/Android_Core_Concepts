package com.example.recyclerviewwithme.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.findNavController
import com.example.recyclerviewwithme.R
import com.example.recyclerviewwithme.databinding.FragmentSearchBinding
import kotlinx.coroutines.flow.combine


class SearchFragment : Fragment() {
    lateinit var binding:FragmentSearchBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnSearchFgm.setOnClickListener {
           // Toast.makeText(requireContext(),"Naveen",Toast.LENGTH_SHORT).show()
            val navController = view.findNavController()
            navController.navigate(R.id.action_searchFragment_to_profileFragment)
        }

        binding.btnSearchFgm2.setOnClickListener {
            // Toast.makeText(requireContext(),"Naveen",Toast.LENGTH_SHORT).show()
            val navController = view.findNavController()
            navController.navigate(R.id.action_searchFragment_to_addFragment)
        }


    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentSearchBinding.inflate(inflater,container,false)
        return binding.root
    }

    companion object {

    }
}