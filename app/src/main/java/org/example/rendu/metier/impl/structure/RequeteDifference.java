package org.example.rendu.metier.impl.structure;

import org.example.rendu.metier.api.Requete;
import org.example.rendu.metier.api.VisiteurRequete;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class RequeteDifference implements Requete {
    private Requete requeteGauche;
    private Requete requeteDroite;

    public RequeteDifference(Requete requeteGauche, Requete requeteDroite) {
        this.requeteGauche = requeteGauche;
        this.requeteDroite = requeteDroite;
    }

    @Override
    public List<Requete> getSousRequetes() {
        return List.of(requeteGauche, requeteDroite);
    }

    @Override
    public int getProfondeur() {
        return Math.max(requeteGauche.getProfondeur(), requeteDroite.getProfondeur()) + 1;
    }

    @Override
    public Set<Personne> executer() {
        Set<Personne> resultatGauche = requeteGauche.executer();
        Set<Personne> resultatDroite = requeteDroite.executer();
        return resultatGauche.stream()
                .filter(personne -> !resultatDroite.contains(personne))
                .collect(Collectors.toSet());
    }

    @Override
    public void accept(VisiteurRequete visiteur) {
        visiteur.visiter(this);
    }
}
