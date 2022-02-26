package jp.co.yumemi.android.code_check.ui.components.search

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.rememberImagePainter
import coil.transform.CircleCropTransformation
import jp.co.yumemi.android.code_check.domain.entities.SimpleGithubRepo
import jp.co.yumemi.android.code_check.ui.R
import jp.co.yumemi.android.code_check.ui.primitives.Github
import jp.co.yumemi.android.code_check.ui.primitives.GithubTheme
import jp.co.yumemi.android.code_check.ui.primitives.Gray
import jp.co.yumemi.android.code_check.ui.primitives.Yellow
import jp.co.yumemi.android.code_check.ui.utils.getLanguageColor

@Composable
fun SearchRepoResultItem(
    ownerIconUrl: String?,
    ownerName: String?,
    repoName: String,
    repoDescription: String?,
    stargazersCount: Int,
    language: String?,
    modifier: Modifier = Modifier
) = Column(
    modifier = modifier
        .fillMaxWidth()
        .padding(16.dp)
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(4.dp),
        modifier = Modifier.fillMaxWidth()
    ) {
        if (ownerIconUrl != null) {
            Image(
                painter = rememberImagePainter(
                    data = ownerIconUrl,
                    builder = {
                        transformations(CircleCropTransformation())
                    }
                ),
                contentDescription = null,
                modifier = Modifier.size(16.dp)
            )
        }
        if (ownerName != null) {
            Text(
                text = ownerName,
                style = MaterialTheme.typography.h5,
                fontWeight = FontWeight.Normal,
                color = Gray.v500,
            )
        }
    }
    Text(
        text = repoName,
        style = MaterialTheme.typography.h4,
        fontWeight = FontWeight.Bold,
        color = Github.Black,
        modifier = Modifier.fillMaxWidth(),
    )
    if (repoDescription != null) {
        Text(
            text = repoDescription,
            style = MaterialTheme.typography.h4,
            fontWeight = FontWeight.Normal,
            color = Gray.v700,
        )
    }
    Spacer(modifier = Modifier.height(16.dp))
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        modifier = Modifier.fillMaxWidth(),
    ) {
        Icon(
            painter = painterResource(id = R.drawable.star_fill),
            contentDescription = "star",
            tint = Yellow.v500
        )
        Text(
            text = stargazersCount.toString(),
            style = MaterialTheme.typography.h4,
            fontWeight = FontWeight.Normal,
            color = Gray.v700,
        )
        if (language != null) {
            Icon(
                painter = painterResource(id = R.drawable.dot_fill),
                contentDescription = "language",
                tint = getLanguageColor(language)
            )
            Text(
                text = language,
                style = MaterialTheme.typography.h4,
                fontWeight = FontWeight.Normal,
                color = Gray.v700,
            )
        }
    }
}

@Composable
fun SearchRepoResultItem(
    repo: SimpleGithubRepo,
    modifier: Modifier = Modifier
) = SearchRepoResultItem(
    ownerIconUrl = repo.ownerIconUrl,
    ownerName = repo.ownerName,
    repoName = repo.name,
    repoDescription = repo.description,
    stargazersCount = repo.stargazersCount,
    language = repo.language,
    modifier = modifier,
)

@Preview
@Composable
fun Preview_SearchRepoResultItem() {
    GithubTheme {
        SearchRepoResultItem(
            repo = SimpleGithubRepo(
                name = "name",
                description = "description",
                ownerName = "ownerName",
                ownerIconUrl = null,
                language = "Kotlin",
                stargazersCount = 1
            ),
            modifier = Modifier
                .background(Color.White)
        )
    }
}
