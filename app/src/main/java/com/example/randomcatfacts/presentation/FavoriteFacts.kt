package com.example.randomcatfacts.presentation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.randomcatfacts.adapter.CatFactsAdapter
import com.example.randomcatfacts.adapter.FavoriteFactAdapter
import com.example.randomcatfacts.adapter.OnItemClickListener
import com.example.randomcatfacts.common.CatFact
import com.example.randomcatfacts.common.MapperForDB
import com.example.randomcatfacts.databinding.FragmentFavoriteFactsBinding
import dagger.hilt.EntryPoint
import dagger.hilt.android.AndroidEntryPoint

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [FavoriteFacts.newInstance] factory method to
 * create an instance of this fragment.
 */
@AndroidEntryPoint
class FavoriteFacts : Fragment(), OnItemClickListener {
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

    private lateinit var _binding : FragmentFavoriteFactsBinding
    val binding get() = _binding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentFavoriteFactsBinding.inflate(layoutInflater)
        return _binding.root
    }

    private val viewModel: MainVM by viewModels()

    private val mapper = MapperForDB()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.mainRV.layoutManager = LinearLayoutManager(requireContext())

        updateUI()
    }

    private fun updateUI(){
        viewModel.getFavorites()
        viewModel.favoriteList.observe(viewLifecycleOwner){ list ->
            binding.mainRV.adapter = FavoriteFactAdapter(mapper.extractImageList(list), mapper.extractFactList(list), this)
        }
    }

    override fun onResume() {
        super.onResume()
        updateUI()
    }

    override fun onButtonClick(imageUrl: String, fact: String, currentState: Boolean) {
        if (currentState){
            viewModel.deleteFavorite(imageUrl, fact)
        }
        updateUI()
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment FavoriteFacts.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            FavoriteFacts().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}