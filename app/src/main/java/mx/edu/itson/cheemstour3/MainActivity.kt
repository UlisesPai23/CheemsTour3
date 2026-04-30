package mx.edu.itson.cheemstour3

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowCompat.enableEdgeToEdge
import androidx.core.view.WindowInsetsCompat
import mx.edu.itson.cheemstour3.entities.Trip
import mx.edu.itson.cheemstour3.entities.utils.RetrofitUtil
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import android.util.Log

class MainActivity : AppCompatActivity(), View.OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val btnTripMap = findViewById<View>(R.id.btnTripMap)
        btnTripMap.setOnClickListener (this)

        val btnTripForm = findViewById<View>(R.id.btnTripForm)
        btnTripForm.setOnClickListener (this)

    }

    override fun onClick(view: View) {
        when(view.id){
            R.id.btnTripMap -> {
                val intentMap = Intent(this, TripMapActivity::class.java)
                startActivity(intentMap)
            }

            R.id.btnTripForm -> {
                val intentMap = Intent(this, TripFormActivity::class.java)
                startActivity(intentMap)
            }
        }
    }


}
