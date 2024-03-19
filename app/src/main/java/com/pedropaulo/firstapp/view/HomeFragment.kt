package com.pedropaulo.firstapp.view

import android.content.Context
import android.os.Bundle
import android.util.AttributeSet
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.findNavController
import com.pedropaulo.firstapp.R
import com.pedropaulo.firstapp.databinding.ActivityMainBinding
import com.pedropaulo.firstapp.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val binding: FragmentHomeBinding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentHomeBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnCalculo.setOnClickListener{
            findNavController().navigate(R.id.calculoFragment)}
        binding.btnVerifica.setOnClickListener{
            findNavController().navigate(R.id.verificaFragment)
        }
    }

}