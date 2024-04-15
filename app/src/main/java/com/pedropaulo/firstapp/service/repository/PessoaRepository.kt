package com.pedropaulo.firstapp.service.repository

import android.content.Context
import com.pedropaulo.firstapp.service.model.Pessoa
import com.pedropaulo.firstapp.service.repository.local.FirstAppDataBase

class PessoaRepository(context: Context) {
    private val firstAppDb = FirstAppDataBase.getDataBase(context) .pessoaDAO()

    suspend fun insertPessoa(pessoa: Pessoa){
        firstAppDb.insert(pessoa)
    }
    suspend fun getPessoa(id: Int): Pessoa{
       return firstAppDb.getPessoa(id)
    }
    suspend fun getAll(): List<Pessoa>{
        return firstAppDb.getALL()
     }
    suspend fun updadePessoa(pessoa: Pessoa){
        firstAppDb.update(pessoa)
    }
    suspend fun deletePessoa(id: Int){
        firstAppDb.delete(id)
    }
}