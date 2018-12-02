package by.a750mm.excursionsapp750mm.data.net

import android.util.Log
import by.a750mm.excursionsapp750mm.data.entity.BookingRequest
import by.a750mm.excursionsapp750mm.data.entity.BookingResponse
import by.a750mm.excursionsapp750mm.data.entity.ExcursionResponse
import by.a750mm.excursionsapp750mm.data.entity.PortfolioResponse
import com.google.gson.GsonBuilder
import io.reactivex.Observable
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

class RestService(private val apiUrl: String) {
    private val restApi: RestApi

    init {
        val okHttpBuilder = OkHttpClient.Builder()
                .readTimeout(30, TimeUnit.SECONDS)
                .writeTimeout(30, TimeUnit.SECONDS)
                .connectTimeout(30, TimeUnit.SECONDS)
        okHttpBuilder.addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
        val gson = GsonBuilder()
                .create()
        val retrofit = Retrofit.Builder()
                .baseUrl(apiUrl)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create(gson))
                .client(okHttpBuilder.build())
                .build()
        restApi = retrofit.create(RestApi::class.java)
    }

    fun getExcursions(): Observable<List<ExcursionResponse>> {
        return restApi.getExcursions()
    }

    fun getExcursionById(id: String): Observable<ExcursionResponse> {
        return restApi.getExcursionById(id)
    }

    fun getPortfolios(): Observable<List<PortfolioResponse>> {
        return restApi.getPortfolios()
    }

    fun getPortfolioById(id: String): Observable<PortfolioResponse> {
        return restApi.getPortfolioById(id)
    }

    fun addBooking(booking: BookingRequest): Observable<BookingResponse> {
        Log.e("CCC", booking.name)
        return restApi.addBooking(booking)
    }

}