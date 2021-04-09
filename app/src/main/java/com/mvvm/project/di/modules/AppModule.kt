package com.mvvm.project.di.modules

import androidx.room.Room
import com.mvvm.project.database.AppDatabase
import com.mvvm.project.database.dao.TesteDao
import com.mvvm.project.repository.TesteRepository
import com.mvvm.project.retrofit.webClient.WebClienTeste
import com.mvvm.project.ui.viewmodel.TesteViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

private const val NOME_BANCO_DE_DADOS = "teste.db"

val databaseModule = module {
    single<AppDatabase> {
        Room.databaseBuilder(
            get(),
            AppDatabase::class.java,
            NOME_BANCO_DE_DADOS
        ).fallbackToDestructiveMigration()
            .build()
    }
}

val  daoModule = module {
    single<TesteDao> { get<AppDatabase>().testDao }
}

val webClienteModele = module {
    single<WebClienTeste> { WebClienTeste(get()) }
}

val repositoryModule = module {
    single<TesteRepository> { TesteRepository(get<TesteDao>(), get<WebClienTeste>()) }
}

val viewModelModule = module {
    viewModel { TesteViewModel(get<TesteRepository>()) }
}