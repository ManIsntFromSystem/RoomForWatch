package com.quantumman.roomforwatch.util

sealed class MovieState {
    object LoadingState : MovieState()
    class LoadedState<T>(val data: List<T>): MovieState()
    object NoItemsState : MovieState()
    class ErrorState(val message: String): MovieState()
}