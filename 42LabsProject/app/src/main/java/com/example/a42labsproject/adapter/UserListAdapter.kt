package com.example.a42labsproject.adapter

import android.os.CountDownTimer
import android.os.Handler
import android.text.format.DateUtils
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.a42labsproject.R
import com.example.a42labsproject.model.UserListModel
import java.util.*

@Suppress("NAME_SHADOWING")
class UserListAdapter(var userListModelArrayList: ArrayList<UserListModel>) : RecyclerView.Adapter<UserListAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.addon_view, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val userListModel = userListModelArrayList[position]
        holder.txtName.text = userListModel.userName
        holder.txtEmail.text = "Email :" + userListModel.email
        val cdt: CountDownTimer

        /*
        * count down timer to remove the view
        * */
        cdt = object : CountDownTimer(userListModel.endTime.toLong(), 1000) {
            override fun onTick(millisUntilFinished: Long) {
                var millisUntilFinished = millisUntilFinished
                var minutes = 0
                var seconds = 0
                var sDate = ""
                if (millisUntilFinished > DateUtils.MINUTE_IN_MILLIS) {
                    minutes = (millisUntilFinished / DateUtils.MINUTE_IN_MILLIS).toInt()
                }
                millisUntilFinished -= minutes * DateUtils.MINUTE_IN_MILLIS
                if (millisUntilFinished > DateUtils.SECOND_IN_MILLIS) {
                    seconds = (millisUntilFinished / DateUtils.SECOND_IN_MILLIS).toInt()
                }
                sDate += " " + "00" + ":" + String.format("%02d", minutes) + ":" + String.format("%02d", seconds)
                holder.txtTimeRemaining.text = sDate.trim { it <= ' ' }
            }

            override fun onFinish() {
                holder.txtTimeRemaining.text = "Finish"
                val handle = Handler()
                handle.postDelayed({
                    val newPosition = holder.adapterPosition
                    if (holder.adapterPosition >= 0) {
                        userListModelArrayList.removeAt(newPosition)
                        notifyItemRemoved(newPosition)
                        notifyItemRangeChanged(newPosition, userListModelArrayList.size)
                    }
                }, 1000)
            }
        }

        // counters.put(tv, cdt);
        cdt.start()
    }

    override fun getItemCount(): Int {
        return userListModelArrayList.size
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var txtName: TextView
        var txtEmail: TextView
        var txtTimeRemaining: TextView

        init {
            txtEmail = itemView.findViewById(R.id.txtEmail)
            txtName = itemView.findViewById(R.id.txtName)
            txtTimeRemaining = itemView.findViewById(R.id.txtTimeRemaining)
        }
    }

}