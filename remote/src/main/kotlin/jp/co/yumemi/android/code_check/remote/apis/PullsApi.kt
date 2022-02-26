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
import jp.co.yumemi.android.code_check.remote.models.*
import jp.co.yumemi.android.code_check.remote.core.HttpClientProvider
import io.ktor.client.request.parameter
import io.ktor.http.HttpMethod

interface PullsApi {
    /**
    * Check if a pull request has been merged
    *
    * 
    *
    * @return void
    */
    suspend fun pullsCheckIfMerged(accessToken: String? = null, repoName: kotlin.String, pullNumber: kotlin.Int)

    /**
    * Create a pull request
    *
    * Draft pull requests are available in public repositories with GitHub Free and GitHub Free for organizations, GitHub Pro, and legacy per-repository billing plans, and in public and private repositories with GitHub Team and GitHub Enterprise Cloud. For more information, see [GitHub&#39;s products](https://docs.github.com/github/getting-started-with-github/githubs-products) in the GitHub Help documentation.  To open or update a pull request in a public repository, you must have write access to the head or the source branch. For organization-owned repositories, you must be a member of the organization that owns the repository to open or update a pull request.  You can create a new pull request.  This endpoint triggers [notifications](https://docs.github.com/en/github/managing-subscriptions-and-notifications-on-github/about-notifications). Creating content too quickly using this endpoint may result in secondary rate limiting. See \&quot;[Secondary rate limits](https://docs.github.com/rest/overview/resources-in-the-rest-api#secondary-rate-limits)\&quot; and \&quot;[Dealing with secondary rate limits](https://docs.github.com/rest/guides/best-practices-for-integrators#dealing-with-rate-limits)\&quot; for details.
    *
    * @param request 
    * @return PullMinusRequestApiModel
    */
    suspend fun pullsCreate(accessToken: String? = null, repoName: kotlin.String, request: InlineObject117ApiModel): PullMinusRequestApiModel

    /**
    * Create a reply for a review comment
    *
    * Creates a reply to a review comment for a pull request. For the &#x60;comment_id&#x60;, provide the ID of the review comment you are replying to. This must be the ID of a _top-level review comment_, not a reply to that comment. Replies to replies are not supported.  This endpoint triggers [notifications](https://docs.github.com/en/github/managing-subscriptions-and-notifications-on-github/about-notifications). Creating content too quickly using this endpoint may result in secondary rate limiting. See \&quot;[Secondary rate limits](https://docs.github.com/rest/overview/resources-in-the-rest-api#secondary-rate-limits)\&quot; and \&quot;[Dealing with secondary rate limits](https://docs.github.com/rest/guides/best-practices-for-integrators#dealing-with-secondary-rate-limits)\&quot; for details.
    *
    * @param request 
    * @return PullMinusRequestMinusReviewMinusCommentApiModel
    */
    suspend fun pullsCreateReplyForReviewComment(accessToken: String? = null, repoName: kotlin.String, pullNumber: kotlin.Int, commentId: kotlin.Int, request: InlineObject123ApiModel): PullMinusRequestMinusReviewMinusCommentApiModel

    /**
    * Create a review for a pull request
    *
    * This endpoint triggers [notifications](https://docs.github.com/en/github/managing-subscriptions-and-notifications-on-github/about-notifications). Creating content too quickly using this endpoint may result in secondary rate limiting. See \&quot;[Secondary rate limits](https://docs.github.com/rest/overview/resources-in-the-rest-api#secondary-rate-limits)\&quot; and \&quot;[Dealing with secondary rate limits](https://docs.github.com/rest/guides/best-practices-for-integrators#dealing-with-secondary-rate-limits)\&quot; for details.  Pull request reviews created in the &#x60;PENDING&#x60; state do not include the &#x60;submitted_at&#x60; property in the response.  **Note:** To comment on a specific line in a file, you need to first determine the _position_ of that line in the diff. The GitHub REST API v3 offers the &#x60;application/vnd.github.v3.diff&#x60; [media type](https://docs.github.com/rest/overview/media-types#commits-commit-comparison-and-pull-requests). To see a pull request diff, add this media type to the &#x60;Accept&#x60; header of a call to the [single pull request](https://docs.github.com/rest/reference/pulls#get-a-pull-request) endpoint.  The &#x60;position&#x60; value equals the number of lines down from the first \&quot;@@\&quot; hunk header in the file you want to add a comment. The line just below the \&quot;@@\&quot; line is position 1, the next line is position 2, and so on. The position in the diff continues to increase through lines of whitespace and additional hunks until the beginning of a new file.
    *
    * @param request  (optional)
    * @return PullMinusRequestMinusReviewApiModel
    */
    suspend fun pullsCreateReview(accessToken: String? = null, repoName: kotlin.String, pullNumber: kotlin.Int, request: InlineObject125ApiModel): PullMinusRequestMinusReviewApiModel

    /**
    * Create a review comment for a pull request
    *
    *  Creates a review comment in the pull request diff. To add a regular comment to a pull request timeline, see \&quot;[Create an issue comment](https://docs.github.com/rest/reference/issues#create-an-issue-comment).\&quot; We recommend creating a review comment using &#x60;line&#x60;, &#x60;side&#x60;, and optionally &#x60;start_line&#x60; and &#x60;start_side&#x60; if your comment applies to more than one line in the pull request diff.  You can still create a review comment using the &#x60;position&#x60; parameter. When you use &#x60;position&#x60;, the &#x60;line&#x60;, &#x60;side&#x60;, &#x60;start_line&#x60;, and &#x60;start_side&#x60; parameters are not required.  **Note:** The position value equals the number of lines down from the first \&quot;@@\&quot; hunk header in the file you want to add a comment. The line just below the \&quot;@@\&quot; line is position 1, the next line is position 2, and so on. The position in the diff continues to increase through lines of whitespace and additional hunks until the beginning of a new file.  This endpoint triggers [notifications](https://docs.github.com/en/github/managing-subscriptions-and-notifications-on-github/about-notifications). Creating content too quickly using this endpoint may result in secondary rate limiting. See \&quot;[Secondary rate limits](https://docs.github.com/rest/overview/resources-in-the-rest-api#secondary-rate-limits)\&quot; and \&quot;[Dealing with secondary rate limits](https://docs.github.com/rest/guides/best-practices-for-integrators#dealing-with-secondary-rate-limits)\&quot; for details.
    *
    * @param request 
    * @return PullMinusRequestMinusReviewMinusCommentApiModel
    */
    suspend fun pullsCreateReviewComment(accessToken: String? = null, repoName: kotlin.String, pullNumber: kotlin.Int, request: InlineObject122ApiModel): PullMinusRequestMinusReviewMinusCommentApiModel

    /**
    * Delete a pending review for a pull request
    *
    * 
    *
    * @return PullMinusRequestMinusReviewApiModel
    */
    suspend fun pullsDeletePendingReview(accessToken: String? = null, repoName: kotlin.String, pullNumber: kotlin.Int, reviewId: kotlin.Int): PullMinusRequestMinusReviewApiModel

    /**
    * Delete a review comment for a pull request
    *
    * Deletes a review comment.
    *
    * @return void
    */
    suspend fun pullsDeleteReviewComment(accessToken: String? = null, repoName: kotlin.String, commentId: kotlin.Int)

    /**
    * Dismiss a review for a pull request
    *
    * **Note:** To dismiss a pull request review on a [protected branch](https://docs.github.com/rest/reference/repos#branches), you must be a repository administrator or be included in the list of people or teams who can dismiss pull request reviews.
    *
    * @param request 
    * @return PullMinusRequestMinusReviewApiModel
    */
    suspend fun pullsDismissReview(accessToken: String? = null, repoName: kotlin.String, pullNumber: kotlin.Int, reviewId: kotlin.Int, request: InlineObject127ApiModel): PullMinusRequestMinusReviewApiModel

    /**
    * Get a pull request
    *
    * Draft pull requests are available in public repositories with GitHub Free and GitHub Free for organizations, GitHub Pro, and legacy per-repository billing plans, and in public and private repositories with GitHub Team and GitHub Enterprise Cloud. For more information, see [GitHub&#39;s products](https://docs.github.com/github/getting-started-with-github/githubs-products) in the GitHub Help documentation.  Lists details of a pull request by providing its number.  When you get, [create](https://docs.github.com/rest/reference/pulls/#create-a-pull-request), or [edit](https://docs.github.com/rest/reference/pulls#update-a-pull-request) a pull request, GitHub creates a merge commit to test whether the pull request can be automatically merged into the base branch. This test commit is not added to the base branch or the head branch. You can review the status of the test commit using the &#x60;mergeable&#x60; key. For more information, see \&quot;[Checking mergeability of pull requests](https://docs.github.com/rest/guides/getting-started-with-the-git-database-api#checking-mergeability-of-pull-requests)\&quot;.  The value of the &#x60;mergeable&#x60; attribute can be &#x60;true&#x60;, &#x60;false&#x60;, or &#x60;null&#x60;. If the value is &#x60;null&#x60;, then GitHub has started a background job to compute the mergeability. After giving the job time to complete, resubmit the request. When the job finishes, you will see a non-&#x60;null&#x60; value for the &#x60;mergeable&#x60; attribute in the response. If &#x60;mergeable&#x60; is &#x60;true&#x60;, then &#x60;merge_commit_sha&#x60; will be the SHA of the _test_ merge commit.  The value of the &#x60;merge_commit_sha&#x60; attribute changes depending on the state of the pull request. Before merging a pull request, the &#x60;merge_commit_sha&#x60; attribute holds the SHA of the _test_ merge commit. After merging a pull request, the &#x60;merge_commit_sha&#x60; attribute changes depending on how you merged the pull request:  *   If merged as a [merge commit](https://docs.github.com/articles/about-merge-methods-on-github/), &#x60;merge_commit_sha&#x60; represents the SHA of the merge commit. *   If merged via a [squash](https://docs.github.com/articles/about-merge-methods-on-github/#squashing-your-merge-commits), &#x60;merge_commit_sha&#x60; represents the SHA of the squashed commit on the base branch. *   If [rebased](https://docs.github.com/articles/about-merge-methods-on-github/#rebasing-and-merging-your-commits), &#x60;merge_commit_sha&#x60; represents the commit that the base branch was updated to.  Pass the appropriate [media type](https://docs.github.com/rest/overview/media-types/#commits-commit-comparison-and-pull-requests) to fetch diff and patch formats.
    *
    * @return PullMinusRequestApiModel
    */
    suspend fun pullsGet(accessToken: String? = null, repoName: kotlin.String, pullNumber: kotlin.Int): PullMinusRequestApiModel

    /**
    * Get a review for a pull request
    *
    * 
    *
    * @return PullMinusRequestMinusReviewApiModel
    */
    suspend fun pullsGetReview(accessToken: String? = null, repoName: kotlin.String, pullNumber: kotlin.Int, reviewId: kotlin.Int): PullMinusRequestMinusReviewApiModel

    /**
    * Get a review comment for a pull request
    *
    * Provides details for a review comment.
    *
    * @return PullMinusRequestMinusReviewMinusCommentApiModel
    */
    suspend fun pullsGetReviewComment(accessToken: String? = null, repoName: kotlin.String, commentId: kotlin.Int): PullMinusRequestMinusReviewMinusCommentApiModel

    /**
    * List pull requests
    *
    * Draft pull requests are available in public repositories with GitHub Free and GitHub Free for organizations, GitHub Pro, and legacy per-repository billing plans, and in public and private repositories with GitHub Team and GitHub Enterprise Cloud. For more information, see [GitHub&#39;s products](https://docs.github.com/github/getting-started-with-github/githubs-products) in the GitHub Help documentation.
    *
    * @return kotlin.collections.List<PullMinusRequestMinusSimpleApiModel>
    */
    suspend fun pullsList(accessToken: String? = null, repoName: kotlin.String, state: kotlin.String? = null, head: kotlin.String? = null, base: kotlin.String? = null, sort: kotlin.String? = null, direction: kotlin.String? = null, perPage: kotlin.Int? = null, page: kotlin.Int? = null): kotlin.collections.List<PullMinusRequestMinusSimpleApiModel>

    /**
    * List comments for a pull request review
    *
    * List comments for a specific pull request review.
    *
    * @return kotlin.collections.List<ReviewMinusCommentApiModel>
    */
    suspend fun pullsListCommentsForReview(accessToken: String? = null, repoName: kotlin.String, pullNumber: kotlin.Int, reviewId: kotlin.Int, perPage: kotlin.Int? = null, page: kotlin.Int? = null): kotlin.collections.List<ReviewMinusCommentApiModel>

    /**
    * List commits on a pull request
    *
    * Lists a maximum of 250 commits for a pull request. To receive a complete commit list for pull requests with more than 250 commits, use the [List commits](https://docs.github.com/rest/reference/repos#list-commits) endpoint.
    *
    * @return kotlin.collections.List<CommitApiModel>
    */
    suspend fun pullsListCommits(accessToken: String? = null, repoName: kotlin.String, pullNumber: kotlin.Int, perPage: kotlin.Int? = null, page: kotlin.Int? = null): kotlin.collections.List<CommitApiModel>

    /**
    * List pull requests files
    *
    * **Note:** Responses include a maximum of 3000 files. The paginated response returns 30 files per page by default.
    *
    * @return kotlin.collections.List<DiffMinusEntryApiModel>
    */
    suspend fun pullsListFiles(accessToken: String? = null, repoName: kotlin.String, pullNumber: kotlin.Int, perPage: kotlin.Int? = null, page: kotlin.Int? = null): kotlin.collections.List<DiffMinusEntryApiModel>

    /**
    * List review comments on a pull request
    *
    * Lists all review comments for a pull request. By default, review comments are in ascending order by ID.
    *
    * @return kotlin.collections.List<PullMinusRequestMinusReviewMinusCommentApiModel>
    */
    suspend fun pullsListReviewComments(accessToken: String? = null, repoName: kotlin.String, pullNumber: kotlin.Int, sort: kotlin.String? = null, direction: kotlin.String? = null, since: kotlin.String? = null, perPage: kotlin.Int? = null, page: kotlin.Int? = null): kotlin.collections.List<PullMinusRequestMinusReviewMinusCommentApiModel>

    /**
    * List review comments in a repository
    *
    * Lists review comments for all pull requests in a repository. By default, review comments are in ascending order by ID.
    *
    * @return kotlin.collections.List<PullMinusRequestMinusReviewMinusCommentApiModel>
    */
    suspend fun pullsListReviewCommentsForRepo(accessToken: String? = null, repoName: kotlin.String, sort: kotlin.String? = null, direction: kotlin.String? = null, since: kotlin.String? = null, perPage: kotlin.Int? = null, page: kotlin.Int? = null): kotlin.collections.List<PullMinusRequestMinusReviewMinusCommentApiModel>

    /**
    * List reviews for a pull request
    *
    * The list of reviews returns in chronological order.
    *
    * @return kotlin.collections.List<PullMinusRequestMinusReviewApiModel>
    */
    suspend fun pullsListReviews(accessToken: String? = null, repoName: kotlin.String, pullNumber: kotlin.Int, perPage: kotlin.Int? = null, page: kotlin.Int? = null): kotlin.collections.List<PullMinusRequestMinusReviewApiModel>

    /**
    * Merge a pull request
    *
    * This endpoint triggers [notifications](https://docs.github.com/github/managing-subscriptions-and-notifications-on-github/about-notifications). Creating content too quickly using this endpoint may result in secondary rate limiting. See \&quot;[Secondary rate limits](https://docs.github.com/rest/overview/resources-in-the-rest-api#secondary-rate-limits)\&quot; and \&quot;[Dealing with secondary rate limits](https://docs.github.com/rest/guides/best-practices-for-integrators#dealing-with-secondary-rate-limits)\&quot; for details.
    *
    * @param request  (optional)
    * @return PullMinusRequestMinusMergeMinusResultApiModel
    */
    suspend fun pullsMerge(accessToken: String? = null, repoName: kotlin.String, pullNumber: kotlin.Int, request: InlineObject124ApiModel): PullMinusRequestMinusMergeMinusResultApiModel

    /**
    * Submit a review for a pull request
    *
    * 
    *
    * @param request 
    * @return PullMinusRequestMinusReviewApiModel
    */
    suspend fun pullsSubmitReview(accessToken: String? = null, repoName: kotlin.String, pullNumber: kotlin.Int, reviewId: kotlin.Int, request: InlineObject128ApiModel): PullMinusRequestMinusReviewApiModel

    /**
    * Update a pull request
    *
    * Draft pull requests are available in public repositories with GitHub Free and GitHub Free for organizations, GitHub Pro, and legacy per-repository billing plans, and in public and private repositories with GitHub Team and GitHub Enterprise Cloud. For more information, see [GitHub&#39;s products](https://docs.github.com/github/getting-started-with-github/githubs-products) in the GitHub Help documentation.  To open or update a pull request in a public repository, you must have write access to the head or the source branch. For organization-owned repositories, you must be a member of the organization that owns the repository to open or update a pull request.
    *
    * @param request  (optional)
    * @return PullMinusRequestApiModel
    */
    suspend fun pullsUpdate(accessToken: String? = null, repoName: kotlin.String, pullNumber: kotlin.Int, request: InlineObject120ApiModel): PullMinusRequestApiModel

    /**
    * Update a pull request branch
    *
    * Updates the pull request branch with the latest upstream changes by merging HEAD from the base branch into the pull request branch.
    *
    * @param request  (optional)
    * @return InlineResponse2021ApiModel
    */
    suspend fun pullsUpdateBranch(accessToken: String? = null, repoName: kotlin.String, pullNumber: kotlin.Int, request: InlineObject129ApiModel): InlineResponse2021ApiModel

    /**
    * Update a review for a pull request
    *
    * Update the review summary comment with new text.
    *
    * @param request 
    * @return PullMinusRequestMinusReviewApiModel
    */
    suspend fun pullsUpdateReview(accessToken: String? = null, repoName: kotlin.String, pullNumber: kotlin.Int, reviewId: kotlin.Int, request: InlineObject126ApiModel): PullMinusRequestMinusReviewApiModel

    /**
    * Update a review comment for a pull request
    *
    * Enables you to edit a review comment.
    *
    * @param request 
    * @return PullMinusRequestMinusReviewMinusCommentApiModel
    */
    suspend fun pullsUpdateReviewComment(accessToken: String? = null, repoName: kotlin.String, commentId: kotlin.Int, request: InlineObject118ApiModel): PullMinusRequestMinusReviewMinusCommentApiModel

}

class HttpClientPullsApi(private val httpClientProvider: HttpClientProvider) : PullsApi {
    internal val httpClient = httpClientProvider.provide()

    override suspend fun pullsCheckIfMerged(accessToken: String?, repoName: kotlin.String, pullNumber: kotlin.Int) {
        val path = "/repos/{repo_name}/pulls/{pull_number}/merge".replace("{"+"repo_name"+"}", "$repoName").replace("{"+"pull_number"+"}", "$pullNumber")

        return httpClient.request {
            url { encodedPath = path }
            method = HttpMethod.Get
        }
    }

    override suspend fun pullsCreate(accessToken: String?, repoName: kotlin.String, request: InlineObject117ApiModel): PullMinusRequestApiModel {
        val path = "/repos/{repo_name}/pulls".replace("{"+"repo_name"+"}", "$repoName")

        return httpClient.request {
            url { encodedPath = path }
            method = HttpMethod.Post
            body = request
        }
    }

    override suspend fun pullsCreateReplyForReviewComment(accessToken: String?, repoName: kotlin.String, pullNumber: kotlin.Int, commentId: kotlin.Int, request: InlineObject123ApiModel): PullMinusRequestMinusReviewMinusCommentApiModel {
        val path = "/repos/{repo_name}/pulls/{pull_number}/comments/{comment_id}/replies".replace("{"+"repo_name"+"}", "$repoName").replace("{"+"pull_number"+"}", "$pullNumber").replace("{"+"comment_id"+"}", "$commentId")

        return httpClient.request {
            url { encodedPath = path }
            method = HttpMethod.Post
            body = request
        }
    }

    override suspend fun pullsCreateReview(accessToken: String?, repoName: kotlin.String, pullNumber: kotlin.Int, request: InlineObject125ApiModel): PullMinusRequestMinusReviewApiModel {
        val path = "/repos/{repo_name}/pulls/{pull_number}/reviews".replace("{"+"repo_name"+"}", "$repoName").replace("{"+"pull_number"+"}", "$pullNumber")

        return httpClient.request {
            url { encodedPath = path }
            method = HttpMethod.Post
            body = request
        }
    }

    override suspend fun pullsCreateReviewComment(accessToken: String?, repoName: kotlin.String, pullNumber: kotlin.Int, request: InlineObject122ApiModel): PullMinusRequestMinusReviewMinusCommentApiModel {
        val path = "/repos/{repo_name}/pulls/{pull_number}/comments".replace("{"+"repo_name"+"}", "$repoName").replace("{"+"pull_number"+"}", "$pullNumber")

        return httpClient.request {
            url { encodedPath = path }
            method = HttpMethod.Post
            body = request
        }
    }

    override suspend fun pullsDeletePendingReview(accessToken: String?, repoName: kotlin.String, pullNumber: kotlin.Int, reviewId: kotlin.Int): PullMinusRequestMinusReviewApiModel {
        val path = "/repos/{repo_name}/pulls/{pull_number}/reviews/{review_id}".replace("{"+"repo_name"+"}", "$repoName").replace("{"+"pull_number"+"}", "$pullNumber").replace("{"+"review_id"+"}", "$reviewId")

        return httpClient.request {
            url { encodedPath = path }
            method = HttpMethod.Delete
        }
    }

    override suspend fun pullsDeleteReviewComment(accessToken: String?, repoName: kotlin.String, commentId: kotlin.Int) {
        val path = "/repos/{repo_name}/pulls/comments/{comment_id}".replace("{"+"repo_name"+"}", "$repoName").replace("{"+"comment_id"+"}", "$commentId")

        return httpClient.request {
            url { encodedPath = path }
            method = HttpMethod.Delete
        }
    }

    override suspend fun pullsDismissReview(accessToken: String?, repoName: kotlin.String, pullNumber: kotlin.Int, reviewId: kotlin.Int, request: InlineObject127ApiModel): PullMinusRequestMinusReviewApiModel {
        val path = "/repos/{repo_name}/pulls/{pull_number}/reviews/{review_id}/dismissals".replace("{"+"repo_name"+"}", "$repoName").replace("{"+"pull_number"+"}", "$pullNumber").replace("{"+"review_id"+"}", "$reviewId")

        return httpClient.request {
            url { encodedPath = path }
            method = HttpMethod.Put
            body = request
        }
    }

    override suspend fun pullsGet(accessToken: String?, repoName: kotlin.String, pullNumber: kotlin.Int): PullMinusRequestApiModel {
        val path = "/repos/{repo_name}/pulls/{pull_number}".replace("{"+"repo_name"+"}", "$repoName").replace("{"+"pull_number"+"}", "$pullNumber")

        return httpClient.request {
            url { encodedPath = path }
            method = HttpMethod.Get
        }
    }

    override suspend fun pullsGetReview(accessToken: String?, repoName: kotlin.String, pullNumber: kotlin.Int, reviewId: kotlin.Int): PullMinusRequestMinusReviewApiModel {
        val path = "/repos/{repo_name}/pulls/{pull_number}/reviews/{review_id}".replace("{"+"repo_name"+"}", "$repoName").replace("{"+"pull_number"+"}", "$pullNumber").replace("{"+"review_id"+"}", "$reviewId")

        return httpClient.request {
            url { encodedPath = path }
            method = HttpMethod.Get
        }
    }

    override suspend fun pullsGetReviewComment(accessToken: String?, repoName: kotlin.String, commentId: kotlin.Int): PullMinusRequestMinusReviewMinusCommentApiModel {
        val path = "/repos/{repo_name}/pulls/comments/{comment_id}".replace("{"+"repo_name"+"}", "$repoName").replace("{"+"comment_id"+"}", "$commentId")

        return httpClient.request {
            url { encodedPath = path }
            method = HttpMethod.Get
        }
    }

    override suspend fun pullsList(accessToken: String?, repoName: kotlin.String, state: kotlin.String?, head: kotlin.String?, base: kotlin.String?, sort: kotlin.String?, direction: kotlin.String?, perPage: kotlin.Int?, page: kotlin.Int?): kotlin.collections.List<PullMinusRequestMinusSimpleApiModel> {
        val path = "/repos/{repo_name}/pulls".replace("{"+"repo_name"+"}", "$repoName")

        return httpClient.request {
            url { encodedPath = path }
            method = HttpMethod.Get
            parameter("state", state)
            parameter("head", head)
            parameter("base", base)
            parameter("sort", sort)
            parameter("direction", direction)
            parameter("perPage", perPage)
            parameter("page", page)
        }
    }

    override suspend fun pullsListCommentsForReview(accessToken: String?, repoName: kotlin.String, pullNumber: kotlin.Int, reviewId: kotlin.Int, perPage: kotlin.Int?, page: kotlin.Int?): kotlin.collections.List<ReviewMinusCommentApiModel> {
        val path = "/repos/{repo_name}/pulls/{pull_number}/reviews/{review_id}/comments".replace("{"+"repo_name"+"}", "$repoName").replace("{"+"pull_number"+"}", "$pullNumber").replace("{"+"review_id"+"}", "$reviewId")

        return httpClient.request {
            url { encodedPath = path }
            method = HttpMethod.Get
            parameter("perPage", perPage)
            parameter("page", page)
        }
    }

    override suspend fun pullsListCommits(accessToken: String?, repoName: kotlin.String, pullNumber: kotlin.Int, perPage: kotlin.Int?, page: kotlin.Int?): kotlin.collections.List<CommitApiModel> {
        val path = "/repos/{repo_name}/pulls/{pull_number}/commits".replace("{"+"repo_name"+"}", "$repoName").replace("{"+"pull_number"+"}", "$pullNumber")

        return httpClient.request {
            url { encodedPath = path }
            method = HttpMethod.Get
            parameter("perPage", perPage)
            parameter("page", page)
        }
    }

    override suspend fun pullsListFiles(accessToken: String?, repoName: kotlin.String, pullNumber: kotlin.Int, perPage: kotlin.Int?, page: kotlin.Int?): kotlin.collections.List<DiffMinusEntryApiModel> {
        val path = "/repos/{repo_name}/pulls/{pull_number}/files".replace("{"+"repo_name"+"}", "$repoName").replace("{"+"pull_number"+"}", "$pullNumber")

        return httpClient.request {
            url { encodedPath = path }
            method = HttpMethod.Get
            parameter("perPage", perPage)
            parameter("page", page)
        }
    }

    override suspend fun pullsListReviewComments(accessToken: String?, repoName: kotlin.String, pullNumber: kotlin.Int, sort: kotlin.String?, direction: kotlin.String?, since: kotlin.String?, perPage: kotlin.Int?, page: kotlin.Int?): kotlin.collections.List<PullMinusRequestMinusReviewMinusCommentApiModel> {
        val path = "/repos/{repo_name}/pulls/{pull_number}/comments".replace("{"+"repo_name"+"}", "$repoName").replace("{"+"pull_number"+"}", "$pullNumber")

        return httpClient.request {
            url { encodedPath = path }
            method = HttpMethod.Get
            parameter("sort", sort)
            parameter("direction", direction)
            parameter("since", since)
            parameter("perPage", perPage)
            parameter("page", page)
        }
    }

    override suspend fun pullsListReviewCommentsForRepo(accessToken: String?, repoName: kotlin.String, sort: kotlin.String?, direction: kotlin.String?, since: kotlin.String?, perPage: kotlin.Int?, page: kotlin.Int?): kotlin.collections.List<PullMinusRequestMinusReviewMinusCommentApiModel> {
        val path = "/repos/{repo_name}/pulls/comments".replace("{"+"repo_name"+"}", "$repoName")

        return httpClient.request {
            url { encodedPath = path }
            method = HttpMethod.Get
            parameter("sort", sort)
            parameter("direction", direction)
            parameter("since", since)
            parameter("perPage", perPage)
            parameter("page", page)
        }
    }

    override suspend fun pullsListReviews(accessToken: String?, repoName: kotlin.String, pullNumber: kotlin.Int, perPage: kotlin.Int?, page: kotlin.Int?): kotlin.collections.List<PullMinusRequestMinusReviewApiModel> {
        val path = "/repos/{repo_name}/pulls/{pull_number}/reviews".replace("{"+"repo_name"+"}", "$repoName").replace("{"+"pull_number"+"}", "$pullNumber")

        return httpClient.request {
            url { encodedPath = path }
            method = HttpMethod.Get
            parameter("perPage", perPage)
            parameter("page", page)
        }
    }

    override suspend fun pullsMerge(accessToken: String?, repoName: kotlin.String, pullNumber: kotlin.Int, request: InlineObject124ApiModel): PullMinusRequestMinusMergeMinusResultApiModel {
        val path = "/repos/{repo_name}/pulls/{pull_number}/merge".replace("{"+"repo_name"+"}", "$repoName").replace("{"+"pull_number"+"}", "$pullNumber")

        return httpClient.request {
            url { encodedPath = path }
            method = HttpMethod.Put
            body = request
        }
    }

    override suspend fun pullsSubmitReview(accessToken: String?, repoName: kotlin.String, pullNumber: kotlin.Int, reviewId: kotlin.Int, request: InlineObject128ApiModel): PullMinusRequestMinusReviewApiModel {
        val path = "/repos/{repo_name}/pulls/{pull_number}/reviews/{review_id}/events".replace("{"+"repo_name"+"}", "$repoName").replace("{"+"pull_number"+"}", "$pullNumber").replace("{"+"review_id"+"}", "$reviewId")

        return httpClient.request {
            url { encodedPath = path }
            method = HttpMethod.Post
            body = request
        }
    }

    override suspend fun pullsUpdate(accessToken: String?, repoName: kotlin.String, pullNumber: kotlin.Int, request: InlineObject120ApiModel): PullMinusRequestApiModel {
        val path = "/repos/{repo_name}/pulls/{pull_number}".replace("{"+"repo_name"+"}", "$repoName").replace("{"+"pull_number"+"}", "$pullNumber")

        return httpClient.request {
            url { encodedPath = path }
            method = HttpMethod.Patch
            body = request
        }
    }

    override suspend fun pullsUpdateBranch(accessToken: String?, repoName: kotlin.String, pullNumber: kotlin.Int, request: InlineObject129ApiModel): InlineResponse2021ApiModel {
        val path = "/repos/{repo_name}/pulls/{pull_number}/update-branch".replace("{"+"repo_name"+"}", "$repoName").replace("{"+"pull_number"+"}", "$pullNumber")

        return httpClient.request {
            url { encodedPath = path }
            method = HttpMethod.Put
            body = request
        }
    }

    override suspend fun pullsUpdateReview(accessToken: String?, repoName: kotlin.String, pullNumber: kotlin.Int, reviewId: kotlin.Int, request: InlineObject126ApiModel): PullMinusRequestMinusReviewApiModel {
        val path = "/repos/{repo_name}/pulls/{pull_number}/reviews/{review_id}".replace("{"+"repo_name"+"}", "$repoName").replace("{"+"pull_number"+"}", "$pullNumber").replace("{"+"review_id"+"}", "$reviewId")

        return httpClient.request {
            url { encodedPath = path }
            method = HttpMethod.Put
            body = request
        }
    }

    override suspend fun pullsUpdateReviewComment(accessToken: String?, repoName: kotlin.String, commentId: kotlin.Int, request: InlineObject118ApiModel): PullMinusRequestMinusReviewMinusCommentApiModel {
        val path = "/repos/{repo_name}/pulls/comments/{comment_id}".replace("{"+"repo_name"+"}", "$repoName").replace("{"+"comment_id"+"}", "$commentId")

        return httpClient.request {
            url { encodedPath = path }
            method = HttpMethod.Patch
            body = request
        }
    }

}
