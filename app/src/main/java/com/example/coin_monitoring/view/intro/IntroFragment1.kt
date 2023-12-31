package com.example.coin_monitoring.view.intro

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import com.example.coin_monitoring.R
import com.example.coin_monitoring.databinding.FragmentIntro1Binding
import kotlin.math.log


class IntroFragment1 : Fragment() {

    private lateinit var binding: FragmentIntro1Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding= FragmentIntro1Binding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        binding.nextBtn.setOnClickListener{
            Navigation.findNavController(view).navigate(R.id.action_introFragment1_to_introFragment2)
        }
    }



}
