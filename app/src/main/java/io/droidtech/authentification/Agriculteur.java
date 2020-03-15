package io.droidtech.authentification;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Agriculteur {

    @SerializedName("id")
    @Expose
    private int id;

    @SerializedName("nom")
    @Expose
    private String nom;

    @SerializedName("prenom")
    @Expose
    private String prenom;

    @SerializedName("num_tel")
    @Expose
    private String numTel;

    @SerializedName("email")
    @Expose
    private String email;

    @SerializedName("mot_de_passe")
    @Expose
    private String motDePasse;

    public Agriculteur() {
    }

    public Agriculteur(int id, String nom, String prenom, String numTel, String email, String motDePasse) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.numTel = numTel;
        this.email = email;
        this.motDePasse = motDePasse;
    }

    public Agriculteur(String nom, String prenom, String numTel, String email, String motDePasse) {
        this.nom = nom;
        this.prenom = prenom;
        this.numTel = numTel;
        this.email = email;
        this.motDePasse = motDePasse;
    }

    public Agriculteur(String email, String motDePasse) {
        this.email = email;
        this.motDePasse = motDePasse;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getNumTel() {
        return numTel;
    }

    public void setNumTel(String numTel) {
        this.numTel = numTel;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMotDePasse() {
        return motDePasse;
    }

    public void setMotDePasse(String motDePasse) {
        this.motDePasse = motDePasse;
    }
}
