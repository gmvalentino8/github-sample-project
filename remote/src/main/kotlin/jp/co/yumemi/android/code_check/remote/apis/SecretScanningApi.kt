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

package jp.co.yumemi.android.code_check.remote.apis

import io.ktor.client.request.request
import jp.co.yumemi.android.code_check.data.models.*
import jp.co.yumemi.android.code_check.remote.core.HttpClientProvider
import io.ktor.client.request.parameter
import io.ktor.http.HttpMethod

interface SecretScanningApi {
    /**
    * Get a secret scanning alert
    *
    * Gets a single secret scanning alert detected in a private repository. To use this endpoint, you must be an administrator for the repository or organization, and you must use an access token with the &#x60;repo&#x60; scope or &#x60;security_events&#x60; scope.  GitHub Apps must have the &#x60;secret_scanning_alerts&#x60; read permission to use this endpoint.
    *
    * @return SecretMinusScanningMinusAlertModel
    */
    suspend fun secretScanningGetAlert(accessToken: String? = null, owner: kotlin.String, repo: kotlin.String, alertNumber: kotlin.Int): SecretMinusScanningMinusAlertModel

    /**
    * List secret scanning alerts for an organization
    *
    * Lists secret scanning alerts for eligible repositories in an organization, from newest to oldest. To use this endpoint, you must be an administrator or security manager for the organization, and you must use an access token with the &#x60;repo&#x60; scope or &#x60;security_events&#x60; scope.  GitHub Apps must have the &#x60;secret_scanning_alerts&#x60; read permission to use this endpoint.
    *
    * @return kotlin.collections.List<OrganizationMinusSecretMinusScanningMinusAlertModel>
    */
    suspend fun secretScanningListAlertsForOrg(accessToken: String? = null, org: kotlin.String, state: kotlin.String? = null, secretType: kotlin.String? = null, resolution: kotlin.String? = null, page: kotlin.Int? = null, perPage: kotlin.Int? = null): kotlin.collections.List<OrganizationMinusSecretMinusScanningMinusAlertModel>

    /**
    * List secret scanning alerts for a repository
    *
    * Lists secret scanning alerts for a private repository, from newest to oldest. To use this endpoint, you must be an administrator for the repository or organization, and you must use an access token with the &#x60;repo&#x60; scope or &#x60;security_events&#x60; scope.  GitHub Apps must have the &#x60;secret_scanning_alerts&#x60; read permission to use this endpoint.
    *
    * @return kotlin.collections.List<SecretMinusScanningMinusAlertModel>
    */
    suspend fun secretScanningListAlertsForRepo(accessToken: String? = null, owner: kotlin.String, repo: kotlin.String, state: kotlin.String? = null, secretType: kotlin.String? = null, resolution: kotlin.String? = null, page: kotlin.Int? = null, perPage: kotlin.Int? = null): kotlin.collections.List<SecretMinusScanningMinusAlertModel>

    /**
    * Update a secret scanning alert
    *
    * Updates the status of a secret scanning alert in a private repository. To use this endpoint, you must be an administrator for the repository or organization, and you must use an access token with the &#x60;repo&#x60; scope or &#x60;security_events&#x60; scope.  GitHub Apps must have the &#x60;secret_scanning_alerts&#x60; write permission to use this endpoint.
    *
    * @param request 
    * @return SecretMinusScanningMinusAlertModel
    */
    suspend fun secretScanningUpdateAlert(accessToken: String? = null, owner: kotlin.String, repo: kotlin.String, alertNumber: kotlin.Int, request: InlineObject135Model): SecretMinusScanningMinusAlertModel

}

class HttpClientSecretScanningApi(private val httpClientProvider: HttpClientProvider) : SecretScanningApi {
    internal val httpClient = httpClientProvider.provide()

    override suspend fun secretScanningGetAlert(accessToken: String?, owner: kotlin.String, repo: kotlin.String, alertNumber: kotlin.Int): SecretMinusScanningMinusAlertModel {
        val path = "/repos/{owner}/{repo}/secret-scanning/alerts/{alert_number}".replace("{"+"owner"+"}", "$owner").replace("{"+"repo"+"}", "$repo").replace("{"+"alert_number"+"}", "$alertNumber")

        return httpClient.request {
            url { encodedPath = path }
            method = HttpMethod.Get
        }
    }

    override suspend fun secretScanningListAlertsForOrg(accessToken: String?, org: kotlin.String, state: kotlin.String?, secretType: kotlin.String?, resolution: kotlin.String?, page: kotlin.Int?, perPage: kotlin.Int?): kotlin.collections.List<OrganizationMinusSecretMinusScanningMinusAlertModel> {
        val path = "/orgs/{org}/secret-scanning/alerts".replace("{"+"org"+"}", "$org")

        return httpClient.request {
            url { encodedPath = path }
            method = HttpMethod.Get
            parameter("state", state)
            parameter("secretType", secretType)
            parameter("resolution", resolution)
            parameter("page", page)
            parameter("perPage", perPage)
        }
    }

    override suspend fun secretScanningListAlertsForRepo(accessToken: String?, owner: kotlin.String, repo: kotlin.String, state: kotlin.String?, secretType: kotlin.String?, resolution: kotlin.String?, page: kotlin.Int?, perPage: kotlin.Int?): kotlin.collections.List<SecretMinusScanningMinusAlertModel> {
        val path = "/repos/{owner}/{repo}/secret-scanning/alerts".replace("{"+"owner"+"}", "$owner").replace("{"+"repo"+"}", "$repo")

        return httpClient.request {
            url { encodedPath = path }
            method = HttpMethod.Get
            parameter("state", state)
            parameter("secretType", secretType)
            parameter("resolution", resolution)
            parameter("page", page)
            parameter("perPage", perPage)
        }
    }

    override suspend fun secretScanningUpdateAlert(accessToken: String?, owner: kotlin.String, repo: kotlin.String, alertNumber: kotlin.Int, request: InlineObject135Model): SecretMinusScanningMinusAlertModel {
        val path = "/repos/{owner}/{repo}/secret-scanning/alerts/{alert_number}".replace("{"+"owner"+"}", "$owner").replace("{"+"repo"+"}", "$repo").replace("{"+"alert_number"+"}", "$alertNumber")

        return httpClient.request {
            url { encodedPath = path }
            method = HttpMethod.Patch
            body = request
        }
    }

}