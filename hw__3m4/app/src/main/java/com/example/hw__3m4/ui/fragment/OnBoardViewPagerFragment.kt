package com.example.hw__3m4.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.hw__3m4.R
import com.example.hw__3m4.databinding.FragmentOnBoardViewPagerBinding

class OnBoardViewPagerFragment : Fragment() {

    private val binding by lazy {
        FragmentOnBoardViewPagerBinding.inflate(layoutInflater)
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
    }

    private fun initialize() = with(binding) {
        when(requireArguments().getInt(ARG_ONBOARD_POSITION)) {
            0 -> {
                tvOne.text = "Удобство"
                tvTwo.text = "Создавайте заметки в два клика! Записывайте мысли, идеи и важные задачи мгновенно."
                lottie.setAnimation(R.raw.lottie1)
            }
            1 -> {
                tvOne.text = "Организация"
                tvTwo.text = "Организуйте заметки по папкам и тегам. Легко находите нужную информацию в любое время."
                lottie.setAnimation(R.raw.lottie2)
            }
            2-> {
                tvOne.text = "Синхронизация"
                tvTwo.text = "Синхронизация на всех устройствах. Доступ к записям в любое время и в любом месте."
                lottie.setAnimation(R.raw.lottie3)
            }
        }
    }

    companion object{
        const val ARG_ONBOARD_POSITION = "onBoard"
    }
}