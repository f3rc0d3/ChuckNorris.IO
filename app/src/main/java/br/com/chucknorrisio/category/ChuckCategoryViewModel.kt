package br.com.chucknorrisio.category

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import br.com.chucknorrisio.category.data.datasource.CategoryRemoteDataSource
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.observers.DisposableSingleObserver
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class ChuckCategoryViewModel @Inject constructor(private val categoryRemoteDataSource: CategoryRemoteDataSource,
                                                private val disposable: CompositeDisposable)
    : ViewModel() {

    private val categoriesList = MutableLiveData<List<String>>()
    val categoriesObserver: LiveData<List<String>> get() = categoriesList

    init {
        fetchCategories()
    }

    fun fetchCategories() {
        disposable.add(categoryRemoteDataSource.obtainCategories().subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeWith(object : DisposableSingleObserver<List<String>>() {
                override fun onSuccess(categories: List<String>?) {
                    categoriesList.value = categories
                }

                override fun onError(error: Throwable?) {
                    categoriesList.value = listOf()
                }
            })
        )
    }

    override fun onCleared() {
        super.onCleared()
        disposable.clear()
    }
}
