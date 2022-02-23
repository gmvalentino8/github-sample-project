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

package jp.co.yumemi.android.code_check.data.models

import jp.co.yumemi.android.code_check.data.models.AuthorAssociationModel
import jp.co.yumemi.android.code_check.data.models.NullableMinusIntegrationModel
import jp.co.yumemi.android.code_check.data.models.NullableMinusSimpleMinusUserModel
import jp.co.yumemi.android.code_check.data.models.ReactionMinusRollupModel

import kotlinx.serialization.*

/**
 * Comments provide a way for people to collaborate on an issue.
 * @param id Unique identifier of the issue comment
 * @param nodeId 
 * @param url URL for the issue comment
 * @param htmlUrl 
 * @param user 
 * @param createdAt 
 * @param updatedAt 
 * @param issueUrl 
 * @param authorAssociation 
 * @param body Contents of the issue comment
 * @param bodyText 
 * @param bodyHtml 
 * @param performedViaGithubApp 
 * @param reactions 
 */
@Serializable
data class IssueMinusCommentModel(
    /* Unique identifier of the issue comment */
    @SerialName(value = "id")
    val id: kotlin.Int,
    @SerialName(value = "node_id")
    val nodeId: kotlin.String,
    /* URL for the issue comment */
    @SerialName(value = "url")
    val url: kotlin.String,
    @SerialName(value = "html_url")
    val htmlUrl: kotlin.String,
    @SerialName(value = "user")
    val user: NullableMinusSimpleMinusUserModel?,
    @SerialName(value = "created_at")
    val createdAt: kotlin.String,
    @SerialName(value = "updated_at")
    val updatedAt: kotlin.String,
    @SerialName(value = "issue_url")
    val issueUrl: kotlin.String,
    @Contextual @SerialName(value = "author_association")
    val authorAssociation: AuthorAssociationModel,
    /* Contents of the issue comment */
    @SerialName(value = "body")
    val body: kotlin.String? = null,
    @SerialName(value = "body_text")
    val bodyText: kotlin.String? = null,
    @SerialName(value = "body_html")
    val bodyHtml: kotlin.String? = null,
    @SerialName(value = "performed_via_github_app")
    val performedViaGithubApp: NullableMinusIntegrationModel? = null,
    @SerialName(value = "reactions")
    val reactions: ReactionMinusRollupModel? = null
) {

}
