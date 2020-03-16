package br.com.chucknorrisio.category.data.rest

import io.reactivex.Single
import retrofit2.http.GET

interface CategoryRestService {
    @GET("jokes/categories")
    fun getCategories(): Single<List<String>>
}