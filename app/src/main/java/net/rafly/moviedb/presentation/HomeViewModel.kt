package net.rafly.moviedb.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import net.rafly.moviedb.data.model.PopularModel
import net.rafly.moviedb.data.model.PopularResponse
import net.rafly.moviedb.data.network.Resource
import net.rafly.moviedb.data.repository.MoviedbRepositoryImpl

class HomeViewModel(
    private val repositoryImpl: MoviedbRepositoryImpl
) : ViewModel() {
    private val _popular: MutableLiveData<Resource<PopularResponse>> = MutableLiveData()
    val popular: LiveData<Resource<PopularResponse>> get() = _popular

    fun getPopular() = viewModelScope.launch {
        _popular.value = Resource.Loading
        _popular.value = repositoryImpl.getPopular(true, true, 1)
    }
}