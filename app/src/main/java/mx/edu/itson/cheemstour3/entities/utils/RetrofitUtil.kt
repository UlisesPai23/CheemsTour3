package mx.edu.itson.cheemstour3.entities.utils

import com.google.gson.GsonBuilder
import mx.edu.itson.cheemstour3.interfaces.CheemsAPI
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitUtil {

    fun getApi() : CheemsAPI{
        val gson = GsonBuilder().create()

        val retrofit = Retrofit.Builder().baseUrl("127.0.0.1:5000").addConverterFactory(GsonConverterFactory.create(gson)).build()

        return retrofit.create(CheemsAPI::class.java)

    }

}