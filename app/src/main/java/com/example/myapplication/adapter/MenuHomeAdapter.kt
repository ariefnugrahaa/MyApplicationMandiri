package com.example.myapplication.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.databinding.ItemMenuHomeBinding
import com.example.myapplication.model.MenuModel

class MenuHomeAdapter(
    private val listMenu: List<MenuModel>
) : RecyclerView.Adapter<MenuHomeAdapter.MenuViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MenuViewHolder {
        return MenuViewHolder(
            ItemMenuHomeBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: MenuViewHolder, position: Int) {
        holder.bind(listMenu[position])
    }

    override fun getItemCount(): Int {
        return listMenu.size
    }

    inner class MenuViewHolder(val binding: ItemMenuHomeBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(data: MenuModel) {
            binding.tvTitleMenuHome.text = data.menuTitle
        }
    }
}