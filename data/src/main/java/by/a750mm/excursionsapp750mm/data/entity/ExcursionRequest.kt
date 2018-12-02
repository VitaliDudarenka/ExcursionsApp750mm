package by.a750mm.excursionsapp750mm.data.entity

import com.google.gson.annotations.SerializedName
import java.time.LocalDate

data class ExcursionRequest(@SerializedName("id")
                          val id: String,
                          @SerializedName("name")
                          val name: String,
                          @SerializedName("description")
                          val description: String,
                          @SerializedName("plan")
                          val plan: String,
                          @SerializedName("imgUrl")
                          val imgUrl: String,
                          @SerializedName("nextDate")
                          val nextDate: Long,
                          @SerializedName("seats")
                          val seats: Int,
                          @SerializedName("seatsRest")
                          val seatsRest: Int,
                          @SerializedName("location")
                          val location: String) : DataEntity {
}
