package org.example.rendu.client;

import org.example.rendu.metier.impl.structure.Personne;
import org.example.rendu.metier.impl.structure.RequeteEnsemble;
import org.example.rendu.metier.impl.structure.RequeteSelection;
import org.example.rendu.metier.impl.structure.RequeteUnion;
import org.example.rendu.metier.impl.visiteurs.VisiteurCalculCout;

import java.util.List;
import java.util.Set;

public class App {
    public static void main(String[] args) {
        Set<Personne> personnes = Set.of(
                new Personne("alice", 20, 2000),
                new Personne("bob", 17, 100),
                new Personne("charles", 17, 2600),
                new Personne("david", 70, 1000),
                new Personne("elisabeth", 72, 900)
        );

        RequeteEnsemble ensemble = new RequeteEnsemble(personnes);
        RequeteSelection mineurs = new RequeteSelection(ensemble, p -> p.getAge() < 18);
        RequeteSelection retraites = new RequeteSelection(ensemble, p -> p.getAge() > 64);
        RequeteUnion outliers = new RequeteUnion(List.of(mineurs, retraites));

        System.out.println("Resultat : " + outliers.executer());
    }
}
