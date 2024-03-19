package com.pedropaulo.firstapp.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.pedropaulo.firstapp.R
import com.pedropaulo.firstapp.databinding.ActivityMainBinding
import com.pedropaulo.firstapp.databinding.FragmentCalculoBinding
import java.time.LocalDateTime


class CalculoFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var _binding: FragmentCalculoBinding? = null
    private val binding: FragmentCalculoBinding get() = _binding!!



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentCalculoBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.btnEnviar.setOnClickListener{
            var nome = binding.edtNome.editableText.toString()

            binding.tvNome.text = "Nome: ${nome}"

            var idade = binding.edtAnoNascimento.editableText.toString()
            val  anoAtual = LocalDateTime.now().year
            binding.tvIdade.text = "idade: ${2024 - idade.toInt()}"

        }
    }
}

