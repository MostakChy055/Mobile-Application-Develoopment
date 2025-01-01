package com.hadi.housepal.view.home

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.hadi.housepal.R
import com.hadi.housepal.data.Room

class RoomAdapter(
    private val roomList: List<Room>,
    private val onChatClicked: (Room) -> Unit,
    private val onPhoneClicked: (Room) -> Unit
) : RecyclerView.Adapter<RoomAdapter.RoomViewHolder>() {

    inner class RoomViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val roomImage: ImageView = view.findViewById(R.id.roomImageView)
        val phoneIcon: ImageView = view.findViewById(R.id.phoneIcon)
        val chatIcon: ImageView = view.findViewById(R.id.chatIcon)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RoomViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_room_card, parent, false)
        return RoomViewHolder(view)
    }

    override fun onBindViewHolder(holder: RoomViewHolder, position: Int) {
        val room = roomList[position]

        holder.roomImage.setImageResource(room.imageResId)

        holder.phoneIcon.setOnClickListener {
            onPhoneClicked(room)
        }

        holder.chatIcon.setOnClickListener {
            onChatClicked(room)
        }
    }

    override fun getItemCount() = roomList.size
}
