package com.ipiecoles.java.java220;

import org.joda.time.LocalDate;

import java.util.Objects;

public abstract class Cadre extends Employe{
    public static Double coefficient = 1d;

    public Cadre(String nom, String prenom, String matricule, LocalDate dateEmbauche, Double salaire, Boolean tempsPartiel, String sexe, Double coefficient) {
        super(nom, prenom, matricule, dateEmbauche, salaire, tempsPartiel, sexe);
        this.coefficient = coefficient;
    }

    public Double getCoefficient() {return coefficient;}
    public void setCoefficient(Double coefficient) {this.coefficient = coefficient;}

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Cadre cadre = (Cadre) o;
        return coefficient.equals(cadre.coefficient);
    }

    @Override
    public int hashCode() {return Objects.hash(super.hashCode(), coefficient);}
}
