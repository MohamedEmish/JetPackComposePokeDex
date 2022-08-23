package com.amosh.jetpackcomposepokedex.di

import com.amosh.jetpackcomposepokedex.BuildConfig
import com.amosh.jetpackcomposepokedex.data.remote.PokeApi
import com.amosh.jetpackcomposepokedex.repository.PokemonRepository
import com.amosh.jetpackcomposepokedex.util.Constants
import com.amosh.jetpackcomposepokedex.util.Constants.TIMEOUT_DURATION
import com.ihsanbal.logging.Level
import com.ihsanbal.logging.LoggingInterceptor
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.internal.platform.Platform
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Singleton
    @Provides
    fun providePokemonRepository(
        api: PokeApi,
    ) = PokemonRepository(api)

    @Singleton
    @Provides
    fun providePokeApi(
        client: OkHttpClient,
    ): PokeApi {
        return Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .client(client)
            .baseUrl(Constants.BASE_URL)
            .build()
            .create(PokeApi::class.java)
    }

    @Singleton
    @Provides
    fun provideInterceptor(): LoggingInterceptor {
        return LoggingInterceptor.Builder()
            .loggable(BuildConfig.DEBUG)
            .setLevel(Level.BASIC)
            .log(Platform.INFO)
            .request(" ")
            .response(" ")
            .build()
    }

    @Singleton
    @Provides
    fun provideHttpClient(
        loggingInterceptor: LoggingInterceptor,
    ): OkHttpClient {
        return OkHttpClient.Builder()
            .readTimeout(TIMEOUT_DURATION, TimeUnit.MILLISECONDS)
            .retryOnConnectionFailure(true)
            .addInterceptor(loggingInterceptor)
            .build()
    }
}