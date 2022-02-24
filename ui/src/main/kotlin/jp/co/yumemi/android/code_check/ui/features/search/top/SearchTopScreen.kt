package jp.co.yumemi.android.code_check.ui.features.search.top

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import jp.co.yumemi.android.code_check.domain.entities.SearchType
import jp.co.yumemi.android.code_check.presentation.feature.search.top.contract.SearchTopEvent
import jp.co.yumemi.android.code_check.presentation.feature.search.top.contract.SearchTopIntent
import jp.co.yumemi.android.code_check.presentation.feature.search.top.contract.SearchTopViewState
import jp.co.yumemi.android.code_check.ui.components.AppBarSearch
import jp.co.yumemi.android.code_check.ui.components.RecentSearchHeader
import jp.co.yumemi.android.code_check.ui.components.RecentSearchItem
import jp.co.yumemi.android.code_check.ui.components.SearchTypeItem
import jp.co.yumemi.android.code_check.ui.core.Contract
import jp.co.yumemi.android.code_check.ui.core.handle
import jp.co.yumemi.android.code_check.ui.primitives.Github
import jp.co.yumemi.android.code_check.ui.primitives.Gray

@Composable
fun SearchTopScreen(contract: Contract<SearchTopIntent, SearchTopViewState, SearchTopEvent>, navigator: SearchTopNavigator) {
    val (state, events, dispatch) = contract

    events?.handle(
        process = { dispatch(SearchTopIntent.ProcessEvent(it)) }
    ) { event ->
        when (event) {
            is SearchTopEvent.NavigateBack -> Log.d("SearchTopEvent", "Navigate Back") // TODO: Add Navigation
            is SearchTopEvent.NavigateSearch -> Log.d("SearchTopEvent", "Navigate Search") // TODO: Add Navigation
        }
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Gray.v200)
    ) {
        if (state is SearchTopViewState.Stable) {
            AppBarSearch(
                placeholder = "Search GitHub",
                searchText = state.searchText,
                onClickBack = { navigator.back() },
                onClickClear = { dispatch(SearchTopIntent.ClickClearSearchText) },
                onSearchTextChanged = { dispatch(SearchTopIntent.InputSearchText(it)) },
                onClickImeSearch = { Log.d("SearchTopScreen", "OnClickImeSearch") } // TODO: Add Search
            )
        }
        when (state) {
            is SearchTopViewState.Stable.EmptySearch -> {
                LazyColumn(
                    modifier = Modifier.background(Github.White),
                ) {
                    itemsIndexed(state.recentSearches) { index, item ->
                        if (index == 0) {
                            RecentSearchHeader(
                                onClickClear = { dispatch(SearchTopIntent.ClickClearRecentSearches) }
                            )
                        }
                        RecentSearchItem(
                            searchText = item.searchText,
                            modifier = Modifier.clickable { dispatch(SearchTopIntent.ClickRecentSearchItem(item)) }
                        )
                    }
                }
            }
            is SearchTopViewState.Stable.NonEmptySearch -> {
                Column(
                    modifier = Modifier.background(Github.White),
                ) {
                    SearchTypeItem(
                        searchText = state.searchText,
                        searchType = SearchType.Repo,
                        modifier = Modifier
                            .clickable { dispatch(SearchTopIntent.ClickItem(SearchType.Repo)) }
                    )
                }
            }
            else -> Unit
        }
    }
}
