package com.example.favorites

import android.content.Context
import androidx.room.Room
import com.example.favorites.domain.CatFactDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideDatabase(@ApplicationContext context: Context): CatFactDatabase {
        return Room.databaseBuilder(
            context,
            CatFactDatabase::class.java,
            "favorite_facts"
        ).build()
    }
}