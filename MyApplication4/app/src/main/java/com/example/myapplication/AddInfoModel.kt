package com.example.myapplication

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "addInfo")
class AddInfoModel {

    @PrimaryKey(autoGenerate = true)
    var uid: Int = 0


    @ColumnInfo(name = "firstName")
    var firstName: String? = null

    @ColumnInfo(name = "lastName")
    var lastName: String? = null

    @ColumnInfo(name = "phoneNumber")
    var phoneNumber: String? = null

    @ColumnInfo(name = "city")
    var city: String? = null

    @ColumnInfo(name = "state")
    var state: String? = null

    @ColumnInfo(name = "pincode")
    var pincode: String? = null



}