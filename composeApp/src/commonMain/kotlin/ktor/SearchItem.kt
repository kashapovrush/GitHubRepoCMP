package ktor

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class SearchItem(
    @SerialName("name")
    val name: String? = null,
    @SerialName("full_name")
    val fullName: String? = null
)
