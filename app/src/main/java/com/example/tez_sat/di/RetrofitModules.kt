package com.example.tez_sat.di

import com.example.tez_sat.BuildConfig
import com.example.tez_sat.remote.RickApi
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.core.module.Module
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

val retrofit = createRetrofit()
val rickiApi = retrofit.create(RickApi::class.java)

val retrofitModules: Module = module {
    single { rickiApi }
}

fun createRetrofit(): Retrofit {

    val retrofit = Retrofit.Builder()
        .addConverterFactory(GsonConverterFactory.create())
        .baseUrl(BuildConfig.BASE_URL)
        .client(getOkHttpClient())
        .build()
    return retrofit
}

fun getOkHttpClient(): OkHttpClient {

    val logging = HttpLoggingInterceptor()
    logging.setLevel(HttpLoggingInterceptor.Level.BODY)

    val okHttpClient = OkHttpClient().newBuilder()
        .connectTimeout(30, TimeUnit.SECONDS)
        .writeTimeout(30, TimeUnit.SECONDS)
        .addInterceptor(logging)
        .readTimeout(30, TimeUnit.SECONDS)
        .build()
    return okHttpClient
}
