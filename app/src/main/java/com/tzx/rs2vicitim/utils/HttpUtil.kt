package com.tzx.rs2vicitim.utils

import android.content.Context
import android.util.Log

fun getAppVersionCode(context: Context):String{
    var versioncode = 0
    try {
        var pm = context.getPackageManager();
       var  pi = pm.getPackageInfo(context.getPackageName(), 0);
        versioncode = pi.versionCode;
    } catch ( e:Exception) {
        Log.e("VersionInfo", "Exception", e);
    }
    return versioncode.toString()
}
fun getAppVersionName(context: Context):String{
    var versionName: String? = null
    try {
        var pm = context.getPackageManager();
        var pi = pm.getPackageInfo(context.getPackageName(), 0);
        versionName = pi.versionName;
    } catch ( e:Exception) {
        Log.e("VersionInfo", "Exception", e);
    }
    return versionName.toString()
}