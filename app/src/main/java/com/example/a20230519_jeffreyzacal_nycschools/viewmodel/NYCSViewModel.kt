package com.example.a20230519_jeffreyzacal_nycschools.viewmodel
/*
 * ViewModel using MutableLiveData observed in MainActivity
 *
 */

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.a20230519_jeffreyzacal_nycschools.data.NYSchoolsItem
import com.example.a20230519_jeffreyzacal_nycschools.network.MyRetrofit
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.launch

class NYCSViewModel : ViewModel() {
    var nycSchools = MutableLiveData<List<NYSchoolsItem>>()
    init {
        getAllSchoolData()
    }
    fun getAllSchoolData() {
        viewModelScope.launch(Dispatchers.IO) {
            nycSchools.postValue(
                async {
                    MyRetrofit.getService().getSchools().body()
                }.await()
            )
        }
    }

    fun getSchoolsCount() : Int {
        return nycSchools.value?.size ?: 0
    }
}