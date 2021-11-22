package com.deepak.apod.module.astronomyHomePage.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.deepak.apod.R
import com.deepak.apod.databinding.FragmentApodBinding
import com.deepak.apod.util.compareDate
import com.deepak.apod.util.isOnline
import com.deepak.apod.util.showSnackBar
import org.koin.androidx.viewmodel.ext.android.viewModel


class ApodFragment : Fragment() {
    private val viewModel by viewModel<ApodViewModel>()
    private lateinit var binding: FragmentApodBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentApodBinding.inflate(inflater, container, false)
        initObserver()
        return binding.root
    }

    private fun initObserver() {
        viewModel.apply {
            fetchData(context)
            apodDetail.observe(viewLifecycleOwner, { viewData ->
                binding.data = viewData
                viewData.date?.let {
                    if (compareDate(it) && !isOnline(requireContext()))
                        showSnackBar(
                            requireContext(),
                            binding.root,
                            getString(R.string.displayError)
                        )
                }
            })
            errorMessage.observe(viewLifecycleOwner, {
                it?.let {
                    showSnackBar(requireContext(), binding.root, it)
                }
            })
        }

    }


}
