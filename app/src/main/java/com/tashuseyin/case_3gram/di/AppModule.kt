package com.tashuseyin.case_3gram.di

import android.content.Context
import com.tashuseyin.case_3gram.common.Constant
import com.tashuseyin.case_3gram.data.data_store.DataStoreRepository
import com.tashuseyin.case_3gram.data.remote.Case3GramApi
import com.tashuseyin.case_3gram.data.repository.Case3GramRepositoryImpl
import com.tashuseyin.case_3gram.domain.repository.Case3GramRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideCase3GramApi(): Case3GramApi {
        return Retrofit.Builder()
            .baseUrl(Constant.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(Case3GramApi::class.java)
    }

    @Provides
    @Singleton
    fun provideCase3GramRepository(api: Case3GramApi): Case3GramRepository {
        return Case3GramRepositoryImpl(api)
    }

    @Provides
    @Singleton
    fun provideDataStoreManager(@ApplicationContext context: Context): DataStoreRepository {
        return DataStoreRepository(context)
    }
}