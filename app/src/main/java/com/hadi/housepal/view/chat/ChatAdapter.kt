package com.hadi.housepal.view.chat

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.imageview.ShapeableImageView
import com.hadi.housepal.R

data class MessageItem(
    val profileImage: Int,
    val name: String,
    val status: String,
    val lastMessage: String,
    val timestamp: String
)

class MessageAdapter(private val messageList: List<MessageItem>) :
    RecyclerView.Adapter<MessageAdapter.MessageViewHolder>() {

    class MessageViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val profileImage: ShapeableImageView = view.findViewById(R.id.profileImage)
        val name: TextView = view.findViewById(R.id.tvName)
        val status: TextView = view.findViewById(R.id.tvStatus)
        val lastMessage: TextView = view.findViewById(R.id.tvLastMessage)
        val timestamp: TextView = view.findViewById(R.id.tvTimestamp)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MessageViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_message, parent, false)
        return MessageViewHolder(view)
    }

    override fun onBindViewHolder(holder: MessageViewHolder, position: Int) {
        val item = messageList[position]
        holder.profileImage.setImageResource(item.profileImage)
        holder.name.text = item.name
        holder.status.text = item.status
        holder.lastMessage.text = item.lastMessage
        holder.timestamp.text = item.timestamp
    }

    override fun getItemCount(): Int = messageList.size
}
