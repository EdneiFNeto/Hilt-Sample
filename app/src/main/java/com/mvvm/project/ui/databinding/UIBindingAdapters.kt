package com.mvvm.project.ui.databinding

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide

class UIBindingAdapters {
    companion object {
        @JvmStatic
        @BindingAdapter("carregaImagem")
        fun ImageView.carregaImagem(url: String) {
            Glide.with(this)
                .load(url)
                .into(this)
        }
    }
}