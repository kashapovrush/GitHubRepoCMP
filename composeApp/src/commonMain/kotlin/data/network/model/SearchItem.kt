package data.network.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class SearchItem(
    @SerialName("id")
    val id:Int? = 0,
    @SerialName("name")
    val name: String? = null,
    @SerialName("full_name")
    val fullName: String? = null
)
