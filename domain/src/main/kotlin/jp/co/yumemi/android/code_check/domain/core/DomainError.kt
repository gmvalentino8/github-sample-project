package jp.co.yumemi.android.code_check.domain.core

sealed class DomainError(
    open val throwable: Throwable,
) : Throwable(throwable) {
    data class Network(override val throwable: Throwable) : DomainError(throwable)
    data class Server(override val throwable: Throwable) : DomainError(throwable)
    data class Maintenance(override val throwable: Throwable) : DomainError(throwable)
    data class NeedUpdate(override val throwable: Throwable) : DomainError(throwable)
    data class Unknown(override val throwable: Throwable) : DomainError(throwable)
}