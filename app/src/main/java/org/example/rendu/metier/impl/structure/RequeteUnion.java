package org.example.rendu.metier.impl.structure;

import org.example.rendu.metier.api.Requete;
import org.example.rendu.metier.api.VisiteurRequete;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class RequeteUnion implements Requete {
    private List<Requete> sousRequetes;

    public RequeteUnion(List<Requete> sousRequetes) {
        this.sousRequetes = sousRequetes;
    }

    @Override
    public List<Requete> getSousRequetes() {
        return sousRequetes;
    }

    @Override
    public int getProfondeur() {
        return sousRequetes.stream().mapToInt(Requete::getProfondeur).max().orElse(0) + 1;
    }

    @Override
    public Set<Personne> executer() {
        Set<Personne> result = new HashSet<>();
        for (Requete requete : sousRequetes) {
            result.addAll(requete.executer());
        }
        return result;
    }

    @Override
    public void accept(VisiteurRequete visiteur) {
        visiteur.visiter(this);
    }
}
