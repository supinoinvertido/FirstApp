package com.pedropaulo.firstapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.pedropaulo.firstapp.databinding.ActivityMainBinding
import com.pedropaulo.firstapp.databinding.TelaLinearBinding

class MainActivity : AppCompatActivity() {

    private var _binding: ActivityMainBinding? = null
    private val binding: ActivityMainBinding get() = _binding!!
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)

        binding.sendButton.setOnClickListener {

            var email = binding.emailEditText.editableText.toString()
            if (email.contains("@") && email.substringAfter("@").contains(".com")) {
                binding.tvEmail.text = "E-mail: $email"
            } else {
                binding.tvEmail.text = "E-mail: Inválido"
            }

            var telefone = binding.phoneEditText.editableText.toString()
            if (telefone.length == 11) {
                binding.tvTelefone.text = "Telefone: ${telefone}"
            }else {
                binding.tvTelefone.text = "Telefone: Inválido"
            }
        }
    }
}




//        binding.btnenviar.setOnClickListener {
//            var nome = binding.edtNome.editableText.toString()
//
//            binding.tvNome.text = "Nome: ${nome}"
//
//            var idade = binding.edtAnoNascimento.editableText.toString()
//
//            binding.tvIdade.text = "Idade:  ${2024 - idade.toInt()}"
//        }
//    }
//}