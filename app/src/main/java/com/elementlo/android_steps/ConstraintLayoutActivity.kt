package com.elementlo.android_steps

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.constraintlayout.widget.ConstraintSet
import androidx.constraintlayout.widget.Placeholder
import androidx.transition.TransitionManager

class ConstraintLayoutActivity: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_constraint_layout)
    }

    fun onClick(view: View) {
        findViewById<Placeholder>(R.id.placeholder).setContentId(view.id)
    }

    fun onConstraintSetClick(view: View) {
        val constraintLayout = view as ConstraintLayout

        val constraintSet = ConstraintSet().apply {
            //hard checking the view id matching.
            isForceId = false
            clone(this@ConstraintLayoutActivity,
                R.layout.layout_set_to
            )
        }
        //Add an animation to the layout.
        TransitionManager.beginDelayedTransition(constraintLayout)
        constraintSet.applyTo(constraintLayout)
    }
}