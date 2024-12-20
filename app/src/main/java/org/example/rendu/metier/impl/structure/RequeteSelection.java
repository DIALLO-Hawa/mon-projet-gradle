package org.example.rendu.metier.impl.structure;

import org.example.rendu.metier.api.Requete;
import org.example.rendu.metier.api.VisiteurRequete;

import java.util.List;
import java.util.Set;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class RequeteSelection implements Requete {
    private Requete sousRequete;
    private Predicate<Personne> filtre;

    public RequeteSelection(Requete sousRequete, Predicate<Personne> filtre) {
        this.sousRequete = sousRequete;
        this.filtre = filtre;
    }

    @Override
    public List<Requete> getSousRequetes() {
        return List.of(sousRequete);
    }

    @Override
    public int getProfondeur() {
        return sousRequete.getProfondeur() + 1;
    }

    @Override
    public Set<Personne> executer() {
        return sousRequete.executer().stream().filter(filtre).collect(Collectors.toSet());
    }

    @Override
    public void accept(VisiteurRequete visiteur) {
        visiteur.visiter(this);
    }
}
