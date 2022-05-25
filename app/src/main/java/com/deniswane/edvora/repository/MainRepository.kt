package com.deniswane.edvora.repository

import com.deniswane.edvora.service.RetrofitService

class MainRepository constructor(private val retrofitService: RetrofitService) {

    fun getAllRides() = retrofitService.getAllRides()
}