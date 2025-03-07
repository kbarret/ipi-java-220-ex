package com.ipiecoles.java.java220;

import org.joda.time.LocalDate;

import java.util.HashMap;
import java.util.HashSet;

public class Manager  extends Employe{

    private HashSet<Technicien> equipe = new HashSet<>();

    public Manager(String nom, String prenom, String matricule, LocalDate dateEmbauche, Double salaire) {
        super(nom, prenom, matricule, dateEmbauche, salaire);

    }
    public Manager(){

    }

    @Override
    public Double getPrimeAnnuelle() {
        return Entreprise.primeAnnuelleBase() + equipe.size() * Entreprise.PRIME_MANAGER_PAR_TECHNICIEN;
    }

    public void  ajoutTechnicienEquipe(Technicien technicien){
        equipe.add(technicien);
    }

    public void SetSalaire(Double Salaire){
        super.setSalaire(Salaire * Entreprise.INDICE_MANAGER + Salaire * equipe.size()*0.1);
    }

    public HashSet<Technicien> getEquipe() {
        return equipe;
    }

    public void setEquipe(HashSet<Technicien> equipe) {
        this.equipe = equipe;
    }

    public void ajoutTechnicienEquipe(String nom, String prenom, String matricule, LocalDate dateEmbauche,
                                      Double salaire, Integer grade){
        this.ajoutTechnicienEquipe(new Technicien(nom, prenom, matricule, dateEmbauche, salaire, grade));
    }
    @Override
    public void augmenterSalaire(Double pourcentage) throws Exception {
        super.augmenterSalaire(pourcentage);
        this.augmenterSalaireEquipe(pourcentage);
    }

    private void augmenterSalaireEquipe(Double pourcentage) throws Exception {
        for(Technicien technicien : this.equipe){
            technicien.augmenterSalaire(pourcentage);
        }
    }
}
