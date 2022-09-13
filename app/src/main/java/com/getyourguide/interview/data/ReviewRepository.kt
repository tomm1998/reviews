package com.getyourguide.interview.data

import com.getyourguide.interview.data.remote.ReviewResponse
import com.getyourguide.interview.data.remote.ReviewsApi

typealias Review = ReviewResponse.ReviewsDto
typealias Reviews = ReviewResponse

class ReviewRepository(
  private val reviewsApi: ReviewsApi
) {

  suspend fun getReviews(): Reviews {
    return reviewsApi.getReviews()
  }
}
