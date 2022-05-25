package com.deniswane.edvora.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.deniswane.edvora.model.main.Ride
import com.deniswane.edvora.repository.MainRepository

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainViewModel(private val repository: MainRepository) : ViewModel() {

    val rideList = MutableLiveData<List<Ride>>()
    val errorMessage = MutableLiveData<String>()

    fun getAllRides() {
        val response = repository.getAllRides()

        response.enqueue(object : Callback<List<Ride>> {
            override fun onResponse(call: Call<List<Ride>>, response: Response<List<Ride>>) {
                rideList.postValue(response.body())
            }

            override fun onFailure(call: Call<List<Ride>>, t: Throwable) {
                errorMessage.postValue(t.message)
            }
        })
    }
    
}