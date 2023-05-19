package com.example.a20230519_jeffreyzacal_nycschools.data

import org.junit.Assert.*
import org.junit.Before
import org.junit.Test

class NYSchoolsItemTest{
    lateinit var school : NYSchoolsItem
    @Before
    fun setUp() {
        school = NYSchoolsItem(
            "DBN123",
            "123 Main Street",
            "school@example.com",
            "Example School",
            "100",
            "http://www.example.com",
            "12345"
        )
    }

    @Test
    fun getDBN() {
        assertEquals("DBN123", school.dbn)
        assertEquals("123 Main Street", school.primaryAddressLine1)
        assertEquals("school@example.com", school.schoolEmail)
        assertEquals("Example School", school.schoolName)
        assertEquals("100", school.totalStudents)
        assertEquals("http://www.example.com", school.website)
        assertEquals("12345", school.zip)
    }
}