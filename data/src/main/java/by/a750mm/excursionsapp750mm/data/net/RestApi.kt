package by.a750mm.excursionsapp750mm.data.net

import by.a750mm.excursionsapp750mm.data.entity.BookingRequest
import by.a750mm.excursionsapp750mm.data.entity.BookingResponse
import by.a750mm.excursionsapp750mm.data.entity.ExcursionResponse
import by.a750mm.excursionsapp750mm.data.entity.PortfolioResponse
import io.reactivex.Observable
import retrofit2.http.*

interface RestApi {
    @GET("excursions")
    fun getExcursions(): Observable<List<ExcursionResponse>>

    @GET("excursions/{id}")
    fun getExcursionById(@Path("id") id: String): Observable<ExcursionResponse>

    @POST("bookings")
    fun addBooking(@Body booking: BookingRequest): Observable<BookingResponse>

    @GET("portfolio?sortBy=created%20asc")
    fun getPortfolios(): Observable<List<PortfolioResponse>>

    @GET("portfolio/{id}")
    fun getPortfolioById(@Path("id") id: String): Observable<PortfolioResponse>


}