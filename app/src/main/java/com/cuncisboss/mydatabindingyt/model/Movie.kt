package com.cuncisboss.mydatabindingyt.model

import com.google.gson.annotations.SerializedName

data class Movie(

	@SerializedName("image")
	val image: String,

	@SerializedName("like_percent")
	val likePercent: Int,

	@SerializedName("is_new")
	val isNew: Int,

	@SerializedName("rating")
	val rating: String,

	@SerializedName("language")
	val language: String,

	@SerializedName("id")
	val id: Int,

	@SerializedName("title")
	val title: String,

	@SerializedName("type")
	val type: String,

	@SerializedName("vote_count")
	val voteCount: Int
)
