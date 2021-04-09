package com.mvvm.project.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.mvvm.project.database.dao.TesteDao
import com.mvvm.project.model.Teste

private const val NOME_BANCO_DE_DADOS = "teste.db"

@Database(
    version = 4,
    entities = [
        Teste::class
    ], exportSchema = false
)
abstract class AppDatabase : RoomDatabase() {

    abstract val testDao: TesteDao

    companion object {
        private lateinit var db: AppDatabase

        fun getInstance(context: Context): AppDatabase {

            if (::db.isInitialized) return db

            db = Room.databaseBuilder(
                context,
                AppDatabase::class.java,
                NOME_BANCO_DE_DADOS
            )
                .fallbackToDestructiveMigration()
                .build()

            return db
        }
    }
}
