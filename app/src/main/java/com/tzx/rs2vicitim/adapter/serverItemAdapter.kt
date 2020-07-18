package com.tzx.rs2vicitim.adapter

import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.viewholder.BaseViewHolder
import com.tzx.rs2vicitim.R
import com.tzx.rs2vicitim.data.ServerList

class serverItemAdapter :BaseQuickAdapter<ServerList.Servers,BaseViewHolder> {
    constructor(resid:Int,lists:ArrayList<ServerList.Servers>) : super(resid,lists) {
    }
    override fun convert(holder: BaseViewHolder, item: ServerList.Servers) {
        holder.setText(R.id.textView8,item.attributes.name )
            .setText(R.id.textView10,item.attributes.status)
            .setText(R.id.textView12,item.attributes.players+"/"+item.attributes.maxPlayers)
            .setText(R.id.textView14,item.attributes.details.map)
    }
}