package com.mvvm.project.async

import android.os.AsyncTask

class BaseAsyncTask<T>(
    private val preExecute: (() -> Unit)? = null,
    private val executando: () -> T,
    private val finalizado: (resultado: T) -> Unit) : AsyncTask<Void, Void, T>() {

    override fun doInBackground(vararg params: Void?): T = executando()

    override fun onPreExecute() {
        super.onPreExecute()
        preExecute?.let { it() }
    }
    override fun onPostExecute(result: T) {
        super.onPostExecute(result)
        finalizado(result)
    }
}