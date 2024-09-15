package com.example.randomcatfacts.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.details.DetailsRepository
import com.example.details.entity.CatImage
import com.example.favorites.FavoriteRepository
import com.example.favorites.entity.FavoriteFactEntity
import com.example.list.ListRepository
import com.example.randomcatfacts.common.CatFact
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainVM @Inject constructor(
    private val listRepository : ListRepository,
    private val detailsRepository : DetailsRepository,
    private val favoriteRepository: FavoriteRepository
): ViewModel() {

    private var _factsList : MutableLiveData<List<String>> = MutableLiveData()
    val factsList : LiveData<List<String>> = _factsList

    fun getFacts(count: Int){
        viewModelScope.launch{
            _factsList.value = listRepository.getFacts(count)
        }
    }

    private var _imagesList : MutableLiveData<List<String>> = MutableLiveData()
    val imagesList : LiveData<List<String>> = _imagesList

    fun getImages(count: Int){
        viewModelScope.launch {
            _imagesList.value = detailsRepository.getImagesUrl(count)
        }
    }

    private var _favoriteList : MutableLiveData<List<FavoriteFactEntity>> = MutableLiveData()
    val favoriteList : LiveData<List<FavoriteFactEntity>> = _favoriteList

    fun getFavorites(){
        viewModelScope.launch {
            _favoriteList.value = favoriteRepository.getAllFavorites()
        }
    }

    fun addFavorites(image: String, fact: String){
        viewModelScope.launch {
            favoriteRepository.addFavorite(image, fact)
        }
    }

    fun deleteFavorite(image: String, fact: String){
        viewModelScope.launch {
            favoriteRepository.deleteFavorite(image, fact)
        }
    }

}