package br.com.chucknorrisio.category.data.datasource

import br.com.chucknorrisio.category.data.model.Category
import io.reactivex.Single

interface CategoryDataSource {
    fun obtainCategories(): Single<List<String>>
}