package jp.co.yumemi.android.code_check.data.mappers

import io.kotest.matchers.shouldBe
import jp.co.yumemi.android.code_check.data.models.RepoSearchModel
import org.junit.Test

class SearchMapperTest {
    @Test
    fun `test for mapping github repo model to entity`() {
        val entity = SearchMapper.modelToEntity(
            RepoSearchModel(
                id = 1,
                name = "",
                description = "",
                ownerName = "",
                ownerIconUrl = null,
                language = null,
                stargazersCount = 0,
                watchersCount = 0,
                forksCount = 0,
                openIssuesCount = 0
            )
        )
        entity.id shouldBe 1
        entity.name shouldBe ""
        entity.description shouldBe ""
        entity.ownerName shouldBe ""
        entity.ownerIconUrl shouldBe null
        entity.language shouldBe null
        entity.stargazersCount shouldBe 0
    }
}
