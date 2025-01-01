package com.hadi.housepal.view.home

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.hadi.housepal.R
import com.hadi.housepal.data.Room

class HomeFragment : Fragment() {

    private lateinit var roomAdapter: RoomAdapter
    private val roomList = listOf(
        Room(R.drawable.sample_room, "123-456-7890"),
        Room(R.drawable.sample_room, "987-654-3210")
    )

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Log.d("HomeFragment", "HomeFragment created")

        val recyclerView: RecyclerView = view.findViewById(R.id.roomRecyclerView)
        roomAdapter = RoomAdapter(roomList,
            onChatClicked = { room -> navigateToChatScreen() },
            onPhoneClicked = { room -> dialPhoneNumber(room.contactPhone) }
        )
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        recyclerView.adapter = roomAdapter
    }

    private fun navigateToChatScreen() {
//        findNavController().navigate(R.id.action_home_to_chat)
    }

    private fun dialPhoneNumber(phone: String) {
        val intent = Intent(Intent.ACTION_DIAL).apply {
            data = Uri.parse("tel:$phone")
        }
        startActivity(intent)
    }
}
