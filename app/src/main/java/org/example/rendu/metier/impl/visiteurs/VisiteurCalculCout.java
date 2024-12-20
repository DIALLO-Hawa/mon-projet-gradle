package org.example.rendu.metier.impl.visiteurs;

import org.example.rendu.metier.api.Requete;
import org.example.rendu.metier.api.VisiteurRequete;
import org.example.rendu.metier.impl.structure.RequeteEnsemble;
import org.example.rendu.metier.impl.structure.RequeteSelection;
import org.example.rendu.metier.impl.structure.RequeteDifference;
import org.example.rendu.metier.impl.structure.RequeteUnion;

public class VisiteurCalculCout implements VisiteurRequete {
    private int coutTotal = 0;

    public int getCoutTotal() {
        return coutTotal;
    }

    @Override
    public void visiter(RequeteEnsemble requete) {
        coutTotal += 1;
    }

    @Override
    public void visiter(RequeteSelection requete) {
        coutTotal += 2;
    }

    @Override
    public void visiter(RequeteDifference requete) {
        coutTotal += 3;
    }

    @Override
    public void visiter(RequeteUnion requete) {
        coutTotal += requete.getSousRequetes().size();
    }
}
