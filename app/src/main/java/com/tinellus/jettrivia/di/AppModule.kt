package com.tinellus.jettrivia.di

import com.tinellus.jettrivia.network.QuestionApi
import com.tinellus.jettrivia.repository.QuestionRepository
import com.tinellus.jettrivia.util.Constants
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Singleton
    @Provides
   fun provideQuestionRepository(api: QuestionApi) = QuestionRepository(api)

   @Singleton
   @Provides
   fun provideQuestionApi(): QuestionApi {
       return Retrofit.Builder()
           .baseUrl(Constants.BASE_URL)
           .addConverterFactory(GsonConverterFactory.create())
           .build()
           .create(QuestionApi::class.java)
   }
}