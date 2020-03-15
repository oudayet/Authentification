package io.droidtech.authentification;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputLayout;
import static io.droidtech.authentification.DialogHandler.showProgDialog;
import static io.droidtech.authentification.NetworkAdapter.isConnectedToInternet;

public class MainActivity extends AppCompatActivity {

    TextInputLayout textInputLayoutEmail, textInputLayoutMotDePasse;

    Button buttonSeConnecter;

    Context _context = MainActivity.this;

    Agriculteur agriculteur;
    AgricultureRespository agricultureRespository;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initUIElements();


        buttonSeConnecter.setOnClickListener(v -> {
            authenticate();
        });


    }

    private void authenticate() {
        agriculteur = new Agriculteur(
                textInputLayoutEmail.getEditText().getText().toString(),
                textInputLayoutMotDePasse.getEditText().getText().toString()
        );

        if (checkFields(agriculteur) && checkNetwork()) {
            showProgDialog(_context, "authentification en cours...");
            agricultureRespository.authentification(agriculteur);

            agricultureRespository.setMyCustomListener(new AgriculteurListener() {
                @Override
                public void onResultHandler(Agriculteur agriculteur) {

                    if (agriculteur != null) {
                        if (agriculteur.getId() == -1) {
                            Toast.makeText(_context, "Compte non trouvé", Toast.LENGTH_LONG).show();
                        } else if (agriculteur.getId() == 0) {
                            Toast.makeText(_context, "Veuillez vérifier votre mot de passe", Toast.LENGTH_LONG).show();
                        } else {
                            Toast.makeText(_context, "Bonjour, " + agriculteur.getNom() + " " +
                                    agriculteur.getPrenom(), Toast.LENGTH_LONG).show();
                        }
                    } else {
                        Toast.makeText(_context, "Erreur", Toast.LENGTH_LONG).show();
                    }

                }

                @Override
                public void onErrorHandler(String error) {
                    Toast.makeText(_context, "Erreur: " + error, Toast.LENGTH_LONG).show();
                }
            });
        }
    }

    private boolean checkFields(Agriculteur agriculteur) {
        return true;
    }

    private void initUIElements() {
        textInputLayoutEmail = findViewById(R.id.text_input_layout_email);
        textInputLayoutMotDePasse = findViewById(R.id.text_input_layout_mot_de_passe);

        buttonSeConnecter = findViewById(R.id.button_se_connecter);

        agricultureRespository = new AgricultureRespository(_context);
    }

    private boolean checkNetwork() {
        if (!isConnectedToInternet(_context)) {
            Toast.makeText(_context, "Vous n'avez pas de connexion internet", Toast.LENGTH_LONG).show();
            return false;
        }
        return true;
    }

}
