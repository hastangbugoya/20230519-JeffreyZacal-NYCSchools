package com.example.a20230519_jeffreyzacal_nycschools.viewmodel
/*
 * ViewModel using MutableLiveData observed in SATScoresActivity
 *
 */
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.a20230519_jeffreyzacal_nycschools.data.SATScoresItem
import com.example.a20230519_jeffreyzacal_nycschools.network.MyRetrofit
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.launch

class SATScoresViewModel : ViewModel() {
    var nycSATScores = MutableLiveData<List<SATScoresItem>>()
    init {
        getAllSATData()
    }
    fun getAllSATData() {
        viewModelScope.launch(Dispatchers.IO) {
            nycSATScores.postValue(
                async{
                    MyRetrofit.getService().getSATScores().body()
                }.await())
        }
    }
    fun getSchoolScores(sID : String) : SATScoresItem? = nycSATScores.value?.firstOrNull { it.dbn.equals(sID) }
    fun scoresCount() : Int = nycSATScores.value?.size ?: 0
}