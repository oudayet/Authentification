package io.droidtech.authentification;

public interface AgriculteurListener {

    void onResultHandler(Agriculteur agriculteur);

    void onErrorHandler(String error);

}
