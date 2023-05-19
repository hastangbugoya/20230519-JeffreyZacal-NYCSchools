package com.example.a20230519_jeffreyzacal_nycschools.di


import com.example.a20230519_jeffreyzacal_nycschools.MainActivity
import com.example.a20230519_jeffreyzacal_nycschools.di.ContextModule
import com.example.a20230519_jeffreyzacal_nycschools.di.NYSchoolListAdapterModule
import dagger.Component

@Component( modules = [ContextModule::class, NYSchoolListAdapterModule::class])
interface SchoolsAdapterComponent {

    fun inject(activity: MainActivity) : Unit
}