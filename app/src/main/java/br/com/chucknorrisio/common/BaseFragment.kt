package br.com.chucknorrisio.common

import androidx.annotation.LayoutRes
import androidx.fragment.app.Fragment

abstract class BaseFragment
@JvmOverloads
constructor(@LayoutRes layout: Int = 0): Fragment(layout)