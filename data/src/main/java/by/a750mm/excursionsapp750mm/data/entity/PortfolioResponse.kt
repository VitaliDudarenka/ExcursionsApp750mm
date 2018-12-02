package by.a750mm.excursionsapp750mm.data.entity

import com.google.gson.annotations.SerializedName

class PortfolioResponse(@SerializedName("objectId")
                        val id: String,
                        @SerializedName("name")
                        val name: String,
                        @SerializedName("imgUrl")
                        val imgUrl: String,
                        @SerializedName("articleUrl")
                        val articleUrl: String) : DataEntity {
}
