package br.com.chucknorrisio.category.data.model

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Category (
    val name: String
) {
    companion object {
        fun generateDataTest(): List<Category> {
            val category = mutableListOf<Category>()

            for (count in 0 until 16) category.add(count,
                Category("Animal $count")
            )
            return category
        }

        const val ANIMAL = "animal"
        const val CAREER = "career"
        const val CELEBRITY = "celebrity"
        const val DEV = "dev"
        const val EXPLICIT = "explicit"
        const val FASHION = "fashion"
        const val FOOD = "food"
        const val HISTORY = "history"
        const val MONEY = "money"
        const val MOVIE = "movie"
        const val MUSIC = "music"
        const val POLITICAL = "political"
        const val RELIGION = "religion"
        const val SCIENCE = "science"
        const val SPORT = "sport"
        const val TRAVEL = "travel"
    }
}