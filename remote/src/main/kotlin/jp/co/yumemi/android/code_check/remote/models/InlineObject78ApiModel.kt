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

import jp.co.yumemi.android.code_check.remote.models.ReposRepoNameContentsPathAuthorApiModel
import jp.co.yumemi.android.code_check.remote.models.ReposRepoNameContentsPathCommitterApiModel

import kotlinx.serialization.*

/**
 * 
 * @param message The commit message.
 * @param content The new file content, using Base64 encoding.
 * @param sha **Required if you are updating a file**. The blob SHA of the file being replaced.
 * @param branch The branch name. Default: the repository’s default branch (usually `master`)
 * @param committer 
 * @param author 
 */
@Serializable
data class InlineObject78ApiModel(
    /* The commit message. */
    @SerialName(value = "message")
    val message: kotlin.String,
    /* The new file content, using Base64 encoding. */
    @SerialName(value = "content")
    val content: kotlin.String,
    /* **Required if you are updating a file**. The blob SHA of the file being replaced. */
    @SerialName(value = "sha")
    val sha: kotlin.String? = null,
    /* The branch name. Default: the repository’s default branch (usually `master`) */
    @SerialName(value = "branch")
    val branch: kotlin.String? = null,
    @SerialName(value = "committer")
    val committer: ReposRepoNameContentsPathCommitterApiModel? = null,
    @SerialName(value = "author")
    val author: ReposRepoNameContentsPathAuthorApiModel? = null
) {

}

