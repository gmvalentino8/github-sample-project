package jp.co.yumemi.android.code_check.ui.features.search.results.issue

import android.os.Bundle
import androidx.lifecycle.AbstractSavedStateViewModelFactory
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.savedstate.SavedStateRegistryOwner
import dagger.assisted.Assisted
import dagger.assisted.AssistedFactory
import dagger.assisted.AssistedInject
import jp.co.yumemi.android.code_check.domain.entities.Issue
import jp.co.yumemi.android.code_check.presentation.core.components.Store
import jp.co.yumemi.android.code_check.presentation.core.contract.State
import jp.co.yumemi.android.code_check.presentation.core.factory.StoreFactory
import jp.co.yumemi.android.code_check.presentation.core.middleware.StateSaverMiddleware
import jp.co.yumemi.android.code_check.presentation.feature.search.results.contract.SearchResultsAction
import jp.co.yumemi.android.code_check.presentation.feature.search.results.contract.SearchResultsEvent
import jp.co.yumemi.android.code_check.presentation.feature.search.results.contract.SearchResultsIntent
import jp.co.yumemi.android.code_check.presentation.feature.search.results.contract.SearchResultsResult
import jp.co.yumemi.android.code_check.presentation.feature.search.results.contract.SearchResultsViewState
import jp.co.yumemi.android.code_check.ui.core.StoreViewModel
import jp.co.yumemi.android.code_check.ui.core.getState
import jp.co.yumemi.android.code_check.ui.core.onInit
import jp.co.yumemi.android.code_check.ui.core.saveState

class SearchIssueResultsViewModel @AssistedInject constructor(
    storeFactory: StoreFactory<SearchResultsIntent<Issue>,
        SearchResultsAction<Issue>,
        SearchResultsResult<Issue>,
        SearchResultsViewState<Issue>,
        SearchResultsEvent<Issue>>,
    @Assisted stateHandle: SavedStateHandle,
    @Assisted val searchText: String,
) : StoreViewModel<SearchResultsIntent<Issue>,
    SearchResultsAction<Issue>,
    SearchResultsResult<Issue>,
    SearchResultsViewState<Issue>,
    SearchResultsEvent<Issue>>(storeFactory) {
    override val store: Store<SearchResultsIntent<Issue>, SearchResultsViewState<Issue>, SearchResultsEvent<Issue>> = storeFactory.create(
        stateHandle.getState() ?: State(SearchResultsViewState.Initial(searchText)),
        middlewares = listOf(
            StateSaverMiddleware<SearchResultsViewState<Issue>, SearchResultsEvent<Issue>> { stateHandle.saveState(it) }
        )
    )

    init {
        stateHandle.onInit {
            dispatch(SearchResultsIntent.OnStart())
        }
    }

    @AssistedFactory
    interface Factory {
        fun create(
            savedStateHandle: SavedStateHandle,
            searchText: String,
        ): SearchIssueResultsViewModel
    }

    companion object {
        @Suppress("UNCHECKED_CAST")
        fun provideFactory(
            assistedFactory: Factory,
            owner: SavedStateRegistryOwner,
            arguments: Bundle?,
            searchText: String,
        ): AbstractSavedStateViewModelFactory = object : AbstractSavedStateViewModelFactory(owner, arguments) {
            override fun <T : ViewModel?> create(key: String, modelClass: Class<T>, handle: SavedStateHandle): T =
                assistedFactory.create(handle, searchText) as T
        }
    }
}