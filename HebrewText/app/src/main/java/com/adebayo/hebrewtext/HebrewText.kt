package com.adebayo.hebrewtext

data class HebrewText(
        val categories: List<String>,
        val heTitle: String,
        val language: String,
        val license: String,
        val priority: Double,
        val sectionNames: List<String>,
        val status: String,
        val text: List<List<String>>,
        val title: String,
        val versionSource: String,
        val versionTitle: String,
        val versionTitleInHebrew: String
)