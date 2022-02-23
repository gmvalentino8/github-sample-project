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

import jp.co.yumemi.android.code_check.data.models.AppMinusPermissionsModel
import jp.co.yumemi.android.code_check.data.models.SimpleMinusUserModel

import kotlinx.serialization.*
import kotlinx.serialization.descriptors.PrimitiveKind
import kotlinx.serialization.descriptors.PrimitiveSerialDescriptor
import kotlinx.serialization.descriptors.SerialDescriptor
import kotlinx.serialization.encoding.Decoder
import kotlinx.serialization.encoding.Encoder

/**
 * 
 * @param permissions 
 * @param repositorySelection Describe whether all repositories have been selected or there's a selection involved
 * @param singleFileName 
 * @param repositoriesUrl 
 * @param account 
 * @param hasMultipleSingleFiles 
 * @param singleFilePaths 
 */
@Serializable
data class NullableMinusScopedMinusInstallationModel(
    @SerialName(value = "permissions")
    val permissions: AppMinusPermissionsModel,
    /* Describe whether all repositories have been selected or there's a selection involved */
    @SerialName(value = "repository_selection")
    val repositorySelection: NullableMinusScopedMinusInstallationModel.RepositorySelection,
    @SerialName(value = "single_file_name")
    val singleFileName: kotlin.String?,
    @SerialName(value = "repositories_url")
    val repositoriesUrl: kotlin.String,
    @SerialName(value = "account")
    val account: SimpleMinusUserModel,
    @SerialName(value = "has_multiple_single_files")
    val hasMultipleSingleFiles: kotlin.Boolean? = null,
    @SerialName(value = "single_file_paths")
    val singleFilePaths: kotlin.collections.List<kotlin.String>? = null
) {

    /**
     * Describe whether all repositories have been selected or there's a selection involved
     * Values: all,selected
     */
    @Serializable(with = RepositorySelection.Serializer::class)
    enum class RepositorySelection(val value: kotlin.String) {
        all("all"),
        selected("selected");

        @kotlinx.serialization.Serializer(forClass = RepositorySelection::class)
        object Serializer {
            override fun deserialize(decoder: Decoder): RepositorySelection {
                val decoded = decoder.decodeString()
                return values().first { it.value == decoded }
            }

            override val descriptor: SerialDescriptor
                get() = PrimitiveSerialDescriptor(
                    "NullableMinusScopedMinusInstallationModel.RepositorySelection.Serializer",
                    PrimitiveKind.STRING
                )

            override fun serialize(encoder: Encoder, value: RepositorySelection) {
                return encoder.encodeString(value.value)
            }
        }
    }
}
