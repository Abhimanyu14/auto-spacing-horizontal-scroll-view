package com.makeappssimple.abhimanyu.autospacinghorizontalscrollview.android

import android.content.Context
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recyclerView = findViewById<RecyclerView>(R.id.activity_main_root)
        recyclerView.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)

        val children = Array(6) { "" }
        recyclerView.adapter = RecyclerAdapter(children)

        val childViewWidth = 64
        val offset = getOffset(
            resources.displayMetrics.widthPixels,
            childViewWidth,
            children.size
        )

        if (offset > 0) {
            val itemDecoration = ItemOffsetDecoration(offset, children.size)
            recyclerView.addItemDecoration(itemDecoration)
        }
    }

    private fun getOffset(screenWidth: Int, childViewWidth: Int, numberOfChildren: Int): Int {
        // screen width - sum of width of all children views => gives the empty space available between children
        // divided by (numberOfChildren - 1) as the gap is less than number of children by 1
        // divided by 2 - offset is divided into left and right
        return ((screenWidth - dpToPx(
            this,
            childViewWidth
        ) * numberOfChildren) / (numberOfChildren - 1) / 2)
    }

    private fun dpToPx(context: Context, dp: Int): Int {
        return (dp * context.resources.displayMetrics.density).toInt()
    }
}
