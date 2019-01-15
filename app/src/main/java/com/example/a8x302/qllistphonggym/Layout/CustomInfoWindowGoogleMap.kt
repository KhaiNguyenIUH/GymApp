package com.example.a8x302.qllistphonggym.Layout
import android.widget.TextView
import android.R.attr.name
import android.app.Activity
import android.content.Context
import android.view.View
import android.widget.EditText
import com.example.a8x302.qllistphonggym.R
import com.google.android.gms.maps.model.Marker
import com.google.android.gms.maps.GoogleMap


class CustomInfoWindowGoogleMap(private val context: Context) : GoogleMap.InfoWindowAdapter {

    override fun getInfoWindow(marker: Marker): View? {
        return null
    }

    override fun getInfoContents(marker: Marker): View {
        val view = (context as Activity).layoutInflater
                .inflate(R.layout.custom_infowindow, null)

        val name = view.findViewById(R.id.edtname) as TextView
        val address = view.findViewById(R.id.edtdiachi)as TextView
        val sdt = view.findViewById(R.id.edtsdt)as TextView


        name.setText(marker.title)
        address.setText(marker.snippet)

        return view
    }
}