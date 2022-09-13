package com.getyourguide.interview.presentation

data class ReviewViewItem(
  val id: Long,
  val formattedDate: String,
  val rating: Float,
  val authorName: String,
  val authorAvatar: String?,
  val message: String?
)
