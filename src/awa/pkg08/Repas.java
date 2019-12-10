/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package awa.pkg08;

import java.time.LocalDate;

/**
 *
 * @author etudiant
 */
public class Repas {

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public boolean isSoir() {
        return soir;
    }

    public void setSoir(boolean soir) {
        this.soir = soir;
    }

    public String getSpecialite() {
        return specialite;
    }

    public void setSpecialite(String specialite) {
        this.specialite = specialite;
    }

    public int getNbCouverts() {
        return nbCouverts;
    }

    public void setNbCouverts(int nbCouverts) {
        this.nbCouverts = nbCouverts;
    }

    public boolean isBio() {
        return bio;
    }

    public void setBio(boolean bio) {
        this.bio = bio;
    }

    public boolean isVegan() {
        return vegan;
    }

    public void setVegan(boolean vegan) {
        this.vegan = vegan;
    }

    public int getPaf() {
        return paf;
    }

    public void setPaf(int paf) {
        this.paf = paf;
    }
    private LocalDate date;
    private boolean soir = true;
    private String specialite;
    private int nbCouverts = 3;
    private boolean bio = false;
    private boolean vegan = false;
    private int paf = 15;
    
}
