package br.com.chucknorrisio.splash

import android.os.Bundle
import android.view.View
import android.view.animation.AlphaAnimation
import androidx.lifecycle.Observer
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import br.com.chucknorrisio.R
import br.com.chucknorrisio.common.BaseDaggerFragment
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.splash_fragment.*

class SplashFragment : BaseDaggerFragment(R.layout.splash_fragment) {

    private val viewModel by activityViewModels<SplashViewModel>()

    private val glideViewTarget by lazy {
        Glide.with(requireParentFragment()).asGif().load(R.raw.chuck)
    }

    private val hidedStatusBar by lazy {
        requireActivity().window.decorView.systemUiVisibility =
            View.SYSTEM_UI_FLAG_LAYOUT_STABLE or View.SYSTEM_UI_FLAG_FULLSCREEN
    }

    private val splashNavController: NavController by lazy { findNavController() }

    /* Fades */
    private val fadeIn: AlphaAnimation by lazy {
        AlphaAnimation(0.0f, 1.0f)
    }

    private val fadeOut: AlphaAnimation by lazy {
        AlphaAnimation(1.0f, 0.0f)
    }

    init {
        fadeIn.duration = 1800
        fadeOut.duration = 1800
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        glideViewTarget.into(iv_chuck)
        wakeUpObservers()
    }

    private fun wakeUpObservers() {
        tv_chuck_norris.startAnimation(fadeOut)

        viewModel.delayForSplashObserver.observe(viewLifecycleOwner, Observer { hasDone ->
            if(hasDone) {
                splashNavController.navigate(
                    SplashFragmentDirections.actionSplashFragmentToChuckCategoryFragment()
                )
            }
        })

        viewModel.animationStartObserver.observe(viewLifecycleOwner, Observer { shouldStart ->
            if(shouldStart) {
                applyTextViewAnimation()
            }

        })
    }

    private fun applyTextViewAnimation() {
        tv_chuck_norris.clearAnimation()
        tv_chuck_norris.startAnimation(fadeIn)
    }

    //TODO: Pode-se criar uma base fragment e reaproveitar desse comportamento
    private fun hideStatusForRespectiveFragment() = (hidedStatusBar)
}
