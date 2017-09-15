package com.tuvy.tomosugi.minimalpairs.view

/**
 * Created by tomosugi on 2017/09/14.
 */

import android.content.Context
import android.graphics.Canvas
import android.graphics.Rect
import android.graphics.drawable.Drawable
import android.support.v4.content.res.ResourcesCompat
import android.support.v7.widget.RecyclerView
import com.tuvy.tomosugi.minimalpairs.R

class DividerItemDecoration(context: Context) : RecyclerView.ItemDecoration() {

    private var divider: Drawable?

    init {
        val a = context.obtainStyledAttributes(ATTRS)
        divider = a.getDrawable(0)
        divider = ResourcesCompat.getDrawable(context.resources, R.drawable.line_divider, null)
        a.recycle()
    }

    override fun onDraw(c: Canvas?, parent: RecyclerView?) {
        drawVertical(c!!, parent!!)
    }

    fun drawVertical(c: Canvas, parent: RecyclerView) {
        val left = parent.paddingLeft +40
        val right = parent.width - parent.paddingRight -40

        val childCount = parent.childCount
        var i = 0
        while(i < childCount) {
            val child = parent.getChildAt(i)
            val params = child.layoutParams as RecyclerView.LayoutParams
            val top = child.bottom + params.bottomMargin
            val bottom = top + divider!!.intrinsicHeight
            divider!!.setBounds(left, top, right, bottom)
            divider!!.draw(c)
            i++
        }
    }

    override fun getItemOffsets(outRect: Rect, itemPosition: Int, parent: RecyclerView?) {
        outRect.set(0, 0, 0, divider!!.intrinsicHeight)
    }

    companion object {
        private val ATTRS = intArrayOf(android.R.attr.listDivider)
    }
}