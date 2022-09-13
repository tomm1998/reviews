package com.getyourguide.interview.presentation

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import com.getyourguide.interview.R

class ReviewsAdapter : ListAdapter<ReviewViewItem, ReviewsViewHolder>(diffCallback) {

  companion object {
   private val diffCallback =  object: DiffUtil.ItemCallback<ReviewViewItem>() {
     override fun areItemsTheSame(oldItem: ReviewViewItem, newItem: ReviewViewItem): Boolean {
      return oldItem.id == newItem.id
     }

     override fun areContentsTheSame(oldItem: ReviewViewItem, newItem: ReviewViewItem): Boolean {
      return oldItem == newItem
     }
   }
  }

  override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ReviewsViewHolder {
    val view = LayoutInflater.from(parent.context).inflate(R.layout.row_reviews, parent, false)
    return ReviewsViewHolder(view)
  }

  override fun onBindViewHolder(holder: ReviewsViewHolder, position: Int) {
    holder.bind(getItem(position))
  }
}
