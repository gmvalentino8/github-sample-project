package jp.co.yumemi.android.code_check.remote.providers

import jp.co.yumemi.android.code_check.data.models.ReleaseModel
import jp.co.yumemi.android.code_check.data.models.UserModel
import jp.co.yumemi.android.code_check.data.sources.RepositoriesRemoteDataSource
import jp.co.yumemi.android.code_check.remote.apis.ReposApi
import jp.co.yumemi.android.code_check.remote.mappers.ReleaseRemoteMapper
import jp.co.yumemi.android.code_check.remote.mappers.UserRemoteMapper

class RepositoriesRemoteDataProvider(
    private val reposApi: ReposApi
) : RepositoriesRemoteDataSource {
    override suspend fun getContributors(name: String, pageNumber: Int, perPage: Int, token: String?): List<UserModel> = reposApi
        .reposListContributors(accessToken = token, repoName = name, page = pageNumber, perPage = perPage)
        .map(UserRemoteMapper::toModel)

    override suspend fun getReleases(
        name: String,
        pageNumber: Int,
        perPage: Int,
        token: String?
    ): List<ReleaseModel> = reposApi
        .reposListReleases(accessToken = token, repoName = name, page = pageNumber, perPage = perPage)
        .map(ReleaseRemoteMapper::toModel)
}
