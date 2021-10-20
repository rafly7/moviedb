package net.rafly.moviedb.presentation

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import net.rafly.moviedb.R
import net.rafly.moviedb.adapters.PopularAdapter
import net.rafly.moviedb.data.network.Resource
import net.rafly.moviedb.databinding.FragmentHomeBinding

class HomeFragment : Fragment(R.layout.fragment_home) {

    private lateinit var binding: FragmentHomeBinding

    private var viewModel: HomeViewModel? = null
    private lateinit var popularAdapter: PopularAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding = FragmentHomeBinding.bind(view)

        viewModel = (requireActivity() as MainActivity).appContainer.movieDbContainer?.homeViewModelFactory?.create()

        getPopular()
        setUpRecyclerView()

        viewModel?.popular?.observe(viewLifecycleOwner) {
            when (it) {
                is Resource.Success -> {
                    Log.e("SUCCESS", "<<<<<<<<<<<<<<<<<<<<<")
                    Log.e("RESULTS",it.values.results.toString())
                    popularAdapter.differ.submitList(it.values.results)
                }
                is Resource.Failure -> {
                    Log.e("ERROR", ">>>>>>>>>>>>>>>>>>>>>")
                }
            }
        }
    }

    val scrollListener = object : RecyclerView.OnScrollListener() {
        override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
            super.onScrolled(recyclerView, dx, dy)

        }
    }

    private fun getPopular() {
        viewModel?.getPopular()
    }

    private fun setUpRecyclerView() {
        popularAdapter = PopularAdapter()
        binding.recyclerViewMovielistPopular.apply {
            adapter = popularAdapter
            layoutManager = LinearLayoutManager(activity)
        }
    }

}