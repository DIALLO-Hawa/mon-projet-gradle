package org.example.rendu.metier.impl.structure;


public class Personne {
    private String nom;
    private int age;
    private double salaire;

    public Personne(String nom, int age, double salaire) {
        this.nom = nom;
        this.age = age;
        this.salaire = salaire;
    }

    public String getNom() { return nom; }
    public int getAge() { return age; }
    public double getSalaire() { return salaire; }

    @Override
    public String toString() {
        return "(" + nom + ", " + age + ", " + salaire + ")";
    }
}