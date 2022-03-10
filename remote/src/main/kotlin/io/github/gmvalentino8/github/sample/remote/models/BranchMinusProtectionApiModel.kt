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

import io.github.gmvalentino8.github.sample.remote.models.BranchMinusRestrictionMinusPolicyApiModel
import io.github.gmvalentino8.github.sample.remote.models.BranchProtectionRequiredLinearHistoryApiModel
import io.github.gmvalentino8.github.sample.remote.models.BranchProtectionRequiredSignaturesApiModel
import io.github.gmvalentino8.github.sample.remote.models.ProtectedMinusBranchMinusAdminMinusEnforcedApiModel
import io.github.gmvalentino8.github.sample.remote.models.ProtectedMinusBranchMinusPullMinusRequestMinusReviewApiModel
import io.github.gmvalentino8.github.sample.remote.models.ProtectedMinusBranchMinusRequiredMinusStatusMinusCheckApiModel

import kotlinx.serialization.*

/**
 * Branch Protection
 * @param url 
 * @param enabled 
 * @param requiredStatusChecks 
 * @param enforceAdmins 
 * @param requiredPullRequestReviews 
 * @param restrictions 
 * @param requiredLinearHistory 
 * @param allowForcePushes 
 * @param allowDeletions 
 * @param requiredConversationResolution 
 * @param name 
 * @param protectionUrl 
 * @param requiredSignatures 
 */
@Serializable
data class BranchMinusProtectionApiModel(
    @SerialName(value = "url")
    val url: kotlin.String? = null,
    @SerialName(value = "enabled")
    val enabled: kotlin.Boolean? = null,
    @SerialName(value = "required_status_checks")
    val requiredStatusChecks: ProtectedMinusBranchMinusRequiredMinusStatusMinusCheckApiModel? = null,
    @SerialName(value = "enforce_admins")
    val enforceAdmins: ProtectedMinusBranchMinusAdminMinusEnforcedApiModel? = null,
    @SerialName(value = "required_pull_request_reviews")
    val requiredPullRequestReviews: ProtectedMinusBranchMinusPullMinusRequestMinusReviewApiModel? = null,
    @SerialName(value = "restrictions")
    val restrictions: BranchMinusRestrictionMinusPolicyApiModel? = null,
    @SerialName(value = "required_linear_history")
    val requiredLinearHistory: BranchProtectionRequiredLinearHistoryApiModel? = null,
    @SerialName(value = "allow_force_pushes")
    val allowForcePushes: BranchProtectionRequiredLinearHistoryApiModel? = null,
    @SerialName(value = "allow_deletions")
    val allowDeletions: BranchProtectionRequiredLinearHistoryApiModel? = null,
    @SerialName(value = "required_conversation_resolution")
    val requiredConversationResolution: BranchProtectionRequiredLinearHistoryApiModel? = null,
    @SerialName(value = "name")
    val name: kotlin.String? = null,
    @SerialName(value = "protection_url")
    val protectionUrl: kotlin.String? = null,
    @SerialName(value = "required_signatures")
    val requiredSignatures: BranchProtectionRequiredSignaturesApiModel? = null
) {

}
