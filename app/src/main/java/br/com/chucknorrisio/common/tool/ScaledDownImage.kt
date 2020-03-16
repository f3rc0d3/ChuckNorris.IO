package br.com.chucknorrisio.common.tool

import android.content.Context
import android.graphics.Bitmap
import android.graphics.drawable.BitmapDrawable
import androidx.appcompat.widget.AppCompatImageView
import androidx.core.graphics.drawable.toBitmap


class ScaledDownImage(private val imageView: AppCompatImageView, private val context: Context) {
    fun scaleDown(): Bitmap {
        val bitmap = BitmapDrawable(context.resources, imageView.drawable.toBitmap()).bitmap
        return Bitmap.createScaledBitmap(
            bitmap, 512,
            (bitmap.height * (512.0 / bitmap.width)).toInt(),
            true
        )
    }
}