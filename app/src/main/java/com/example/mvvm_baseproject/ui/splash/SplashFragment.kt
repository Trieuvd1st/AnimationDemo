package com.example.mvvm_baseproject.ui.splash

import android.animation.*
import android.annotation.SuppressLint
import android.graphics.Color
import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import android.view.animation.AccelerateInterpolator
import android.view.animation.LinearInterpolator
import android.widget.FrameLayout
import androidx.appcompat.widget.AppCompatImageView
import androidx.fragment.app.viewModels
import com.example.mvvm_baseproject.R
import com.example.mvvm_baseproject.databinding.FragmentSplashBinding
import com.example.mvvm_baseproject.navigationComponent.AppNavigation
import com.example.mvvm_baseproject.ui.base.BaseFragment
import com.example.mvvm_baseproject.utils.setTextCompute
import dagger.hilt.android.AndroidEntryPoint
import timber.log.Timber
import javax.inject.Inject

@AndroidEntryPoint
class SplashFragment : BaseFragment<FragmentSplashBinding>(R.layout.fragment_splash) {

    @Inject
    lateinit var appNavigation: AppNavigation

    private val viewModel: SplashViewModel by viewModels()

    @SuppressLint("WrongConstant")
    override fun initView(savedInstanceState: Bundle?) {
        super.initView(savedInstanceState)

        binding.rorate.setOnClickListener {
            val animator = ObjectAnimator.ofFloat(binding.star, View.ROTATION_Y, -360f, 0f)
            animator.duration = 3000
            animator.disableViewDuringAnimation(binding.rorate)
            animator.start()
        }

        binding.translate.setOnClickListener {
            val animator = ObjectAnimator.ofFloat(binding.star, View.TRANSLATION_Y, 300f)
            animator.duration = 2000
            animator.repeatCount = 3
            animator.repeatMode = ObjectAnimator.REVERSE
            animator.disableViewDuringAnimation(binding.translate)
            animator.start()
        }

        binding.scale.setOnClickListener {
            val scaleX = PropertyValuesHolder.ofFloat(View.SCALE_X, 4f)
            val scaleY = PropertyValuesHolder.ofFloat(View.SCALE_Y, 4f)
            val animator = ObjectAnimator.ofPropertyValuesHolder(binding.star, scaleX, scaleY)
            animator.duration = 1000
            animator.repeatCount = 1
            animator.repeatMode = ObjectAnimator.REVERSE
            animator.disableViewDuringAnimation(binding.scale)
            animator.start()
        }

        binding.fade.setOnClickListener {
            val animator = ObjectAnimator.ofFloat(binding.star, View.ALPHA, 0f)
            animator.repeatCount = 1
            animator.repeatMode = ObjectAnimator.REVERSE
            animator.disableViewDuringAnimation(binding.fade)
            animator.start()
        }

        binding.skycolor.setOnClickListener {
            var animator = ObjectAnimator.ofArgb(binding.star.parent,
                "backgroundColor", Color.BLACK, Color.RED)
            animator.setDuration(500)
            animator.repeatCount = 1
            animator.repeatMode = ObjectAnimator.REVERSE
            animator.disableViewDuringAnimation(binding.skycolor)
            animator.start()
        }

        binding.shower.setOnClickListener {
            // Create a new star view in a random X position above the container.
            // Make it rotateButton about its center as it falls to the bottom.

            // Local variables we'll need in the code below
            val container = binding.star.parent as ViewGroup
            val containerW = container.width
            val containerH = container.height
            var starW: Float = binding.star.width.toFloat()
            var starH: Float = binding.star.height.toFloat()

            // Create the new star (an ImageView holding our drawable) and add it to the container
            val newStar = AppCompatImageView(requireContext())
            newStar.setImageResource(R.drawable.ic_apple)
            newStar.layoutParams = FrameLayout.LayoutParams(
                FrameLayout.LayoutParams.WRAP_CONTENT,
                FrameLayout.LayoutParams.WRAP_CONTENT)
            container.addView(newStar)

            // Scale the view randomly between 10-160% of its default size
            newStar.scaleX = Math.random().toFloat() * 1.5f + .1f
            newStar.scaleY = newStar.scaleX
            starW *= newStar.scaleX
            starH *= newStar.scaleY

            // Position the view at a random place between the left and right edges of the container
            newStar.translationX = Math.random().toFloat() * containerW - starW / 2

            // Create an animator that moves the view from a starting position right about the container
            // to an ending position right below the container. Set an accelerate interpolator to give
            // it a gravity/falling feel
            val mover = ObjectAnimator.ofFloat(newStar, View.TRANSLATION_Y, -starH, containerH + starH)
            mover.interpolator = AccelerateInterpolator(1f)

            // Create an animator to rotateButton the view around its center up to three times
            val rotator = ObjectAnimator.ofFloat(newStar, View.ROTATION,
                (Math.random() * 1080).toFloat())
            rotator.interpolator = LinearInterpolator()

            // Use an AnimatorSet to play the falling and rotating animators in parallel for a duration
            // of a half-second to two seconds
            val set = AnimatorSet()
            set.playTogether(mover, rotator)
            set.duration = (Math.random() * 1500 + 500).toLong()

            // When the animation is done, remove the created view from the container
            set.addListener(object : AnimatorListenerAdapter() {
                override fun onAnimationEnd(animation: Animator?) {
                    container.removeView(newStar)
                }
            })

            // Start the animation
            set.start()
        }

        binding.btnNext.setOnClickListener {
            appNavigation.openSplashToLoginScreen()
        }
    }

    private fun ObjectAnimator.disableViewDuringAnimation(view: View) {

        // This extension method listens for start/end events on an animation and disables
        // the given view for the entirety of that animation.

        addListener(object : AnimatorListenerAdapter() {
            override fun onAnimationStart(animation: Animator?) {
                view.isEnabled = false
            }

            override fun onAnimationEnd(animation: Animator?) {
                view.isEnabled = true
            }
        })
    }
}