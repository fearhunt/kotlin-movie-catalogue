package com.example.kotlinmoviecatalogue.data.source.local.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.kotlinmoviecatalogue.data.source.local.entity.ShowsDetailEntity
import com.example.kotlinmoviecatalogue.data.source.local.entity.ShowsEntity

@Database(entities = [ShowsEntity::class, ShowsDetailEntity::class], version = 1, exportSchema = false)
abstract class ShowsDatabase : RoomDatabase() {
    abstract fun showsDao(): ShowsDao

    companion object {
        @Volatile
        private var instance: ShowsDatabase? = null

        fun getInstance(context: Context): ShowsDatabase =
            instance ?: synchronized(this) {
                Room.databaseBuilder(context.applicationContext, ShowsDatabase::class.java, "Shows.db")
                    .build().apply {
                        instance = this
                    }
            }
    }
}
