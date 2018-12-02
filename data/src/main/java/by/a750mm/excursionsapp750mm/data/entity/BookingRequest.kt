package by.a750mm.excursionsapp750mm.data.entity

import com.google.gson.annotations.SerializedName

data class BookingRequest(@SerializedName("id")
                          val id: String,
                          @SerializedName("name")
                          val name: String,
                          @SerializedName("customerName")
                          val customerName: String,
                          @SerializedName("customerSurname")
                          val customerSurname: String,
                          @SerializedName("number")
                          val number: String,
                          @SerializedName("email")
                          val email: String,
                          @SerializedName("seats")
                          val seats: Int,
                          @SerializedName("note")
                          val note: String) : DataEntity {
}



