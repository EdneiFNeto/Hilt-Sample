package com.mvvm.project.ui.fragment.base

import androidx.fragment.app.Fragment
import com.mvvm.project.ui.viewmodel.TesteViewModel
import org.koin.android.viewmodel.ext.android.viewModel

abstract class BaseFragment: Fragment() {
    protected val viewModelTeste by viewModel<TesteViewModel>()
    protected abstract fun initViewModel()
}
