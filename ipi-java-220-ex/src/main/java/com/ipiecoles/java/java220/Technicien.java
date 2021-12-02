package com.ipiecoles.java.java220;

import org.joda.time.LocalDate;

import java.util.Objects;


public class Technicien extends Employe implements Comparable<Technicien> {

    private Integer grade;

    public Technicien() {

    }

    public Technicien(String nom, String prenom, String matricule, LocalDate dateEmbauche, Double salaire, Integer grade) {
        super(nom, prenom, matricule, dateEmbauche, salaire);
        this.grade = grade;
    }
    @Override
    public Double getPrimeAnnuelle() {
        return Entreprise.primeAnnuelleBase() * (1+grade*0.1) +
               Entreprise.PRIME_ANCIENNETE * this.getNombreAnneeAnciennete();

    }
    @Override
    public double getNbConges() {
        return super.getNbConges() + this.getNombreAnneeAnciennete() + Cadre.coefficient;
    }

    /**
     * @return the grade
     */
    public Integer getGrade() {
        return grade;
    }

    /**
     * @param grade the grade to set
     * @
     */

    public void setGrade(Integer grade)  {
        if(grade <= 0 || grade > 5) {

        }
        this.grade = grade;
    }

    @Override
    public void setSalaire(Double salaire) {
        super.setSalaire( salaire * (1 + (double) grade / 10));
    }

    @Override
    public String toString() {
        return "Technicien{" +
                "grade=" + grade +
                "} " + super.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Technicien)) return false;
        if (!super.equals(o)) return false;
        Technicien that = (Technicien) o;
        return Objects.equals(grade, that.grade);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), grade);
    }

    @Override
    public int compareTo(Technicien o) {
        if(this.getGrade() < o.getGrade()){
            return -1;
        }
        else if (this.getGrade() > o.getGrade()){
            return 1;
        }
        return 0;
        //return Integer.compare(this.grade, o.getGrade());
    }
}

