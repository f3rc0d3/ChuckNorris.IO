package br.com.chucknorrisio.category

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.Observer
import br.com.chucknorrisio.RxImmediateSchedulerRule
import br.com.chucknorrisio.category.data.datasource.CategoryRemoteDataSource
import com.google.common.truth.Truth
import io.mockk.MockKAnnotations
import io.mockk.every
import io.mockk.impl.annotations.MockK
import io.mockk.spyk
import io.mockk.verify
import io.reactivex.Single
import org.junit.Test

import org.junit.Before
import org.junit.Rule

class CategoryViewModelTest {
    @MockK(relaxed = true)
    lateinit var categoryRemoteDataSource: CategoryRemoteDataSource

    private lateinit var viewModel: ChuckCategoryViewModel

    @Rule
    @JvmField
    val instantTaskExecutorRule = InstantTaskExecutorRule()

    @Rule
    @JvmField
    var testSchedulerRule = RxImmediateSchedulerRule()

    @Before
    fun setUp() {
        MockKAnnotations.init(this)
        viewModel = ChuckCategoryViewModel(categoryRemoteDataSource)
    }

    @Test
    fun `should not return empty categories list`() {
        val mockedObserver = createCategoriesObserver()
        viewModel.categoriesObserver.observeForever(mockedObserver)

        every { categoryRemoteDataSource.obtainCategories() } returns
                Single.just(createCategoriesTest())

        viewModel.fetchCategories()

        val categories = mutableListOf<String>()
        verify { mockedObserver.onChanged(listOf(capture(categories))) }

        val state = categories[1]

        Truth.assertThat(state).isEqualTo(createCategoriesTest()[1])
    }


    private fun createCategoriesObserver(): Observer<List<String>> = spyk(Observer {  })

    private fun createCategoriesTest(): List<String> {
        val categoriesTest = mutableListOf<String>()
        for (x in 0..10) {
            categoriesTest.add("animal $x")
        }
        return categoriesTest
    }
}
