package com.tzx.rs2vicitim.adapter

import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.viewholder.BaseViewHolder
import com.tzx.rs2vicitim.R

class PlayersAdapter(resid:Int,list:ArrayList<String>) : BaseQuickAdapter<String, BaseViewHolder>(resid,list) {
    override fun convert(holder: BaseViewHolder, item: String) {
        holder.setText(R.id.textView18,(holder.adapterPosition+1).toString())
            ?.setText(R.id.textView19,item)
    }
}