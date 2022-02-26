package jp.co.yumemi.android.code_check.domain.usecases

import jp.co.yumemi.android.code_check.domain.core.DomainResult
import jp.co.yumemi.android.code_check.domain.core.ErrorHandler
import jp.co.yumemi.android.code_check.domain.core.UseCase
import jp.co.yumemi.android.code_check.domain.core.toDomainResult
import jp.co.yumemi.android.code_check.domain.entities.Repository
import jp.co.yumemi.android.code_check.domain.entities.RepositoryDetails
import jp.co.yumemi.android.code_check.domain.repositories.RepositoriesRepository

interface GetRepositoryDetailsUseCase : UseCase<GetRepositoryDetailsUseCase.Args, DomainResult<RepositoryDetails>> {
    data class Args(val repo: Repository)
}

class GetRepositoryDetailsExecutor(
    private val repositoriesRepository: RepositoriesRepository,
    private val errorHandler: ErrorHandler
) : GetRepositoryDetailsUseCase {
    override suspend fun execute(arguments: GetRepositoryDetailsUseCase.Args): DomainResult<RepositoryDetails> = runCatching {
        val contributors = repositoriesRepository.getContributors(name = arguments.repo.name)
        val releases = repositoriesRepository.getReleases(name = arguments.repo.name)
        RepositoryDetails(repository = arguments.repo, releases = releases, contributors = contributors)
    }.toDomainResult(errorHandler)
}