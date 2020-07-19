package com.tzx.rs2vicitim.ui.home

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.tzx.rs2vicitim.R
import com.tzx.rs2vicitim.adapter.DetailAdapter
import com.tzx.rs2vicitim.adapter.PlayersAdapter
import com.tzx.rs2vicitim.data.PlayerList
import com.tzx.rs2vicitim.data.ServerList
import com.tzx.rs2vicitim.utils.PingNet
import com.tzx.rs2vicitim.utils.PingNetEntity
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class Server_detail_item : Fragment() {
    companion object {
        fun newInstance() = Server_detail_item()
    }
    private lateinit var itemdetail:ServerList.Servers
    private lateinit var title:TextView
    private lateinit var recyclerView_server: RecyclerView
    private lateinit var recyclerView_player: RecyclerView
    private lateinit var detailAdapter: DetailAdapter
    private lateinit var playersAdapter: PlayersAdapter
    private lateinit var progressBar: ProgressBar
    val args: Server_detail_itemArgs by navArgs()
    private var list=ArrayList<Pair<String,String>>() //服务器数据
    private var list1=ArrayList<String>() //玩家数据
    private lateinit  var viewModel: HomeViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewModel = ViewModelProvider(this).get(HomeViewModel::class.java)
        return inflater.inflate(R.layout.server_detail_item_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        title=view?.findViewById(R.id.textView23) as TextView
        val layoutManager = LinearLayoutManager(requireContext())
        val layoutManager1 = LinearLayoutManager(requireContext())
        recyclerView_server=view?.findViewById(R.id.recyclerView) as RecyclerView
        recyclerView_player=view?.findViewById(R.id.recyclerView2) as RecyclerView
        progressBar=view?.findViewById(R.id.progressBar2) as ProgressBar
        recyclerView_server.layoutManager=layoutManager
        recyclerView_player.layoutManager=layoutManager1
        detailAdapter= DetailAdapter(R.layout.detailitem,list)
        playersAdapter= PlayersAdapter(R.layout.playeritem,list1)
        recyclerView_server.adapter=detailAdapter
        detailAdapter.recyclerView=recyclerView_server
        recyclerView_player.adapter=playersAdapter
        playersAdapter.recyclerView=recyclerView_player
        if(args.item!=null)
            itemdetail=args.item
        Log.d("tzx", "onActivityCreated: "+itemdetail.attributes.status)
        activity?.runOnUiThread {
            title.setText(itemdetail.attributes.name)
        }
        list.add(Pair("服务器ip地址",itemdetail.attributes.ip+":"+itemdetail.attributes.port))
        list.add(Pair("状态",itemdetail.attributes.status))
        list.add(Pair("实时延迟","测量中..."))
        list.add(Pair("所在地区",itemdetail.attributes.country))
        list.add(Pair("创建时间",itemdetail.attributes.createdAt))
        list.add(Pair("在线玩家数",itemdetail.attributes.players))
        list.add(Pair("最大玩家数",itemdetail.attributes.maxPlayers))
        list.add(Pair("地图",itemdetail.attributes.details.map))
        list.add(Pair("游戏模式",if(itemdetail.attributes.details.rs2v_bIsCampaignGame.toBoolean()==true) "战役模式" else "其他"))
        list.add(Pair("服务器steamid",itemdetail.attributes.details.serverSteamId))
        list.add(Pair("是否记Rank",if(itemdetail.attributes.details.rs2v_bIsRanked.toBoolean()==true) "是" else "否"))
        detailAdapter.setList(list)
        progressBar.isIndeterminate=true
        progressBar.visibility=View.VISIBLE
        GlobalScope.launch {
           var pingNetEntity=PingNetEntity(itemdetail.attributes.ip,4,5, StringBuffer())
            pingNetEntity = PingNet.ping(pingNetEntity)
            Log.d("tzx", "ping: "+pingNetEntity.pingTime)
            activity?.runOnUiThread {
                detailAdapter.setData(2,Pair("实时延迟",pingNetEntity.pingTime))
            }
        }
        viewModel.GetPlayers(itemdetail.attributes.id)
        viewModel.playlist.observe(viewLifecycleOwner, Observer {
            it->
            Log.d("tzx", "onActivityCreated: "+it.data.size+" "+itemdetail.attributes.id)
            list1.clear()
            for(item:PlayerList.Player in it.data)list1.add(item.attributes.name)
            progressBar.visibility=View.GONE
            playersAdapter.setList(list1)
        })
    }

}