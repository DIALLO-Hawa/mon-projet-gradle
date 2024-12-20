package org.example.rendu.metier.impl.structure;

import org.example.rendu.metier.api.Requete;
import org.example.rendu.metier.api.VisiteurRequete;

import java.util.List;
import java.util.Set;

public class RequeteEnsemble implements Requete {
    private Set<Personne> personnes;

    public RequeteEnsemble(Set<Personne> personnes) {
        this.personnes = personnes;
    }

    @Override
    public List<Requete> getSousRequetes() {
        return List.of();
    }

    @Override
    public int getProfondeur() {
        return 1;
    }

    @Override
    public Set<Personne> executer() {
        return personnes;
    }

    @Override
    public void accept(VisiteurRequete visiteur) {
        visiteur.visiter(this);
    }
}

