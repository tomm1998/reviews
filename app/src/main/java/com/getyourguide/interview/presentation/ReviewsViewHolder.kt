package com.getyourguide.interview.presentation

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.getyourguide.interview.R
import com.getyourguide.interview.databinding.RowReviewsBinding

class ReviewsViewHolder(containerView: View) : RecyclerView.ViewHolder(containerView) {

  private val binding = RowReviewsBinding.bind(containerView)

  fun bind(item: ReviewViewItem) {
    binding.dateText.text = item.formattedDate
    binding.ratingBar.rating = item.rating
    binding.author.text = item.authorName
    binding.image.load(item.authorAvatar) {
      fallback(R.drawable.ic_launcher_background)
      crossfade(true)
    }
    binding.message.text = item.message
  }
}
