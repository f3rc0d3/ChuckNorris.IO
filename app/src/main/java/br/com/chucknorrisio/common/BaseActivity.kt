package br.com.chucknorrisio.common

import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity

abstract class BaseActivity
@JvmOverloads
constructor(@LayoutRes layout: Int = 0) : AppCompatActivity(layout) {
}