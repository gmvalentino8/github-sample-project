package jp.co.yumemi.android.code_check.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityRetainedComponent
import jp.co.yumemi.android.code_check.data.sources.SearchRemoteDataSource
import jp.co.yumemi.android.code_check.remote.apis.HttpClientSearchApi
import jp.co.yumemi.android.code_check.remote.apis.SearchApi
import jp.co.yumemi.android.code_check.remote.core.HttpClientProvider
import jp.co.yumemi.android.code_check.remote.providers.SearchRemoteDataProvider

@Module
@InstallIn(ActivityRetainedComponent::class)
class ApiModule {
    @Provides
    fun provideSearchApi(
        httpClientProvider: HttpClientProvider
    ): SearchApi = HttpClientSearchApi(httpClientProvider)
}