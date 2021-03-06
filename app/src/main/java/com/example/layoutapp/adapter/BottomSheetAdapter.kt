package com.example.layoutapp.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AccelerateInterpolator
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.blankj.utilcode.util.TimeUtils
import com.example.layoutapp.bean.Task
import com.example.layoutapp.databinding.ItemLegendBinding

class BottomSheetAdapter :
    RecyclerView.Adapter<BottomSheetAdapter.ViewHolder>() {

    var data: MutableList<Task> = mutableListOf()
    private lateinit var onItemClickListener: OnItemClickListener
    var currentIndex = 0

    fun setOnItemClickListener(listener: OnItemClickListener) {
        this.onItemClickListener = listener
    }

    interface OnItemClickListener {
        fun onItemClick(view: View, position: Int, item: Task)
        fun onItemLongClick(view: View, position: Int)
    }

    class ViewHolder(private val itemLegendBinding: ItemLegendBinding) :
        RecyclerView.ViewHolder(itemLegendBinding.root) {
        lateinit var tvDate: TextView
        fun bind(item: Task) {
            tvDate = itemLegendBinding.tvDate
            itemLegendBinding.apply {
                itemLegendBinding.tvDate.text = TimeUtils.millis2String(item.create_time)
                task = item
                executePendingBindings()
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            ItemLegendBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = data[position]
        holder.bind(item)
        if (currentIndex == position) {
            holder.itemView.animate()?.scaleX(1F)?.scaleY(1F)?.setDuration(100)
                ?.setInterpolator(AccelerateInterpolator())
                ?.start()
        } else {
            holder.itemView.animate()?.scaleX(0.75F)?.scaleY(0.75F)?.setDuration(100)
                ?.setInterpolator(AccelerateInterpolator())
                ?.start()
        }

        Log.d("mylog", "onBindViewHolder: " + currentIndex + "position" + position)

        holder.itemView.setOnClickListener {
            val lastIndex = currentIndex
            currentIndex = position
            notifyItemChanged(currentIndex)
            if (lastIndex >= 0) {
                notifyItemChanged(lastIndex);
            }

            onItemClickListener.onItemClick(holder.itemView, position, item)
        }
    }


    override fun getItemCount(): Int = data.size


}