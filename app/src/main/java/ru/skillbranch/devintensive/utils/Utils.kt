package ru.skillbranch.devintensive.utils

import java.util.*

object Utils {

    fun parseFullName(fullName: String?): Pair<String?, String?> {

        // FIXME: 04.11.2020 task for homework
        val parts: List<String>? = fullName?.split(" ")

        val firstName = parts?.getOrNull(0)
        val lastName = parts?.getOrNull(1)

        return firstName to lastName
    }

    fun transliteration(payload: String, divider: String = "_"): String {
        TODO("Not yet implemented")
    }

    fun toInitials(firstName: String?, lastName: String?): String? {
        return "${firstName?.substring(0, 1)?.toUpperCase(Locale.ROOT)}" +
                "${lastName?.substring(0, 1)?.toUpperCase(Locale.ROOT)}"
    }
}