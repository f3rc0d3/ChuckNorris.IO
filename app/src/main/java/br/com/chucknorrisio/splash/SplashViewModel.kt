package br.com.chucknorrisio.splash

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import javax.inject.Inject

class SplashViewModel @Inject constructor() : ViewModel() {
    private val delayForSplash = MutableLiveData<Boolean>()
    val delayForSplashObserver: LiveData<Boolean> get() = delayForSplash

    private val animationStart = MutableLiveData<Boolean>()
    val animationStartObserver: LiveData<Boolean> get() = animationStart

    init {
        viewModelScope.launch {
            animationStart.value = true
            delay(4000)
            delayForSplash.value = true
        }
    }


}
