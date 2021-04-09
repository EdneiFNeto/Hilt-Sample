package com.mvvm.project.ui.fragment

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import com.mvvm.project.databinding.FragmentTestBinding
import com.mvvm.project.model.Data
import com.mvvm.project.model.Person
import com.mvvm.project.recycleview.adapter.PersonAdapter
import com.mvvm.project.ui.fragment.base.BaseFragment
import kotlinx.android.synthetic.main.fragment_test.*

class TestFragment : BaseFragment() {
    private var testeAdapter: PersonAdapter? = null
    private val testes = ArrayList<Person>()
    private var viewDataBinging: FragmentTestBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewDataBinging = FragmentTestBinding.inflate(inflater, container, false)
        return viewDataBinging?.root
    }

    override fun initViewModel() {
        viewModelTeste.list().observe(viewLifecycleOwner, Observer {
            Log.i("Resources", it.dado.toString())
            if (it.dado != null) {
                var data = it.dado as Data
                data.data.forEach { teste ->
                    testes.add(teste)
                }.also {
                    testeAdapter?.notifyDataSetChanged()
                }
            }
        })
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        testeAdapter = PersonAdapter(context, testes)

        recycleViewTeste.run {
            adapter = testeAdapter
        }

        initViewModel()
    }
}