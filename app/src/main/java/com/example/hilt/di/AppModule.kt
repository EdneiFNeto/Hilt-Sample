package com.example.hilt.di

import android.app.Application
import androidx.room.Room
import com.example.hilt.domain.database.AppDatabase
import com.example.hilt.domain.database.dao.UserDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Singleton
    @Provides
    fun provideAppDatabase(appContext: Application) = Room.databaseBuilder(
        appContext,
        AppDatabase::class.java,
        "test-db"
    ).build()


    @Singleton
    @Provides
    fun provideUserDao(appDatabase: AppDatabase): UserDao {
        return appDatabase.userDao()
    }
}