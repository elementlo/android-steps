package com.elementlo.android_steps

import android.content.Intent
import android.os.Bundle
import android.os.Looper
import android.view.MotionEvent
import android.view.View
import android.view.WindowManager
import android.widget.ArrayAdapter
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.ListFragment
import kotlin.concurrent.thread


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .add(R.id.fragment_container, StepListFragment())
                .commit()
        }
    }

    override fun onResume() {
        super.onResume()
    }

    override fun onTouchEvent(event: MotionEvent?): Boolean {
        return super.onTouchEvent(event)
    }
}

class StepListFragment : ListFragment() {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val items = arrayOf("ConstraintLayout", "MotionLayout", "CustomDrawing", "ScalableImageView",
            "CustomViewPagerActivity")

        listAdapter = ArrayAdapter(requireContext(), android.R.layout.simple_list_item_1, items)
        listView.setOnItemClickListener { _, _, position, _ ->
            when (position) {
                0 -> {
                    requireContext().startActivity(
                        Intent(
                            activity,
                            ConstraintLayoutActivity::class.java
                        )
                    )
                }

                1 -> {
                    requireContext().startActivity(
                        Intent(
                            activity,
                            MotionLayoutActivity::class.java
                        )
                    )
                }

                2 -> {
                    requireContext().startActivity(
                        Intent(
                            activity,
                            CustomDrawingActivity::class.java
                        )
                    )
                }
                3->{
                    requireContext().startActivity(
                        Intent(
                            activity,
                            ScalableImageViewActivity::class.java
                        )
                    )
                }
                4 -> {
                    requireContext().startActivity(
                        Intent(
                            activity,
                            CustomViewPagerActivity::class.java
                        )
                    )
                }
            }
        }
    }
}