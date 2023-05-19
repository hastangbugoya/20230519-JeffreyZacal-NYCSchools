package com.example.a20230519_jeffreyzacal_nycschools.di

import android.content.Context
import com.example.a20230519_jeffreyzacal_nycschools.view.NYSchoolListAdapter
import dagger.Module
import dagger.Provides

@Module
class NYSchoolListAdapterModule(context: Context) {
    @Provides
    fun provideNYSchoolListAdapter(context: Context): NYSchoolListAdapter {
        return NYSchoolListAdapter(context)
    }
}