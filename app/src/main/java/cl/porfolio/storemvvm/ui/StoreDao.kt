package cl.porfolio.storemvvm.ui

import androidx.room.*

/****
 * Project: Stores
 * From: com.cursosant.android.stores
 * Created by Alain Nicolás Tello on 27/11/20 at 12:24
 * Course: Android Practical with Kotlin from zero.
 * All rights reserved 2021.
 *
 * All my Courses(Only on Udemy):
 * https://www.udemy.com/user/alain-nicolas-tello/
 ***/
@Dao
interface StoreDao {
    @Query("SELECT * FROM StoreEntity")
    suspend fun getAllStores() : MutableList<StoreEntity>

    @Query("SELECT * FROM StoreEntity where id = :id")
    suspend fun getStoreById(id: Long): StoreEntity

    @Insert
    suspend fun addStore(storeEntity: StoreEntity): Long

    @Update
    suspend fun updateStore(storeEntity: StoreEntity)

    @Delete
    suspend fun deleteStore(storeEntity: StoreEntity)
}