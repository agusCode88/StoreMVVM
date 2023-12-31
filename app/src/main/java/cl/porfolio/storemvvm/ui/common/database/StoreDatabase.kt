package cl.porfolio.storemvvm.ui.common.database

import androidx.room.Database
import androidx.room.RoomDatabase
import cl.porfolio.storemvvm.ui.common.database.StoreDao
import cl.porfolio.storemvvm.ui.common.entities.StoreEntity

/****
 * Project: Stores
 * From: com.cursosant.android.stores
 * Created by Alain Nicolás Tello on 27/11/20 at 12:37
 * Course: Android Practical with Kotlin from zero.
 * All rights reserved 2021.
 *
 * All my Courses(Only on Udemy):
 * https://www.udemy.com/user/alain-nicolas-tello/
 ***/
@Database(entities = arrayOf(StoreEntity::class), version = 2)
abstract class StoreDatabase : RoomDatabase() {
    abstract fun storeDao(): StoreDao
}