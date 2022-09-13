package com.getyourguide.interview.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.getyourguide.interview.databinding.FragmentReviewsBinding

class ReviewsFragment : Fragment() {

  companion object {
    fun newInstance(): Fragment = ReviewsFragment()
  }

  private var binding: FragmentReviewsBinding? = null

  private val adapter = ReviewsAdapter()
  private val viewModel: ReviewsViewModel by viewModels()

  override fun onCreateView(
    inflater: LayoutInflater,
    container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View {
    val binding = FragmentReviewsBinding.inflate(inflater, container, false)
    this.binding = binding
    return binding.root
  }

  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)
    binding?.run {
      recyclerView.layoutManager = LinearLayoutManager(requireContext())
      recyclerView.adapter = adapter
    }
    viewModel.liveData.observe(viewLifecycleOwner) {
      onSuccess(it)
    }
  }

  private fun onSuccess(reviews: List<ReviewViewItem>) {
    adapter.submitList(reviews)
    binding?.recyclerView?.visibility = View.VISIBLE
    binding?.progress?.visibility = View.GONE
  }
}
