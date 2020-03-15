package io.droidtech.authentification;

import android.content.Context;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static io.droidtech.authentification.Contants.BASE_URL;
import static io.droidtech.authentification.DialogHandler.hideProgDialog;

public class AgricultureRespository {

    private AgriculteurListener listener;

    private Context _context;
    private Retrofit retrofit;
    private AgriculteurAPI agriculteurAPI;
    private Call<Agriculteur> call;

    AgricultureRespository(Context _context) {
        this._context = _context;

        Gson gson = new GsonBuilder().setLenient().create();
        retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();
    }

    void authentification(Agriculteur agriculteur) {


        agriculteurAPI = retrofit.create(AgriculteurAPI.class);

        call = agriculteurAPI.authentification(agriculteur);

        call.enqueue(new Callback<Agriculteur>() {
            @Override
            public void onResponse(Call<Agriculteur> call, Response<Agriculteur> response) {
                hideProgDialog();
                Agriculteur agr = response.body();

                if (listener != null)
                    listener.onResultHandler(agr);

            }

            @Override
            public void onFailure(Call<Agriculteur> call, Throwable t) {
                hideProgDialog();
                if (listener != null)
                    listener.onErrorHandler("Erreur: " + t.getMessage());
            }
        });
    }

    void setMyCustomListener(AgriculteurListener listener) {
        this.listener = listener;
    }

}
