package com.example.a8x302.qllistphonggym.Fragments

import android.content.Context
import android.graphics.Bitmap
import android.graphics.Canvas
import android.location.Location
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.content.ContextCompat
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.a8x302.qllistphonggym.Layout.CustomInfoWindowGoogleMap
import com.example.a8x302.qllistphonggym.R
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.BitmapDescriptor
import com.google.android.gms.maps.model.BitmapDescriptorFactory
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions

class MapFragment : Fragment(), OnMapReadyCallback, GoogleMap.OnMyLocationButtonClickListener,
    GoogleMap.OnMyLocationClickListener {
    private var infoWindow: ViewGroup? = null
    internal val latlng1 = LatLng(10.820885, 106.686774)
    internal val latlng2 = LatLng(10.821812, 106.688577)
    override fun onMapReady(p0: GoogleMap?) {
        p0!!.mapType = GoogleMap.MAP_TYPE_NORMAL
        val customInfoWindow = CustomInfoWindowGoogleMap(context!!)
        p0.setInfoWindowAdapter(customInfoWindow)
        p0.clear() //clear old markers
        p0.animateCamera(CameraUpdateFactory.newLatLngZoom(latlng1, 15f), 2000, null)

        p0.addMarker(MarkerOptions()
                .position(latlng2)
                .title("Thi Nguyễn Gim")
                .snippet("AmisunXXXXXX")
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.simple_house_thin)))

        p0.addMarker(MarkerOptions()
                .position(latlng1)
                .title("Thi Nguyễn Gym")
                .snippet("AmisunXXXXXX")
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.simple_house_thin)))
    }

    override fun onMyLocationButtonClick(): Boolean {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onMyLocationClick(p0: Location) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
    private fun bitmapDescriptorFromVector(context: Context?, vectorResId: Int): BitmapDescriptor {
        val vectorDrawable = ContextCompat.getDrawable(context!!, vectorResId)
        vectorDrawable!!.setBounds(0, 0, vectorDrawable.intrinsicWidth, vectorDrawable.intrinsicHeight)
        val bitmap = Bitmap.createBitmap(vectorDrawable.intrinsicWidth, vectorDrawable.intrinsicHeight, Bitmap.Config.ARGB_8888)
        val canvas = Canvas(bitmap)
        vectorDrawable.draw(canvas)
        return BitmapDescriptorFactory.fromBitmap(bitmap)
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val rootView = inflater.inflate(R.layout.fragment_map, container, false)
        this.infoWindow = layoutInflater.inflate(R.layout.custom_infowindow, null) as ViewGroup
        val mapFragment =
            childFragmentManager.findFragmentById(R.id.frg) as SupportMapFragment
        mapFragment.getMapAsync(this)
        return rootView
    }
}