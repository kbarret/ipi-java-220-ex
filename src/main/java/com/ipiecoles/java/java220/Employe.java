package com.ipiecoles.java.java220;

import org.joda.time.DateTime;
import org.joda.time.LocalDate;

import java.util.Objects;


public abstract class Employe {

    //Constantes de classes
    private String nom;

    private String prenom;

    private String matricule;

    private LocalDate dateEmbauche;

    private Double salaire = Entreprise.SALAIRE_BASE;

    public Employe() {

    }

    public Employe(String nom, String prenom, String matricule, LocalDate dateEmbauche, Double salaire) {
        this.nom = nom;
        this.prenom = prenom;
        this.matricule = matricule;
        this.dateEmbauche = dateEmbauche;
        this.salaire = salaire;
    }
    public final Integer getNombreAnneeAnciennete() {
        return LocalDate.now().getYear() - dateEmbauche.getYear();
    }

    public Integer getNbConges() {
        return Entreprise.NB_CONGES_BASE;
    }

    public abstract Double getPrimeAnnuelle();

    public void augmenterSalaire(Double pourcentage) throws Exception {
        this.salaire = this.getSalaire() * (1 + pourcentage);
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

    public String getMatricule() {
        return matricule;
    }
    public void setMatricule(String matricule) {
        this.matricule = matricule;
    }

    public LocalDate getDateEmbauche() {
        return dateEmbauche;
    }
    public void setDateEmbauche(LocalDate dateEmbauche) throws Exception {
        if(dateEmbauche != null && dateEmbauche.isAfter(LocalDate.now())) {
            throw new Exception("La date d'embauche ne peut être postérieure à la date courante");
        }
        this.dateEmbauche = dateEmbauche;
    }

    public Double getSalaire() {
        return salaire;
    }

    public void setSalaire(Double salaire) {
        this.salaire = salaire;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Employe{");
        sb.append("nom='").append(nom).append('\'');
        sb.append(", prenom='").append(prenom).append('\'');
        sb.append(", matricule='").append(matricule).append('\'');
        sb.append(", dateEmbauche=").append(dateEmbauche);
        sb.append(", salaire=").append(salaire);
        sb.append('}');
        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Employe)) return false;

        Employe employe = (Employe) o;

        if (Double.compare(employe.salaire, salaire) != 0) return false;
        if (!Objects.equals(nom, employe.nom)) return false;
        if (!Objects.equals(prenom, employe.prenom)) return false;
        if (!Objects.equals(matricule, employe.matricule)) return false;
        return Objects.equals(dateEmbauche, employe.dateEmbauche);

    }

    @Override
    public int hashCode() {
        return Objects.hash(nom, prenom, matricule, dateEmbauche, salaire);
    }


}

