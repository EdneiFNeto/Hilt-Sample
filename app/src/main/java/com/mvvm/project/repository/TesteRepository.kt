package com.mvvm.project.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.sqlite.db.SimpleSQLiteQuery
import com.mvvm.project.async.BaseAsyncTask
import com.mvvm.project.database.dao.TesteDao
import com.mvvm.project.model.Data
import com.mvvm.project.model.Teste
import com.mvvm.project.repository.resource.Resources
import com.mvvm.project.retrofit.webClient.WebClienTeste

class TesteRepository(
    private val dao: TesteDao,
    private val webClient: WebClienTeste) {

    fun list(): LiveData<Resources<Data>> {
        val liveData = MutableLiveData<Resources<Data>>()
        BaseAsyncTask(executando = {
            dao.list(SimpleSQLiteQuery("SELECT * FROM Teste"))
        }, finalizado = {
            if (it.isNotEmpty()) {
                liveData.value = Resources(dado = null)
            } else {
                webClient.list(quandoSucesso = { list ->
                    liveData.value = Resources(dado = list)
                }, quandoFalha = { error ->
                    liveData.value = Resources(dado = null, error = error)
                })
            }
        }).execute()
        return liveData
    }
}
