package com.mdapp.countriesflags.NesterRecyclerView.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.mdapp.countriesflags.R

class InnerAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    private var mList: ArrayList<Int>? = null
    private var mitemClickListener: OnItemClickListener? = null
    fun updateList(list: ArrayList<Int>?) {
        mList = list
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return CellViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.detail_list_items, parent, false)
        )
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        mList?.let {
            if (holder is CellViewHolder) {
                holder.bindViews(it[position])
            }
        }
    }

    override fun getItemCount(): Int {
        return if (mList == null) 0 else mList!!.size
    }

    private interface UpdateViewHolder {
        fun bindViews(data: Int)
    }

    interface OnItemClickListener {
        fun onItemClick(view: View, data: Int)
        fun onItemLongClick(view: View, data: Int)
    }

    fun setOnItemClickListener(mItemClickListener: OnItemClickListener?) {
        this.mitemClickListener = mItemClickListener
    }

    private inner class CellViewHolder(view: View) : RecyclerView.ViewHolder(view),
        UpdateViewHolder, View.OnClickListener, View.OnLongClickListener {
        private var num = 0
        override fun bindViews(data: Int) {
            num = data
            val textView: TextView = itemView.findViewById(R.id.textview)
            textView.text = data.toString()
            itemView.setOnClickListener(this)
            itemView.setOnLongClickListener(this)
        }

        override fun onClick(v: View) {
            mitemClickListener?.onItemClick(v, num)
        }

        override fun onLongClick(v: View): Boolean {
            mitemClickListener?.onItemLongClick(v, num)
            return true
        }
    }
}