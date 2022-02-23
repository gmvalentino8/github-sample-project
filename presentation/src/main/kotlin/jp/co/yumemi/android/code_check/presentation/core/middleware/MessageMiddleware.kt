package jp.co.yumemi.android.code_check.presentation.core.middleware

import jp.co.yumemi.android.code_check.presentation.core.contract.Action
import jp.co.yumemi.android.code_check.presentation.core.contract.Event
import jp.co.yumemi.android.code_check.presentation.core.contract.Intent
import jp.co.yumemi.android.code_check.presentation.core.contract.Result
import jp.co.yumemi.android.code_check.presentation.core.contract.State
import jp.co.yumemi.android.code_check.presentation.core.contract.ViewState
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.filterNotNull
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.merge
import kotlinx.coroutines.flow.onEach

interface Message

abstract class MessageSenderMiddleware<A : Action, R : Result, M : Message>(
    private val messages: MutableSharedFlow<M>,
) : ActionMiddleware<A, ViewState, Event>, ResultMiddleware<R, ViewState, Event> {
    override fun modifyActions(input: Flow<A>, state: StateFlow<State<ViewState, Event>>): Flow<A> = input.onEach { action ->
        send(action)?.let { messages.emit(it) }
    }

    override fun modifyResults(input: Flow<R>, state: StateFlow<State<ViewState, Event>>): Flow<R> = input.onEach { result ->
        send(result)?.let { messages.emit(it) }
    }

    open fun send(action: A): M? = null

    open fun send(result: R): M? = null
}

abstract class MessageReceiverMiddleware<I : Intent, M : Message>(
    private val messages: Flow<M>,
) : IntentMiddleware<I, ViewState, Event> {
    override fun modifyIntents(input: Flow<I>, state: StateFlow<State<ViewState, Event>>): Flow<I> = merge(
        input, messages.map(::receive).filterNotNull()
    )

    abstract fun receive(broadcast: M): I?
}