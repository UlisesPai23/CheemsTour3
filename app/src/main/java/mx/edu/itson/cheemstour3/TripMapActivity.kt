package mx.edu.itson.cheemstour3

import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import mx.edu.itson.cheemstour3.entities.Trip
import mx.edu.itson.cheemstour3.entities.utils.RetrofitUtil
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class TripMapActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_trip_map)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        getTrips()

    }
    fun getTrips(){
        val call : Call<List<Trip>> = RetrofitUtil.getApi().getTrips()
        call.enqueue(object : Callback<List<Trip>>{
            override fun onResponse(
                call: Call<List<Trip>?>,
                response: Response<List<Trip>?>
            ) {
                val trips : List<Trip> = response.body()!!
                for(t in trips){

                }
            }

            override fun onFailure(
                call: Call<List<Trip>?>,
                t: Throwable
            ) {
                Log.e("error calling API", "Error }: ${t.message}")
            }

        })
    }
}