package com.tzx.rs2vicitim.ui.home

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.google.gson.Gson
import com.tzx.rs2vicitim.data.PlayerList
import com.tzx.rs2vicitim.data.ServerList
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async
import kotlinx.coroutines.launch
import okhttp3.OkHttp
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.Response


class HomeViewModel : ViewModel() {
    private val gson= Gson()
    private val serverlists= MutableLiveData<ServerList>()
    private val _text = MutableLiveData<String>().apply {
        value = "This is home Fragment"
    }
    private val playerlists=MutableLiveData<PlayerList>()
    val text: LiveData<String> = _text
    val serverlist: LiveData<ServerList> = serverlists
    val playlist:LiveData<PlayerList> = playerlists
    fun GetServers(){
        GlobalScope.launch {
            val list= async { getlist() }
           serverlists.postValue(list.await())
        }
    }
    fun GetPlayers(id:String){
        GlobalScope.launch {
            val list=async { getplaylist(id) }
            playerlists.postValue(list.await())
        }
    }
    fun getplaylist(serverid:String):PlayerList{
        val client = OkHttpClient().newBuilder()
            .build()
        val request: Request =Request.Builder()
            .url("https://api.battlemetrics.com/players?filter[servers]="+serverid+"&page[size]=64")
            .method("GET", null)
            .addHeader(
                "chinesers2vietnam",
                "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ0b2tlbiI6IjVlNTk0NDc3MDRjYTZmMWQiLCJpYXQiOjE1OTUwNzE0MjMsIm5iZiI6MTU5NTA3MTQyMywiaXNzIjoiaHR0cHM6Ly93d3cuYmF0dGxlbWV0cmljcy5jb20iLCJzdWIiOiJ1cm46dXNlcjoyMzYxOTAifQ.PNQBe48wK5KOM4VLPWsWZ8Nb95uNKEyFmf-9ZTEDpTs"
            )
            .build()
        val response: Response = client.newCall(request).execute()
        val res=response.body?.string()
        Log.d("tzx", res)
        if(res==null)return PlayerList()
        else{
            val list=gson.fromJson(res,PlayerList::class.java)
            return list
        }
    }
    private fun getlist():ServerList{
        val client = OkHttpClient().newBuilder()
            .build()
        val request: Request =Request.Builder()
            .url("https://api.battlemetrics.com/servers?filter%5Bgame%5D=rs2vietnam&filter%5BmaxDistance%5D=5000")
            .method("GET", null)
            .addHeader(
                "chinesers2vietnam",
                "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ0b2tlbiI6IjVlNTk0NDc3MDRjYTZmMWQiLCJpYXQiOjE1OTUwNzE0MjMsIm5iZiI6MTU5NTA3MTQyMywiaXNzIjoiaHR0cHM6Ly93d3cuYmF0dGxlbWV0cmljcy5jb20iLCJzdWIiOiJ1cm46dXNlcjoyMzYxOTAifQ.PNQBe48wK5KOM4VLPWsWZ8Nb95uNKEyFmf-9ZTEDpTs"
            )
            .build()
        val response: Response = client.newCall(request).execute()
        val res=response.body?.string()
        Log.d("tzx", res)
        if(res==null)return ServerList()
        else{
            val list=gson.fromJson(res,ServerList::class.java)
            return list
        }
    }
}