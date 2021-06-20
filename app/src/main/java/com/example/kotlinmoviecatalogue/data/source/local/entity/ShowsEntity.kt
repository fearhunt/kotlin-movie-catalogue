package com.example.kotlinmoviecatalogue.data.source.local.entity

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "showsentities")
data class ShowsEntity(
	@PrimaryKey
	@NonNull
	@ColumnInfo(name = "id")
	val id: Int,

	@ColumnInfo(name = "overview")
	val overview: String,

	@ColumnInfo(name = "original_language")
	val originalLanguage: String,

	@ColumnInfo(name = "poster_path")
	val posterPath: String,

	// TV Show title
	@ColumnInfo(name = "name")
	val name: String? = null,

	// Movie title
	@ColumnInfo(name = "title")
	val title: String? = null,

	@ColumnInfo(name = "is_favorite")
	val isFavorite: Boolean = false
)
