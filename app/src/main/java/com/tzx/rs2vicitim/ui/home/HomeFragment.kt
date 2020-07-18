package com.tzx.rs2vicitim.ui.home

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.tzx.rs2vicitim.R
import com.tzx.rs2vicitim.adapter.serverItemAdapter
import com.tzx.rs2vicitim.data.ServerList


class HomeFragment : Fragment() {

    private lateinit var homeViewModel: HomeViewModel
    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter:serverItemAdapter
    private lateinit var processbar:ProgressBar
    private var list=ArrayList<ServerList.Servers>()
    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        homeViewModel =
                ViewModelProvider(this).get(HomeViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_home, container, false)
        recyclerView=root?.findViewById(R.id.serverlist) as RecyclerView
        processbar=root?.findViewById(R.id.progressBar)
        processbar.isIndeterminate=true
        processbar.visibility=View.VISIBLE
        val layoutManager = LinearLayoutManager(requireContext())
      //  layoutManager.orientation = LinearLayoutManager.HORIZONTAL
        recyclerView.layoutManager = layoutManager
        adapter= serverItemAdapter(R.layout.serveritem,list)
        recyclerView.adapter=adapter
        adapter.recyclerView=recyclerView
        homeViewModel.GetServers()
        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        homeViewModel.serverlist.observe(viewLifecycleOwner, Observer {
            it->
            Log.d("tzx", "onViewCreated: "+it.data.size)
            list.clear()
            for(item in it.data)list.add(item)
            Log.d("tzx", "onViewCreated: "+list.size)

            processbar.visibility=View.GONE
            adapter.setList(list)
        })
    }
}