package com.normanaspx.prueba_tecnica.ui.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import com.normanaspx.prueba_tecnica.R
import com.normanaspx.prueba_tecnica.databinding.FragmentMealBinding
import com.normanaspx.prueba_tecnica.utils.Response
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class HomeFragment : Fragment() {

    private val viewModel by activityViewModels<DessertViewModel>()
    private var _binding: FragmentMealBinding?=null
    private val binding get() = _binding!!
    private lateinit var customAdapter : CustomAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_meal, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        _binding = FragmentMealBinding.bind(view)

        viewModel.movieResponse.observe(
            viewLifecycleOwner
        ){
            when(it) {
                is Response.Loading -> {
                   // binding.progressbar.isVisible = it.isLoading
                }

                is Response.Failure -> {
                    // binding.progressbar.isVisible = it.isLoading
                }

                is  Response.Success -> {
                    customAdapter = CustomAdapter(it.data, context)
                    binding.apply {
                        rvMeals.setHasFixedSize(true)
                        rvMeals.adapter = customAdapter
                    }
                }
                else -> {}
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}