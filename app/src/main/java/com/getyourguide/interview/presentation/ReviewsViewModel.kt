package com.getyourguide.interview.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.getyourguide.interview.RetrofitBuilder
import com.getyourguide.interview.data.Review
import com.getyourguide.interview.data.ReviewRepository
import com.getyourguide.interview.data.remote.ReviewsApi
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class ReviewsViewModel(
  private val reviewRepository: ReviewRepository = ReviewRepository(
    RetrofitBuilder.build(ReviewsApi::class.java)
  )
) : ViewModel() {

  private val _liveData: MutableLiveData<List<ReviewViewItem>> = MutableLiveData()
  val liveData: LiveData<List<ReviewViewItem>> = _liveData

  init {
    viewModelScope.launch {
      loadReviews()
    }
  }

  private suspend fun loadReviews() {
    val reviews = withContext(Dispatchers.IO) {
      reviewRepository.getReviews()
        .reviews
        .map { it.toViewItem() }
    }
    _liveData.value = reviews
  }

  private fun Review.toViewItem() = ReviewViewItem(
    id = id,
    formattedDate = LocalDateTime.parse(
      created,
      DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ssz")
    ).format(DateTimeFormatter.ofPattern("MMM dd, yyyy")),
    rating = rating ?: 0f,
    authorName = "${author.fullName}-${author.country}",
    authorAvatar = author.photo,
    message = message
  )
}
