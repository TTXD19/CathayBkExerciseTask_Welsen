package com.android.project.cathaybkexercisetask_welsen.di

import com.android.project.cathaybkexercisetask_welsen.data.api.GithubServiceApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import hu.akarnokd.rxjava3.retrofit.RxJava3CallAdapterFactory
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {
    @Singleton
    @Provides
    fun provideHttpLoginInterceptor(): HttpLoggingInterceptor {
        val interceptor = HttpLoggingInterceptor()
        interceptor.level = HttpLoggingInterceptor.Level.BODY
        return interceptor
    }

    @Singleton
    @Provides
    fun provideOkHttpClient(httpLoggingInterceptor: HttpLoggingInterceptor): OkHttpClient {
        return OkHttpClient.Builder()
            .addInterceptor { chain: Interceptor.Chain ->
                val original = chain.request()
                val requestBuilder = original.newBuilder()
                    .header("accept", "application/vnd.github.v3+json")
                    .addHeader("Authorization", "token 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")
                val request = requestBuilder.build()
                chain.proceed(request)
            }
            .addInterceptor(interceptor = httpLoggingInterceptor)
            .connectTimeout(60, TimeUnit.SECONDS)
            .readTimeout(60, TimeUnit.SECONDS)
            .build()
    }

    @Singleton
    @Provides
    fun profilerRetrofit(okHttpClient: OkHttpClient): Retrofit {
        return Retrofit.Builder()
            .client(okHttpClient)
            .baseUrl("https://api.github.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
            .build()
    }

    @Singleton
    @Provides
    fun provideNetworkManager(
        retrofit: Retrofit
    ): NetworkManger {
        return NetworkManger(retrofit)
    }

}

@Module
@InstallIn(SingletonComponent::class)
object GithubServiceModule {
    @Singleton
    @Provides
    fun provideGithubApiServiceModule(networkManger: NetworkManger): GithubServiceApi {
        return networkManger.getApiServices(serviceClass = GithubServiceApi::class.java)
    }
}