package com.edurda77.testmovie.model

sealed class StateMainActivity{
    object Loading : StateMainActivity()
    class Failure(val msg:Throwable) : StateMainActivity()
    class Success(val data:List<ModelMovie>) : StateMainActivity()
    object Empty : StateMainActivity()
}
