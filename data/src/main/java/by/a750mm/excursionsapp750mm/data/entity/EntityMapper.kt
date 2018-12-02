package by.a750mm.excursionsapp750mm.data.entity

import android.util.Log
import by.a750mm.excursionsapp750mm.domain.entity.Booking
import by.a750mm.excursionsapp750mm.domain.entity.Excursion
import by.a750mm.excursionsapp750mm.domain.entity.Portfolio

fun ExcursionResponse.transformToDomain(): Excursion {
    return Excursion(id = id, name = name, description = description, plan = plan,
            imgUrl = imgUrl, nextDate = nextDate, seats = seats, seatsRest = seatsRest, location = location)
}

fun Excursion.transformToData(): ExcursionRequest {
    return ExcursionRequest(id = id, name = name, description = description, plan = plan,
            imgUrl = imgUrl, nextDate = nextDate, seats = seats, seatsRest = seatsRest, location = location)
}

fun BookingResponse.transformToDomain(): Booking {
    return Booking(id = id, name = name, customerName = customerName, customerSurname = customerSurname,
            number = number, email = email, seats = seats, note = note)
}

fun Booking.transformToData(): BookingRequest {
    return BookingRequest(id = id, name = name, customerName = customerName, customerSurname = customerSurname,
            number = number, email = email, seats = seats, note = note)
}

fun PortfolioResponse.transformToDomain(): Portfolio {
    return Portfolio(id = id, name = name, imgUrl = imgUrl, articleUrl = articleUrl)
}

fun Portfolio.transformToData(): PortfolioRequest {
    return PortfolioRequest(id = id, name = name, imgUrl = imgUrl, articleUrl = articleUrl)
}