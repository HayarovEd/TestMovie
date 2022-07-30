package com.edurda77.testmovie.ui

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.edurda77.testmovie.model.ModelMovie
import com.edurda77.testmovie.model.StateMainActivity
import com.edurda77.testmovie.network.RepositoryMovie
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MovieViewModel @Inject constructor(private val repository: RepositoryMovie) : ViewModel() {
    private val dataForShow = mutableListOf<ModelMovie>()
    private val _movieData =
        MutableLiveData<StateMainActivity>(StateMainActivity.Empty)
    val movieData = _movieData

    fun getDataForShow (number: Int) {
        viewModelScope.launch {
            _movieData.value = StateMainActivity.Loading
            try {
                dataForShow.addAll(repository.gatData(number))
                _movieData.value = StateMainActivity.Success(dataForShow)
            } catch (error: Exception) {
                _movieData.value = StateMainActivity.Failure(error)
            }
        }
    }
}