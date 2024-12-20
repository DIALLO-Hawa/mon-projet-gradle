package org.example.rendu.metier.api;

import org.example.rendu.metier.impl.structure.Personne;

import java.util.List;
import java.util.Set;

public interface Requete {
    List<Requete> getSousRequetes();
    int getProfondeur();
    Set<Personne> executer();
    void accept(VisiteurRequete visiteur);
}
