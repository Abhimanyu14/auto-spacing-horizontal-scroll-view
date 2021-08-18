package com.makeappssimple.abhimanyu.autospacinghorizontalscrollview.android

import android.graphics.Rect
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ItemDecoration

class ItemOffsetDecoration(private val itemOffset: Int, private val childrenCount: Int) :
    ItemDecoration() {

    override fun getItemOffsets(
        outRect: Rect, view: View,
        parent: RecyclerView, state: RecyclerView.State
    ) {
        // Add left margin for all items except the first item
        outRect.left = if (parent.getChildLayoutPosition(view) == 0) {
            0
        } else {
            itemOffset
        }

        // Add right margin for all items except the last item
        outRect.right = if (parent.getChildLayoutPosition(view) == childrenCount - 1) {
            0
        } else {
            itemOffset
        }
    }
}
