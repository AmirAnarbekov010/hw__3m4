package com.example.hw__3m4.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.viewpager2.widget.ViewPager2
import com.example.hw__3m4.R
import com.example.hw__3m4.databinding.FragmentOnbordBinding
import com.example.hw__3m4.ui.adapter.OnBoardViewPagerAdapter

class OnBoardFragment : Fragment() {

    private val binding by lazy {
        FragmentOnbordBinding.inflate(layoutInflater)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return (binding.root)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initialize()
        setupListener()
    }

    private fun initialize() {
        binding.viewPager2.adapter = OnBoardViewPagerAdapter(this@OnBoardFragment)
    }

    private fun setupListener() = with(binding.viewPager2) {
        registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                if (position == 2) {
                    binding.tvSkip.visibility = View.GONE
                } else {
                    binding.tvSkip.visibility = View.VISIBLE
                }
                if (position == 2) {
                    binding.btnStart.visibility = View.VISIBLE
                } else {
                    binding.btnStart.visibility = View.GONE
                }
            }
        })

        binding.tvSkip.setOnClickListener {
            if (currentItem < 3) {
                setCurrentItem(currentItem + 2, true)
            }
        }

        binding.btnStart.setOnClickListener {
            findNavController().navigate(R.id.action_onBoardFragment_to_noteFragment)
        }
    }
}