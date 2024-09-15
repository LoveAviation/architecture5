package com.example.randomcatfacts.presentation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.randomcatfacts.adapter.CatFactsAdapter
import com.example.randomcatfacts.adapter.OnItemClickListener
import com.example.randomcatfacts.databinding.FragmentCatFactsBinding
import dagger.hilt.android.AndroidEntryPoint

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [CatFacts.newInstance] factory method to
 * create an instance of this fragment.
 */
@AndroidEntryPoint
class CatFacts : Fragment(), OnItemClickListener {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    private lateinit var _binding: FragmentCatFactsBinding
    val binding get() = _binding

    private val factCount = 10 //получилось магическое число, так как по сути его можно было бы вести допустим с textEditor, но его делать не надо


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentCatFactsBinding.inflate(layoutInflater)
        return _binding.root
    }

    private val viewModel: MainVM by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.mainRV.layoutManager = LinearLayoutManager(requireContext())



        viewModel.getImages(factCount)
        viewModel.imagesList.observe(viewLifecycleOwner){ imagesList ->
            if(imagesList.isNotEmpty()){
                viewModel.getFacts(factCount)

                viewModel.factsList.observe(viewLifecycleOwner){ factsList ->
                    if(factsList.isNotEmpty()){
                        binding.mainRV.adapter = CatFactsAdapter(imagesList, factsList, this)
                    }
                }

            }
        }

    }

    override fun onButtonClick(imageUrl: String, fact: String, currentState: Boolean) {
        if (!currentState){
            viewModel.addFavorites(imageUrl, fact)
        }
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment CatFacts.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            CatFacts().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}