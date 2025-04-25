package com.elementlo.android_steps.view

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.View
import com.elementlo.android_steps.utils.dp
import androidx.core.graphics.withTranslation
import com.elementlo.android_steps.R

private val BITMAP_SIZE = 200.dp
private val BITMAP_PADDING = 100.dp

class FlipView(context: Context?, attrs: AttributeSet?) : View(context, attrs) {
    private val paint = Paint(Paint.ANTI_ALIAS_FLAG)
    private val bitmap = getAvatar(BITMAP_SIZE.toInt())
    private val camera = Camera()

    init {
        camera.rotateX(30f)
        camera.setLocation(0f, 0f, -6 * resources.displayMetrics.density)
    }

    override fun onDraw(canvas: Canvas) {

        // 上半部分
        canvas.withTranslation(BITMAP_PADDING + BITMAP_SIZE / 2, BITMAP_PADDING + BITMAP_SIZE / 2) {
            rotate(-30f)
            clipRect(-BITMAP_SIZE, -BITMAP_SIZE, BITMAP_SIZE, 0f)
            rotate(30f)
            translate(-(BITMAP_PADDING + BITMAP_SIZE / 2), -(BITMAP_PADDING + BITMAP_SIZE / 2))
            drawBitmap(bitmap, BITMAP_PADDING, BITMAP_PADDING, paint)
        }

        // 下半部分
        canvas.withTranslation(BITMAP_PADDING + BITMAP_SIZE / 2, BITMAP_PADDING + BITMAP_SIZE / 2) {
            rotate(-30f)
            camera.applyToCanvas(this)
            clipRect(-BITMAP_SIZE, 0f, BITMAP_SIZE, BITMAP_SIZE)
            rotate(30f)
            translate(-(BITMAP_PADDING + BITMAP_SIZE / 2), -(BITMAP_PADDING + BITMAP_SIZE / 2))
            drawBitmap(bitmap, BITMAP_PADDING, BITMAP_PADDING, paint)
        }
    }

    private fun getAvatar(width: Int): Bitmap {
        val options = BitmapFactory.Options()
        options.inJustDecodeBounds = true
        BitmapFactory.decodeResource(resources, R.drawable.netflix, options)
        options.inJustDecodeBounds = false
        options.inDensity = options.outWidth
        options.inTargetDensity = width
        return BitmapFactory.decodeResource(resources, R.drawable.netflix, options)
    }
}