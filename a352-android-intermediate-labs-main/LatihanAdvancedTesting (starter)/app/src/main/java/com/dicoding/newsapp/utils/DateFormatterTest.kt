package com.dicoding.newsapp.utils

import org.junit.Assert
import org.junit.Assert.*
import org.junit.Test
import java.time.format.DateTimeParseException
import java.time.zone.ZoneRulesException

class DateFormatterTest{
    @Test
    fun correctISO(){
        val currentDate = "2022-02-02T10:10:10Z"
        Assert.assertEquals("02 Feb 2022 | 17:10", DateFormatter.formatDate(currentDate, "Asia/Jakarta"))
        Assert.assertEquals("02 Feb 2022 | 18:10", DateFormatter.formatDate(currentDate, "Asia/Makassar"))
        Assert.assertEquals("02 Feb 2022 | 19:10", DateFormatter.formatDate(currentDate, "Asia/Jayapura"))
    }

    @Test
    fun wrongISO(){
        val wrongFormat = "2022-02-02T10:10"
        Assert.assertThrows(DateTimeParseException::class.java) {
            DateFormatter.formatDate(wrongFormat, "Asia/Jakarta")
        }
    }


    @Test
    fun invalidTimezone() {
        val wrongFormat = "2022-02-02T10:10:10Z"
        Assert.assertThrows(ZoneRulesException::class.java) {
            DateFormatter.formatDate(wrongFormat, "Asia/Bandung")
        }
    }
}