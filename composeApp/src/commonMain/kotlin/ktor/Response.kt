package ktor

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Response(
    @SerialName("items")
    val items: List<SearchItem>
)
