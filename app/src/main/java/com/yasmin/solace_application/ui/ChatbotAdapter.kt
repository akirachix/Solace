package com.yasmin.solace_application.ui

import android.app.Activity
import androidx.recyclerview.widget.RecyclerView
import android.view.ViewGroup
import android.view.LayoutInflater
import android.view.View
import com.yasmin.solace_application.R
import android.widget.TextView
import com.yasmin.solace_application.models.Message
import java.util.ArrayList

class ChatAdapter(private var activity: Activity, private var messageList: List<Message>) : RecyclerView.Adapter<ChatAdapter.ChatViewHolder>() {


    lateinit var adapter: ChatAdapter

    class ChatViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var messageReceive: TextView = itemView.findViewById(R.id.message_receive)
        var messageSend: TextView = itemView.findViewById(R.id.message_send)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ChatViewHolder {
        val view = LayoutInflater.from(activity).inflate(R.layout.adapter_message_one, parent, false)
        return ChatViewHolder(view)

    }

    override fun onBindViewHolder(holder: ChatViewHolder, position: Int) {
        val message: String = messageList[position].message
        val isReceived: Boolean = messageList[position].isReceived
        if (isReceived) {
            holder.messageReceive.visibility = View.VISIBLE
            holder.messageSend.visibility = View.GONE
            holder.messageReceive.text = message
        } else {
            holder.messageSend.visibility = View.VISIBLE
            holder.messageReceive.visibility = View.GONE
            holder.messageSend.text = message
        }
    }

    override fun getItemCount(): Int {
        return messageList.count()
    }
}