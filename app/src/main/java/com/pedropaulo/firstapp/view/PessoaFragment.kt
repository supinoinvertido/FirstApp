package com.pedropaulo.firstapp.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.pedropaulo.firstapp.databinding.FragmentPessoaBinding
import com.pedropaulo.firstapp.service.model.Pessoa
import com.pedropaulo.firstapp.viewmodel.PessoaViewModel
import java.time.LocalDateTime


class PessoaFragment : Fragment() {
    private val viewModel: PessoaViewModel by   viewModels ()
    // TODO: Rename and change types of parameters
    private var _binding: FragmentPessoaBinding? = null
    private val binding: FragmentPessoaBinding get() = _binding!!



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentPessoaBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnEnviar.setOnClickListener{
            var nome = binding.edtNome.editableText.toString()
            var anoNascimento = binding.edtAnoNascimento.editableText.toString()

            if(nome  != ""&& anoNascimento != ""){
                var sexo = ""
                var faixa = ""

                if (binding.rbHomem.isChecked) {
                    sexo = "Homem"
                } else {
                    sexo = "Mulher"
                }

                val  anoAtual = LocalDateTime.now().year
                val idade = anoAtual - anoNascimento.toInt()



                when (idade) {
                    in 0..12 -> faixa = "Infantil"
                    in 13..17 -> faixa = "Adolescente"
                    in 18..64 -> faixa = "Adulto"
                    in 65..150 -> faixa = "Idoso"
                    else -> faixa = "Voce não existe"
                }



                val pessoa = Pessoa(
                    nome = nome,
                    idade = idade,
                    sexo = sexo,
                    faixaEtaria = faixa
                )


                viewModel.insert(pessoa)

                binding.edtNome.editableText.clear()
                binding.edtAnoNascimento.editableText.clear()
                findNavController().navigateUp()

            } else {
                Toast.makeText(requireContext(), "Digite os dados", Toast.LENGTH_LONG).show()
            }


        }
    }
}

//            binding.tvIdade.text = "idade: ${2024 - idade.toInt()}"