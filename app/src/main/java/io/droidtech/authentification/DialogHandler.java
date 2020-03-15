package io.droidtech.authentification;

import android.app.ProgressDialog;
import android.content.Context;

public class DialogHandler {

    public static ProgressDialog pDialog;

    public static void showProgDialog(Context context, String message) {
        pDialog = new ProgressDialog(context);
        pDialog.setMessage(message);
        pDialog.setCancelable(false);
        pDialog.show();
    }

    public static void hideProgDialog() {
        if (pDialog.isShowing()) {
            pDialog.dismiss();
        }
    }

}
