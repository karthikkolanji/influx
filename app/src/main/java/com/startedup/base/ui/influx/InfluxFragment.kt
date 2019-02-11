package com.startedup.base.ui.influx

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProvider
import android.arch.lifecycle.ViewModelProviders
import android.content.Context
import android.net.Uri
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import com.startedup.base.R
import com.startedup.base.di.Injectable
import kotlinx.android.synthetic.main.fragment_influx.*
import javax.inject.Inject


private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class InfluxFragment : Fragment(), Injectable {


    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

     var viewModel: InfluxViewModel?=null

    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_influx, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initViewModel()
        setOnClick()

    }

    private fun initViewModel() {
        viewModel = activity?.let {
            ViewModelProviders.of(it, viewModelFactory).get(InfluxViewModel::class.java)
        }




        viewModel?.getFood()?.observe(this, Observer {

            when (it) {

            }
        })


    }

    private fun setOnClick() {
        btNavigate.setOnClickListener {
            it.findNavController().navigate(R.id.influxDetailFragment)
        }
    }


    companion object {
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
                InfluxFragment().apply {
                    arguments = Bundle().apply {
                        putString(ARG_PARAM1, param1)
                        putString(ARG_PARAM2, param2)
                    }
                }
    }
}
