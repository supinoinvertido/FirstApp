package com.pedropaulo.firstapp.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.pedropaulo.firstapp.R
import com.pedropaulo.firstapp.databinding.FragmentPessoaBinding
import com.pedropaulo.firstapp.databinding.FragmentPessoaDetailBinding
import com.pedropaulo.firstapp.viewmodel.PessoaViewModel
import java.time.LocalDateTime


class PessoaDetailFragment : Fragment() {

    //chamar a view model para pegar os dados
    private val viewModel: PessoaViewModel by viewModels()

    // Criar o binding para pegar os elementos da tela
    private var _binding: FragmentPessoaDetailBinding? = null
    private val binding: FragmentPessoaDetailBinding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        //configurar o binding
        _binding = FragmentPessoaDetailBinding.inflate(inflater, container, false)
        return binding.root
    }

    //Chamar  a função onViewCreated onde vamos implementar o codigo
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        //pegar o id da pessoa que foi enviado pela allpessoasfragment

        // Carregar a pessoa caso tenha selecionado
        arguments?.let {
            viewModel.getPessoa(it.getInt("pessoaId"))

        }

        //Carregar as informações da pessoa selecionada
        viewModel.pessoa.observe(viewLifecycleOwner){pessoa ->
            binding.tvNome.setText(pessoa.nome)
            binding.tvData.setText((LocalDateTime.now().year - pessoa.idade).toString())
            binding.tvFaixa.setText(pessoa.faixaEtaria)



            if (pessoa.sexo == "Homem"){
                binding.ivHomem.visibility = View.VISIBLE
                binding.ivMulher.visibility = View.GONE
            } else{
                binding.ivMulher.visibility = View.VISIBLE
                binding.ivHomem.visibility = View.GONE
            }
        }

    }
}