package br.com.chucknorrisio.category

import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import br.com.chucknorrisio.R
import br.com.chucknorrisio.common.BaseDaggerFragment
import kotlinx.android.synthetic.main.chuck_category_fragment.*


class ChuckCategoryFragment: BaseDaggerFragment(R.layout.chuck_category_fragment) {

    private val viewModel by activityViewModels<ChuckCategoryViewModel>()

    private val categoryAdapter: ChuckCategoryAdapter by lazy {
        ChuckCategoryAdapter(requireContext())
    }

    //TODO: Massa de teste
    //private val dataTest: List<Category> by lazy { Category.generateDataTest() }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        setupObservables()
        setupCategoryRecyclerView()
    }

    private fun setupObservables() {
        viewModel.categoriesObserver.observe(viewLifecycleOwner, Observer {
            pb_category.visibility = View.INVISIBLE
            rv_categories.visibility = View.VISIBLE

            categoryAdapter.setDataList(it)
        })
    }

    private fun setupCategoryRecyclerView() {
        rv_categories.setHasFixedSize(true)
        rv_categories.setItemViewCacheSize(20)
        rv_categories.isNestedScrollingEnabled = false
        rv_categories.adapter = categoryAdapter
    }
}
