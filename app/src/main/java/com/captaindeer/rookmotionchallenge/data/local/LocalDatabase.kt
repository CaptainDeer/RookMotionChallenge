package com.captaindeer.rookmotionchallenge.data.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.captaindeer.rookmotionchallenge.data.local.dao.UserDao
import com.captaindeer.rookmotionchallenge.data.local.entities.UserEntity

@Database(entities = [UserEntity::class], version = 1, exportSchema = false)
abstract class LocalDatabase : RoomDatabase() {

    abstract fun userDao(): UserDao

    companion object {
        @Volatile
        private var instance: LocalDatabase? = null
        private val LOCK = Any()

        operator fun invoke(context: Context) = instance ?: synchronized(LOCK) {
            instance ?: buildDatabase(context).also { instance = it }
        }

        private fun buildDatabase(context: Context) =
            Room.databaseBuilder(context, LocalDatabase::class.java, "UsersRookMotion.db")
                .allowMainThreadQueries()
                .fallbackToDestructiveMigration()
                .build()
    }
}