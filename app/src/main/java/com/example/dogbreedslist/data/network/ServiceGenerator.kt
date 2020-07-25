package com.example.dogbreedslist.data.network

import com.example.dogbreedslist.BuildConfig
import com.example.dogbreedslist.data.network.service.DogService.Companion.ENDPOINT
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Inject
import javax.inject.Singleton

/**
 * Created by AhmedEltaher
 */

@Singleton
class ServiceGenerator @Inject
constructor() {

    //Network constants
    private val timeoutConnect = 30   //In seconds
    private val timeoutRead = 30   //In seconds
    private val contentType = "Content-Type"
    private val contentTypeValue = "application/json"

    private val okHttpBuilder: OkHttpClient.Builder = OkHttpClient.Builder()
    private val retrofit: Retrofit

    private var headerInterceptor = Interceptor { chain ->
        val original = chain.request()

        val request = original.newBuilder()
                .header(contentType, contentTypeValue)
                .method(original.method, original.body)
                .build()

        chain.proceed(request)
    }

    private val logger: HttpLoggingInterceptor
        get() {
            val loggingInterceptor = HttpLoggingInterceptor()
            if (BuildConfig.DEBUG) {
                loggingInterceptor.apply { loggingInterceptor.level = HttpLoggingInterceptor.Level.HEADERS }.level = HttpLoggingInterceptor.Level.BODY
            }
            return loggingInterceptor
        }

    init {
        okHttpBuilder.addInterceptor(headerInterceptor)
        okHttpBuilder.addInterceptor(logger)
        okHttpBuilder.connectTimeout(timeoutConnect.toLong(), TimeUnit.SECONDS)
        okHttpBuilder.readTimeout(timeoutRead.toLong(), TimeUnit.SECONDS)
        val client = okHttpBuilder.build()
        retrofit = Retrofit.Builder()
                .baseUrl(ENDPOINT).client(client)
                .addConverterFactory(MoshiConverterFactory.create())
                .build()
    }

    fun <S> createService(serviceClass: Class<S>): S {
        return retrofit.create(serviceClass)
    }
}