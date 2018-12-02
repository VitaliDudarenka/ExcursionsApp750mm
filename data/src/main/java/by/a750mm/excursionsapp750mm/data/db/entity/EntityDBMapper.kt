package by.a750mm.excursionsapp750mm.data.db.entity

import by.a750mm.excursionsapp750mm.data.entity.ExcursionResponse
import by.a750mm.excursionsapp750mm.data.entity.PortfolioResponse
import by.a750mm.excursionsapp750mm.domain.entity.Excursion
import by.a750mm.excursionsapp750mm.domain.entity.Portfolio


fun ExcursionDB.transformToDomain(): Excursion {
    return Excursion(id = id, name = name, description = description, plan = plan,
            imgUrl = imgUrl, nextDate = nextDate, seats = seats, seatsRest = seatsRest, location = location)
}

fun ExcursionResponse.transformToDB(): ExcursionDB {
    return ExcursionDB(id = id, name = name, description = description, plan = plan,
            imgUrl = imgUrl, nextDate = nextDate, seats = seats, seatsRest = seatsRest, location = location)
}

fun PortfolioDB.transformToDomain(): Portfolio {
    return Portfolio(id = id, name = name, imgUrl = imgUrl, articleUrl = articleUrl)
}

fun PortfolioResponse.transformToDB(): PortfolioDB {
    return PortfolioDB(id = id, name = name, imgUrl = imgUrl, articleUrl = articleUrl)
}

