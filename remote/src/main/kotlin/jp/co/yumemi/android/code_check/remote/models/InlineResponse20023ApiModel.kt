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

package jp.co.yumemi.android.code_check.remote.models

import jp.co.yumemi.android.code_check.remote.models.EnvironmentApiModel

import kotlinx.serialization.*

/**
 * 
 * @param totalCount The number of environments in this repository
 * @param environments 
 */
@Serializable
data class InlineResponse20023ApiModel(
    /* The number of environments in this repository */
    @SerialName(value = "total_count")
    val totalCount: kotlin.Int? = null,
    @SerialName(value = "environments")
    val environments: kotlin.collections.List<EnvironmentApiModel>? = null
) {

}
