package com.deniswane.edvora.ui.main

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.deniswane.edvora.databinding.FragmentMainBinding
import com.deniswane.edvora.repository.MainRepository
import com.deniswane.edvora.repository.MyViewModelFactory
import com.deniswane.edvora.service.RetrofitService
import com.deniswane.edvora.viewModel.MainViewModel
import com.deniswane.edvora.viewModel.PageViewModel
import java.text.DateFormat.getDateTimeInstance
import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.*

/**
 * A placeholder fragment containing a simple view.
 */
class PlaceholderFragment : Fragment() {

    private val TAG = "PlaceholderFragment"

    private lateinit var pageViewModel: PageViewModel
    private var _binding: FragmentMainBinding? = null

    lateinit var viewModel: MainViewModel

    val adapter = RecyclerAdapter()

    private val retrofitService = RetrofitService.getInstance()

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        /*pageViewModel = ViewModelProvider(this).get(PageViewModel::class.java).apply {
            setIndex(arguments?.getInt(ARG_SECTION_NUMBER) ?: 1)
        }*/
        viewModel =
            ViewModelProvider(this, MyViewModelFactory(MainRepository(retrofitService))).get(
                MainViewModel::class.java
            )
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentMainBinding.inflate(inflater, container, false)
        val root = binding.root

        /*val textView: TextView = binding.sectionLabel
        pageViewModel.text.observe(viewLifecycleOwner, Observer {
            textView.text = it
        })*/

        //get viewmodel instance using MyViewModelFactory
/*
        recyclerView.apply {
            // set a LinearLayoutManager to handle Android
            // RecyclerView behavior
            layoutManager = LinearLayoutManager(activity)
            // set the custom adapter to the RecyclerView
            //adapter = RecyclerAdapter()
        }*/

        binding.recyclerView.adapter = adapter
        binding.recyclerView.layoutManager = LinearLayoutManager(activity)

        viewModel.rideList.observe(viewLifecycleOwner, Observer {
            Log.e(TAG, "movieList: $it")
            adapter.setRideList(it)
        })

        viewModel.errorMessage.observe(viewLifecycleOwner, Observer {
            Log.e(TAG, "errorMessage: $it")
        })

        viewModel.getAllRides()

        //adapter.setRideList()

        return root
    }

    companion object {
        /**
         * The fragment argument representing the section number for this
         * fragment.
         */
        private const val ARG_SECTION_NUMBER = "section_number"

        /**
         * Returns a new instance of this fragment for the given section
         * number.
         */
        @JvmStatic
        fun newInstance(sectionNumber: Int): PlaceholderFragment {
            return PlaceholderFragment().apply {
                arguments = Bundle().apply {
                    putInt(ARG_SECTION_NUMBER, sectionNumber)
                }
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}