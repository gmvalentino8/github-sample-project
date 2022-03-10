/**
 * GitHub v3 REST API
 *
 * GitHub's v3 REST API.
 *
 * The version of the OpenAPI document: 1.1.4
 * 
 *
 * Please note:
 * This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * Do not edit this file manually.
 */

@file:Suppress(
    "ArrayInDataClass",
    "EnumEntryName",
    "RemoveRedundantQualifierName",
    "UnusedImport"
)

package io.github.gmvalentino8.github.sample.remote.models

import io.github.gmvalentino8.github.sample.remote.models.ApplicationGrantAppApiModel
import io.github.gmvalentino8.github.sample.remote.models.NullableMinusSimpleMinusUserApiModel

import kotlinx.serialization.*

/**
 * The authorization associated with an OAuth Access.
 * @param id 
 * @param url 
 * @param app 
 * @param createdAt 
 * @param updatedAt 
 * @param scopes 
 * @param user 
 */
@Serializable
data class ApplicationMinusGrantApiModel(
    @SerialName(value = "id")
    val id: kotlin.Int,
    @SerialName(value = "url")
    val url: kotlin.String,
    @SerialName(value = "app")
    val app: ApplicationGrantAppApiModel,
    @SerialName(value = "created_at")
    val createdAt: kotlin.String,
    @SerialName(value = "updated_at")
    val updatedAt: kotlin.String,
    @SerialName(value = "scopes")
    val scopes: kotlin.collections.List<kotlin.String>,
    @SerialName(value = "user")
    val user: NullableMinusSimpleMinusUserApiModel? = null
) {

}
