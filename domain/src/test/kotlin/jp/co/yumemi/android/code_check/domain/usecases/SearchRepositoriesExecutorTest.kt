package jp.co.yumemi.android.code_check.domain.usecases

import io.kotest.matchers.shouldBe
import io.kotest.matchers.types.shouldBeTypeOf
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.every
import io.mockk.mockk
import jp.co.yumemi.android.code_check.domain.core.DomainError
import jp.co.yumemi.android.code_check.domain.core.DomainResult
import jp.co.yumemi.android.code_check.domain.core.ErrorHandler
import jp.co.yumemi.android.code_check.domain.core.Pageable
import jp.co.yumemi.android.code_check.domain.entities.DefaultEntity
import jp.co.yumemi.android.code_check.domain.entities.Repository
import jp.co.yumemi.android.code_check.domain.repositories.SearchRepository
import jp.co.yumemi.android.code_check.test.CoroutineTestRule
import jp.co.yumemi.android.code_check.test.runBlockingTest
import kotlinx.coroutines.ExperimentalCoroutinesApi
import org.junit.Rule
import org.junit.Test

@ExperimentalCoroutinesApi
class SearchRepositoriesExecutorTest {
    @get:Rule
    val coroutineTestRule = CoroutineTestRule()
    private val searchRepository = mockk<SearchRepository>()
    private val errorHandler = mockk<ErrorHandler>()
    private val testException = Exception("test")
    private val searchRepositoriesUseCase = SearchRepositoriesExecutor(searchRepository = searchRepository, errorHandler = errorHandler)
    private val listSize = 5

    @Test
    fun `test when execute is successful`() {
        coEvery {
            searchRepository.searchRepositories(searchText = any(), pageNumber = any(), count = any())
        } returns Pageable(
            items = List(listSize) { index ->
                DefaultEntity.repository.copy(id = index)
            },
            totalCount = listSize
        )

        coroutineTestRule.runBlockingTest {
            val result = searchRepositoriesUseCase.execute(arguments = SearchUseCase.Args(searchText = "", pageNumber = 0))
            result.shouldBeTypeOf<DomainResult.Success<Pageable<Repository>>>()
            result.data.totalCount shouldBe listSize
            result.data.items.size shouldBe listSize
            result.data.items.forEachIndexed { index, item ->
                item.id shouldBe index
            }
            coVerify { searchRepository.searchRepositories(searchText = "") }
            coVerify(inverse = true) { errorHandler.handle(throwable = any()) }
        }
    }

    @Test
    fun `test when search repository throws an error and execute fails`() {
        coEvery {
            searchRepository.searchRepositories(searchText = any(), pageNumber = any(), count = any())
        } throws testException

        every { errorHandler.handle(throwable = any()) } returns DomainError.Unknown(testException)

        coroutineTestRule.runBlockingTest {
            val result = searchRepositoriesUseCase.execute(SearchUseCase.Args(searchText = "", pageNumber = 0))
            result.shouldBeTypeOf<DomainResult.Failure>()
            result.error.shouldBeTypeOf<DomainError.Unknown>()
            result.error.throwable shouldBe testException
            result.error.throwable.message shouldBe "test"
            coVerify { searchRepository.searchRepositories(searchText = "") }
            coVerify { errorHandler.handle(throwable = testException) }
        }
    }
}