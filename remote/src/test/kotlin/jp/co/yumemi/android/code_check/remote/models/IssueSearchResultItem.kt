package jp.co.yumemi.android.code_check.remote.models

val DefaultModel.issueSearchResultItem
    get() = IssueMinusSearchMinusResultMinusItemApiModel(
        url = "",
        repositoryUrl = "",
        labelsUrl = "",
        commentsUrl = "",
        eventsUrl = "",
        htmlUrl = "",
        id = 0,
        nodeId = "",
        number = 0,
        title = "",
        locked = false,
        user = null,
        labels = listOf(),
        state = "",
        assignee = null,
        milestone = null,
        comments = 0,
        createdAt = "",
        updatedAt = "",
        closedAt = null,
        score = 0.0,
        authorAssociation = AuthorAssociationApiModel.nONE,
        activeLockReason = null,
        assignees = listOf(),
        pullRequest = null,
        body = null,
        draft = null,
        repository = null,
        bodyHtml = null,
        bodyText = null,
        timelineUrl = null,
        performedViaGithubApp = null,
        reactions = null
    )
