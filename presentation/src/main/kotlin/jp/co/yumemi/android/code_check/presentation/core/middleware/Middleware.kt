package jp.co.yumemi.android.code_check.presentation.core.middleware

import jp.co.yumemi.android.code_check.presentation.core.contract.Action
import jp.co.yumemi.android.code_check.presentation.core.contract.Event
import jp.co.yumemi.android.code_check.presentation.core.contract.Intent
import jp.co.yumemi.android.code_check.presentation.core.contract.Result
import jp.co.yumemi.android.code_check.presentation.core.contract.State
import jp.co.yumemi.android.code_check.presentation.core.contract.ViewState
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.StateFlow

/**
 * Middleware
 *
 * [Middleware] apply transformations on a certain stream
 */
sealed interface Middleware

/**
 * Intent middleware
 *
 * Apply transformations on [Intent] streams
 */
fun interface IntentMiddleware<I : Intent, VS : ViewState, E : Event> : Middleware {
    fun modifyIntents(input: Flow<I>, state: StateFlow<State<VS, E>>): Flow<I>
}

/**
 * Action middleware
 *
 * Apply transformations on [Action] streams
 */
fun interface ActionMiddleware<A : Action, VS : ViewState, E : Event> : Middleware {
    fun modifyActions(input: Flow<A>, state: StateFlow<State<VS, E>>): Flow<A>
}

/**
 * Result middleware
 *
 * Apply transformations on [Result] streams
 */
fun interface ResultMiddleware<R : Result, VS : ViewState, E : Event> : Middleware {
    fun modifyResults(input: Flow<R>, state: StateFlow<State<VS, E>>): Flow<R>
}

/**
 * State middleware
 *
 * Apply transformations on [State] streams
 */
fun interface StateMiddleware<VS : ViewState, E : Event> : Middleware {
    fun modifyStates(input: Flow<State<VS, E>>): Flow<State<VS, E>>
}
