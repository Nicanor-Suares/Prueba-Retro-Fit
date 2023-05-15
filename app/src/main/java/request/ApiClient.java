package request;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import models.Propietario;
import models.Usuario;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;

public class ApiClient {

    private static final String BASE_URL = "http://practicastuds.ulp.edu.ar/api/";
    private static EndpointInmobiliaria endpoint;

    public static EndpointInmobiliaria getEndpoint() {

        Gson gson = new GsonBuilder().setLenient().create();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        endpoint = retrofit.create(EndpointInmobiliaria.class);
        return endpoint;
    }

    public interface EndpointInmobiliaria{
        @POST("http://practicastuds.ulp.edu.ar/api/Propietarios/login")
        Call<String> login(@Body Usuario user);

        @GET("http://practicastuds.ulp.edu.ar/api/Propietarios")
        Call<Propietario> obtenerPerfil(@Header("Authorization") String token);
    }
}
