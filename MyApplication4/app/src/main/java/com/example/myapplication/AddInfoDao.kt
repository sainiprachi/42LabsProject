package com.example.myapplication

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy

@Dao
interface AddInfoDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(bean: AddInfoModel?)

}