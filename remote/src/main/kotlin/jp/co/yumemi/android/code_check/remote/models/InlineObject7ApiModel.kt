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


import kotlinx.serialization.*

/**
 * 
 * @param scopes A list of scopes that this authorization is in.
 * @param note A note to remind you what the OAuth token is for.
 * @param noteUrl A URL to remind you what app the OAuth token is for.
 * @param clientId The OAuth app client key for which to create the token.
 * @param clientSecret The OAuth app client secret for which to create the token.
 * @param fingerprint A unique string to distinguish an authorization from others created for the same client ID and user.
 */
@Serializable
data class InlineObject7ApiModel(
    /* A list of scopes that this authorization is in. */
    @SerialName(value = "scopes")
    val scopes: kotlin.collections.List<kotlin.String>? = null,
    /* A note to remind you what the OAuth token is for. */
    @SerialName(value = "note")
    val note: kotlin.String? = null,
    /* A URL to remind you what app the OAuth token is for. */
    @SerialName(value = "note_url")
    val noteUrl: kotlin.String? = null,
    /* The OAuth app client key for which to create the token. */
    @SerialName(value = "client_id")
    val clientId: kotlin.String? = null,
    /* The OAuth app client secret for which to create the token. */
    @SerialName(value = "client_secret")
    val clientSecret: kotlin.String? = null,
    /* A unique string to distinguish an authorization from others created for the same client ID and user. */
    @SerialName(value = "fingerprint")
    val fingerprint: kotlin.String? = null
) {

}
