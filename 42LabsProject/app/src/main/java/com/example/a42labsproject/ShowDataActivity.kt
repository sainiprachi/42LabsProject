package com.example.a42labsproject

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.a42labsproject.adapter.UserListAdapter
import com.example.a42labsproject.model.UserListModel
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class ShowDataActivity :AppCompatActivity() {
    var arrayList: ArrayList<UserListModel>? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initView()
    }

    /*
    * Initialise the views
    * */
    fun initView() {
        recyclerUserList.layoutManager = LinearLayoutManager(this@ShowDataActivity)
        if (arrayList == null) {
            arrayList = ArrayList()
        }
        addItems()
        recyclerUserList.adapter = UserListAdapter(arrayList!!)
    }


    /*
    * Add items in the list
    * */
    private fun addItems() {
        var item: UserListModel
        for (i in 0..4) {
            item = UserListModel()
            when (i) {
                0 -> {
                    item.userName = "James Robert"
                    item.email = "james@gmail.com"
                    item.endTime = 30000
                }
                1 -> {
                    item.userName = "Robert moscow"
                    item.itemImg = R.drawable.index
                    item.email = "robert@gmail.com"
                    item.endTime = 45000
                }
                2 -> {
                    item.userName = "Kim Com"
                    item.itemImg = R.drawable.index
                    item.email = "kim@gmail.com"
                    item.endTime = 34000
                }
                3 -> {
                    item.userName = "Emma Wong"
                    item.itemImg = R.drawable.index
                    item.email = "emma@gmail.com"
                    item.endTime = 100000
                }
                4 -> {
                    item.userName = "Neil ArmStrong"
                    item.itemImg = R.drawable.index
                    item.email = "neil@gmail.com"
                    item.endTime = 45000
                }
            }
            arrayList!!.add(item)
        }
    }

}