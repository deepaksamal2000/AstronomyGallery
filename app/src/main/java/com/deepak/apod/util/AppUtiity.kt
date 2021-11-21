package com.deepak.apod.util

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.Color
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import android.util.Log
import android.view.View
import android.widget.TextView
import androidx.core.content.ContextCompat
import com.deepak.apod.R
import com.google.android.material.snackbar.Snackbar
import java.time.LocalDate

fun isOnline(context: Context): Boolean {
    val connectivityManager =
        context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
    val capabilities =
        connectivityManager.getNetworkCapabilities(connectivityManager.activeNetwork)
    if (capabilities != null) {
        if (capabilities.hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR)) {
            Log.i("Internet", "NetworkCapabilities.TRANSPORT_CELLULAR")
            return true
        } else if (capabilities.hasTransport(NetworkCapabilities.TRANSPORT_WIFI)) {
            Log.i("Internet", "NetworkCapabilities.TRANSPORT_WIFI")
            return true
        } else if (capabilities.hasTransport(NetworkCapabilities.TRANSPORT_ETHERNET)) {
            Log.i("Internet", "NetworkCapabilities.TRANSPORT_ETHERNET")
            return true
        }
    }
    return false
}

@SuppressLint("SimpleDateFormat")
fun compareDate(date: String): Boolean {

    val now :LocalDate= LocalDate.parse(date)
    val yesterday = LocalDate.now().minusDays(1)

    return yesterday.equals(now)
}

fun showSnackBar(context: Context, rootView: View, text: String  ){
    val snack =
        Snackbar.make(rootView, text, Snackbar.LENGTH_LONG)
    val view = snack.view

    view.rootView.setBackgroundColor(
        ContextCompat.getColor(context, R.color.white)
    )
    val tv = view.findViewById<View>(com.google.android.material.R.id.snackbar_text) as TextView
    tv.setTextColor(Color.BLACK)
    snack.show()

}