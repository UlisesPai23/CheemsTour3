package mx.edu.itson.cheemstour3

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.Marker
import com.google.android.gms.maps.model.MarkerOptions

class TripFormActivity : AppCompatActivity(), View.OnClickListener, OnMapReadyCallback {

    var map : GoogleMap? = null
    lateinit var name: EditText
    lateinit var btnSave : Button
    lateinit var city: EditText
    var latitude: Double = 0.0
    var longitude : Double = 0.0


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_trip_form)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        name = findViewById(R.id.txt_name)
        city = findViewById(R.id.txt_city)
        btnSave = findViewById(R.id.btn_save)
        btnSave.setOnClickListener (this)

        var mapFragment = supportFragmentManager.findFragmentById(R.id.map_form) as SupportMapFragment
        mapFragment.getMapAsync(this)



    }

    override fun onClick(view: View) {
        when(view.id){
            R.id.btn_save -> {

            }
        }
    }

    override fun onMapReady(googleMap: GoogleMap) {
        try {
            map = googleMap
            map!!.mapType = GoogleMap.MAP_TYPE_HYBRID

            map?.clear()

            var latLng = LatLng(0.0,0.0)

            map?.addMarker(MarkerOptions().position(latLng).draggable(true))
            map?.moveCamera(CameraUpdateFactory.newLatLng(latLng))
            map?.animateCamera(CameraUpdateFactory.zoomTo(8f))

            map?.setOnMarkerDragListener(object : GoogleMap.OnMarkerDragListener{
                override fun onMarkerDrag(p0: Marker) {

                }

                override fun onMarkerDragEnd(marker: Marker) {
                    val latLng = marker.position
                    latitude = latLng.latitude
                    longitude = latLng.longitude

                    Log.d("Latitude", latitude.toString())
                    Log.d("Longitude", longitude.toString())

                }

                override fun onMarkerDragStart(p0: Marker) {

                }

            })

        } catch (ex: Exception){
            Log.e("Error al cargar el mapa", ex.message.toString())
        }
    }
}