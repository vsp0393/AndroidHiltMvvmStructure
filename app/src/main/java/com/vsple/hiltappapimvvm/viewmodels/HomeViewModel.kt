package com.vsple.hiltappapimvvm.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.vsple.hiltapp.datamodel.prayermodel.chattymodel.ChattyModel
import com.vsple.hiltapp.network.Resources
import com.vsple.hiltapp.repository.AppRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(public val repository: AppRepository) : ViewModel() {

    private val _posts = MutableLiveData<Resources<ChattyModel>>()
    val posts: LiveData<Resources<ChattyModel>> = _posts

    init {
        // Call the API initially
        refreshData()
    }

    fun refreshData() {
        viewModelScope.launch {
            _posts.value = repository.getPosts()
        }
    }
}