package com.mvvm.project.retrofit.webClient

import android.content.Context
import com.mvvm.project.constraints.REQUISICAO_NAO_SUCEDIDA
import com.mvvm.project.model.Data
import com.mvvm.project.model.Teste
import com.mvvm.project.retrofit.AppRetrofit
import com.mvvm.project.retrofit.service.TesteService
import org.json.JSONObject
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class WebClienTeste(private val context: Context,
                    private  val service: TesteService = AppRetrofit(context).testeService) {

    private fun <T> executaRequisicao(
        call: Call<T>,
        quandoSucesso: (t: T) -> Unit,
        quandoFalha: (erro: String?) -> Unit
    ) {
        call.enqueue(object : Callback<T> {
            override fun onResponse(call: Call<T>, response: Response<T>) {
                if (response.isSuccessful) {
                    var body = response.body()
                    if (body != null)
                        quandoSucesso(body)
                } else {
                    quandoFalha(REQUISICAO_NAO_SUCEDIDA)
                }
            }

            override fun onFailure(call: Call<T>, t: Throwable) {
                t?.let {
                    quandoFalha(it.toString())
                    it.printStackTrace()
                }
            }
        })
    }

    fun list(
        quandoSucesso: (list: Data) -> Unit,
        quandoFalha: (error: String?) -> Unit
    ) {
        executaRequisicao(service.list(), quandoSucesso, quandoFalha)
    }
}
