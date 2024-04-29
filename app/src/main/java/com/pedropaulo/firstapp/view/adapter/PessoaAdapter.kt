package com.pedropaulo.firstapp.view.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.viewmodel.savedstate.R
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.Recycler
import com.pedropaulo.firstapp.databinding.FragmentAllPessoasBinding
import com.pedropaulo.firstapp.databinding.ListItemPessoaBinding
import com.pedropaulo.firstapp.service.model.Pessoa

class PessoaAdapter(pessoas: List<Pessoa>?, private val clickListListener: (Pessoa) -> Unit):
    RecyclerView.Adapter<PessoaAdapter.PessoaViewHolder>(){

        private var pessoaList: List<Pessoa> = arrayListOf()
    class PessoaViewHolder(private val binding: ListItemPessoaBinding) :
            RecyclerView.ViewHolder(binding.root) {
                //Carrega as informações da pessoa na lista
                fun bind(pessoa: Pessoa, clickListListener: (Pessoa) -> Unit) {
                    binding.tvNome.text = pessoa.nome
                    binding.tvIdade.text = pessoa.idade.toString() + "anos"
                    binding.tvFaixaEtaria.text = pessoa.faixaEtaria.toString()

                    if (pessoa.sexo == "Homem") {
                        binding.male.visibility = View.VISIBLE
                        binding.female.visibility = View.GONE
                    } else {
                        binding.male.visibility = View.GONE
                        binding.female.visibility = View.VISIBLE
                    }

                    //Configura o click de algum item da lista
                    binding.root.setOnClickListener{
                        clickListListener(pessoa)
                    }
                }
            }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PessoaViewHolder {
        //Confiura binding da lista
        val listItemPessoaBinding = ListItemPessoaBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return PessoaViewHolder(listItemPessoaBinding)
    }

    //
    override fun getItemCount(): Int {
        return pessoaList.count()
    }

    override fun onBindViewHolder(holder: PessoaViewHolder, position: Int) {
        holder.bind(pessoaList[position], clickListListener)
    }

    //Carrega a lista de pessoas para aparecer na lista
    fun updatePessoas(list: List<Pessoa>){
        pessoaList = list
        notifyDataSetChanged()
    }
}