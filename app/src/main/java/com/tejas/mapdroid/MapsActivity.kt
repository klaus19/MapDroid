package com.tejas.mapdroid

import android.location.Location
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.FragmentActivity

import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import com.tejas.mapdroid.databinding.ActivityMapsBinding

class MapsActivity : FragmentActivity(), OnMapReadyCallback {

   private var sydney:LatLng = LatLng(-34.0,151.0)
   private var Tamworth:LatLng = LatLng(-31.083332, 150.916672)
   private var NewCastle:LatLng = LatLng(-32.916668, 151.750000)
   private var Brisbane:LatLng = LatLng(-27.470125, 153.021072)

    private lateinit var mMap: GoogleMap
    private lateinit var binding: ActivityMapsBinding
    private lateinit var locationArray: ArrayList<LatLng>



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMapsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        val mapFragment = supportFragmentManager
            .findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)

       // locationArray= arrayListOf()

        locationArray.add(sydney)
        locationArray.add(Tamworth)
        locationArray.add(NewCastle)
        locationArray.add(Brisbane)


    }

    override fun onMapReady(googleMap: GoogleMap) {
        mMap = googleMap

        //Inside the onMapReady method we will discover all the methods that are needed to be
        for(i in locationArray){
            // below line is use to add marker to each location of our array list.
            mMap.addMarker(MarkerOptions().position(i).title("Marker"))

            //below line is used to zoom our camera on map.
            mMap.animateCamera(CameraUpdateFactory.zoomTo(18.0f))

            // below line is use to move our camera to the specific location
           // mMap.moveCamera(CameraUpdateFactory.newLatLng(locationArray))
            mMap.moveCamera(CameraUpdateFactory.newLatLng(i))
        }

    }
}