package com.getyourguide.interview.data.remote

import retrofit2.http.GET

interface ReviewsApi {

  @GET("activities/60955/reviews")
  suspend fun getReviews(): ReviewResponse
}
