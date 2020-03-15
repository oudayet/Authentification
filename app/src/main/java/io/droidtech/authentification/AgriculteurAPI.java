package io.droidtech.authentification;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface AgriculteurAPI {

    @POST("agriculteur/inscription.php")
    Call<Agriculteur> inscription(@Body Agriculteur agriculteur);

    @POST("agriculteur/authentification.php")
    Call<Agriculteur> authentification(@Body Agriculteur agriculteur);

}
