package com.example.room.list

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.room.Data.User
import com.example.room.R

class RecUser:RecyclerView.Adapter<RecUser.UserHolder>(), OncCicked {

    var list: List<User> = ArrayList()
    var oncCicked: OncCicked?=null

    fun setUserList(list: List<User>){

        this.list=list
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserHolder {
      var view:View=LayoutInflater.from(parent.context).inflate(R.layout.useritem,parent,false)
    return UserHolder(view)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: UserHolder, position: Int) {

       holder.bind(list.get(position),position)

    }

   inner class UserHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        var Name: TextView =itemView.findViewById(R.id.UserName)
        var Year: TextView =itemView.findViewById(R.id.UserPhone)
        var View: TextView =itemView.findViewById(R.id.Deleted)

        fun bind(user: User,position: Int){
            Name.text=list.get(position).Name
            Year.text=list.get(position).phone

            View.setOnClickListener {
                oncCicked?.onClicked(user)
            }
        }


    }

    override fun onClicked(user: User) {

    }
}