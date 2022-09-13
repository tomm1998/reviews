package com.getyourguide.interview.data.remote

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class ReviewResponse(
  @Json(name = "reviews")
  val reviews: List<ReviewsDto>,
  @Json(name = "totalCount")
  val totalCount: Int,
  @Json(name = "averageRating")
  val averageRating: Float,
) {

  @JsonClass(generateAdapter = true)
  data class ReviewsDto(
    @Json(name = "id")
    val id: Long,
    @Json(name = "author")
    val author: Author,
    @Json(name = "title")
    val title: String?,
    @Json(name = "enjoyment")
    val enjoyment: String?,
    @Json(name = "isAnonymous")
    val isAnonymous: Boolean?,
    @Json(name = "rating")
    val rating: Float?,
    @Json(name = "created")
    val created: String,
    @Json(name = "optionId")
    val optionId: Int?,
    @Json(name = "activityId")
    val activityId: Int,
    @Json(name = "language")
    val language: String?,
    @Json(name = "travelerType")
    val travelerType: String?,
    @Json(name = "message")
    val message: String?
  ) {

    @JsonClass(generateAdapter = true)
    data class Author(
      @Json(name = "fullName")
      val fullName: String?,
      @Json(name = "country")
      val country: String?,
      @Json(name = "photo")
      val photo: String?
    )
  }
}


