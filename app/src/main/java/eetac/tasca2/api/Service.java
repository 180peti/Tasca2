package eetac.tasca2.api;

import java.util.ArrayList;
import java.util.List;

import eetac.tasca2.modelo.Lista;
import eetac.tasca2.modelo.Pelicula;
import retrofit2.Call;
import retrofit2.http.Query;
import retrofit2.http.GET;

/**
 * Created by Alex Aguilera on 15/12/2017.
 */

public interface Service {


    @GET("/search/movie")
    Call<Lista> getSearch(@Query("api_key") String apiKey, @Query("query") String queryString);

}
