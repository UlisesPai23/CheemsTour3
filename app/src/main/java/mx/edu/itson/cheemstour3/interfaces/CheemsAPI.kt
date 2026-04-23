package mx.edu.itson.cheemstour3.interfaces

import mx.edu.itson.cheemstour3.entities.Trip
import retrofit2.Call
import retrofit2.http.GET

interface CheemsAPI {

    @GET("trips")
    fun getTrips() : Call<List<Trip>>

}