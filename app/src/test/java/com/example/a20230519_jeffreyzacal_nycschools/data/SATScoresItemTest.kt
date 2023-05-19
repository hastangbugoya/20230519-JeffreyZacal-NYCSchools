package com.example.a20230519_jeffreyzacal_nycschools.data

import org.junit.Assert.*
import org.junit.Before
import org.junit.Test

class SATScoresItemTest {
    lateinit var scores1: SATScoresItem
    lateinit var scores2: SATScoresItem
    lateinit var scores3: SATScoresItem

    @Before
    fun setUp() {
        scores1 = SATScoresItem("12345", "200", "500", "400", "555", "School 1")
        scores2 = SATScoresItem("12445", "200", "500", "400", "555", "School 1")
        scores3 = SATScoresItem("12345", "200", "500", "400", "555", "School 1")
    }

    @Test
    fun getDbn() {
        assertEquals("12345", scores1.dbn)
        assertNotEquals("45678", scores1.dbn)
    }

    @Test
    fun unique() {
        assertNotEquals(scores1, scores2)
        assertEquals(scores1, scores3)
    }
}