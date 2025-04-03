package com.elementlo.android_steps

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.ListFragment

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
}

class StepListFragment : ListFragment() {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val items = arrayOf("ConstraintLayout", "MotionLayout")

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
            }
        }
    }
}