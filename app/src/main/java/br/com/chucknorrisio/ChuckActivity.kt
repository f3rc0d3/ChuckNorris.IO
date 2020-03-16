package br.com.chucknorrisio

import br.com.chucknorrisio.common.BaseDaggerActivity

class ChuckActivity : BaseDaggerActivity(R.layout.activity_main) {
    private val viewModel by viewModels<ChuckViewModel>()
}