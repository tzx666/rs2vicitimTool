package com.tzx.rs2vicitim.adapter

import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.viewholder.BaseViewHolder
import com.tzx.rs2vicitim.R
import com.tzx.rs2vicitim.data.ServerList

class DetailAdapter: BaseQuickAdapter<Pair<String,String>, BaseViewHolder> {
    constructor(resid:Int,lists:ArrayList<Pair<String,String>>) : super(resid,lists) {
    }

    override fun convert(holder: BaseViewHolder, item:Pair<String,String>) {
        holder.setText(R.id.textView15,item.first).setText(R.id.textView17,item.second)
    }
}