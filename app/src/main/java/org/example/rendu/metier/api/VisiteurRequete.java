package org.example.rendu.metier.api;
import org.example.rendu.metier.impl.structure.RequeteDifference;
import org.example.rendu.metier.impl.structure.RequeteEnsemble;
import org.example.rendu.metier.impl.structure.RequeteSelection;
import org.example.rendu.metier.impl.structure.RequeteUnion;

public interface VisiteurRequete {
    void visiter(RequeteEnsemble requete);
    void visiter(RequeteSelection requete);
    void visiter(RequeteDifference requete);
    void visiter(RequeteUnion requete);
}
