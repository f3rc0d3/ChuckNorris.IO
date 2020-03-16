package br.com.chucknorrisio.category.data.datasource

import br.com.chucknorrisio.category.data.rest.CategoryRestService
import io.reactivex.Single
import javax.inject.Inject

class CategoryRemoteDataSource @Inject constructor(private val categoryRestService: CategoryRestService):
    CategoryDataSource {

    override fun obtainCategories(): Single<List<String>> = categoryRestService.getCategories()
}