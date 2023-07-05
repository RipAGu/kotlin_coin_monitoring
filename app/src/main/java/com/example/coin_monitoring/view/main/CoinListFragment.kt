package com.example.coin_monitoring.view.main

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.coin_monitoring.R
import com.example.coin_monitoring.databinding.FragmentCoinListBinding
import com.example.coin_monitoring.db.entity.InterestCoinEntity
import com.example.coin_monitoring.view.adapter.CoinListRVAdapter
import kotlinx.coroutines.selects.select
import timber.log.Timber

class CoinListFragment : Fragment() {

    private val viewModel : MainViewModel by activityViewModels()

    private var binding : FragmentCoinListBinding? = null

    private val selectedList = ArrayList<InterestCoinEntity>()
    private val unSelectedList = ArrayList<InterestCoinEntity>()



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {

        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentCoinListBinding.inflate(inflater, container, false)
        val view = binding!!.root
        // Inflate the layout for this fragment
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?)  {
        super.onViewCreated(view, savedInstanceState)


        viewModel.getAllInterestCoinData()
        viewModel.selectedCoinList.observe(viewLifecycleOwner, Observer {
            selectedList.clear()
            unSelectedList.clear()

            for (item in it) {
                if (item.selected) {
                    selectedList.add(item)
                } else {
                    unSelectedList.add(item)
                }
            }
            setSelectedListRV()
        })
    }

    private fun setSelectedListRV() {
        val selectedRVAdapter = CoinListRVAdapter(requireContext(), selectedList)
        binding!!.selectedCoinRV.adapter = selectedRVAdapter
        binding!!.selectedCoinRV.layoutManager = LinearLayoutManager(requireContext())

        selectedRVAdapter.itemClick = object : CoinListRVAdapter.ItemClick {
            override fun onClick(view: View, position: Int) {

                viewModel.updateInterestCoinData(selectedList[position])



            }
        }

        val unSelectedRVAdapter = CoinListRVAdapter(requireContext(), unSelectedList)
        binding!!.unSelectedCoinRV.adapter = unSelectedRVAdapter
        binding!!.unSelectedCoinRV.layoutManager = LinearLayoutManager(requireContext())

        unSelectedRVAdapter.itemClick = object : CoinListRVAdapter.ItemClick {
            override fun onClick(view: View, position: Int) {
                viewModel.updateInterestCoinData(unSelectedList[position])


            }
        }

    }

    override fun onDestroy() {
        super.onDestroy()
        binding = null
    }


}