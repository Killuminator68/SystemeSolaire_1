package System;

import java.util.ArrayList;
import java.util.List;

public class SystemeSolaire {
    private Etoile etoile;
    private List<Planete> planetes = new ArrayList<>();
    private List<Satellite> satellites = new ArrayList<>();

    public void afficherPositionTerre(int jours) {
        Planete terre = null;
        for (Planete planete : planetes) {
            if (planete.getNom().equals("Terre")) {
                terre = planete;
                break;
            }
        }
        if (terre == null) {
            System.out.println("La Terre n'a pas été trouvée dans le système solaire.");
            return;
        }

        double distanceParcourue = 0;
        for (int i = 1; i <= jours; i++) {
            terre.avancerDansLeTemps(1);
            if (i == 200) { // afficher uniquement la position de la Terre le 200ème jour
                Position position = terre.getPosition();
                System.out.println("La Terre est à la position (" + position.getX() + ", " + position.getY() + ")");
            }
            if (i > 1) { // calculer la distance parcourue à partir du deuxième jour
                ArrayList<Position> positionsPrecedentes = terre.getTrajectory(i - 2);
                Position positionActuelle = terre.getPosition();
                distanceParcourue += positionsPrecedentes.get(positionsPrecedentes.size() - 1).distance(positionActuelle);
            }
        }

        System.out.println("Distance parcourue par la Terre en " + jours + " jours : " + distanceParcourue + " km.");
    }

    public void setEtoile(Etoile etoile) {
        this.etoile = etoile;
    }

    public void addPlanete(Planete planete) {
        planetes.add(planete);
    }

    public void addSatellite(Satellite satellite) {
        satellites.add(satellite);
    }

    public CorpsCeleste getCorpsCelesteById(int idOrbiteCorpsCeleste) {
        if (etoile != null && etoile.getId() == idOrbiteCorpsCeleste) {
            return etoile;
        }

        for (Planete planete : planetes) {
            if (planete.getId() == idOrbiteCorpsCeleste) {
                return planete;
            }

            for (Satellite satellite : planete.getSatellites()) {
                if (satellite.getId() == idOrbiteCorpsCeleste) {
                    return satellite;
                }
            }
        }

        return null;
    }
    
    public void simuler(int temps) {
    	
    }

    public void afficherSystemeSolaire() {
        System.out.println("Système solaire :");
        System.out.println("Etoile :");
        System.out.println(etoile);
        System.out.println("Planètes :");
        for (Planete planete : planetes) {
            System.out.println(planete);
            for (Satellite satellite : planete.getSatellites()) {
                System.out.println("\t" + satellite);
            }
        }
    }
}

    