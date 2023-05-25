package System;

import java.util.ArrayList;




public class Planete extends CorpsCeleste {
    private double tempsRevolution; // En jours terrestres
    private double temperature; // En Kelvin
    private String composition; // Par exemple : "Silicate et fer"
    private ArrayList<Satellite> satellites = new ArrayList<Satellite>();

    public Planete(String nom, double taille, double tempsRevolution, double age, double temperature, String composition, int idOrbiteCorpsCeleste, SystemeSolaire systemeSolaire, Position position) {
        super(nom, taille, age, idOrbiteCorpsCeleste, systemeSolaire, position); // Mise à jour de l'appel au constructeur de CorpsCeleste
        this.tempsRevolution = tempsRevolution;
        this.temperature = temperature;
        this.composition = composition;
    }
    
    
    public ArrayList<Position> getTrajectory(int nbJours) {
    	ArrayList<Position> trajectoire = new ArrayList<>();
        trajectoire.add(position); // Ajouter la position initiale à la trajectoire
        for (int i = 0; i < nbJours; i++) {
            avancerDansLeTemps(1); // Mettre à jour la position de la planète pour le jour suivant
            trajectoire.add(position); // Ajouter la nouvelle position à la trajectoire
        }
        return trajectoire;
    }



    public int getId() {
        return idOrbiteCorpsCeleste;
    }
    
  
    
    
    @Override
    public String toString() {
        String orbiteAutourDe = "Inconnu";
        if (getIdOrbiteCorpsCeleste() != 0) {
            CorpsCeleste corpsCeleste = systemeSolaire.getCorpsCelesteById(getIdOrbiteCorpsCeleste());
            if (corpsCeleste != null) {
                orbiteAutourDe = corpsCeleste.getNom();
            }
        }
        return "Planète:\n" + super.toString() +
               "Temps de révolution: " + tempsRevolution + " jours\n" +
               "Température: " + temperature + " K\n" +
               "Composition: " + composition + "\n" +
               "Orbite autour de: " + orbiteAutourDe + "\n";
    }

    public void avancerDansLeTemps(double joursEcoulés) {
        double angle = 2 * Math.PI * joursEcoulés / tempsRevolution;
        double x = position.getX() * Math.cos(angle) - position.getY() * Math.sin(angle);
        double y = position.getX() * Math.sin(angle) + position.getY() * Math.cos(angle);
        position.setX(x);
        position.setY(y);
    }
    
   

    
    public void addSatellite(Satellite satellite) {
        satellites.add(satellite);
    }

    public ArrayList<Satellite> getSatellites() {
        return satellites;
    }

    public int getIdOrbiteCorpsCeleste() {
        return idOrbiteCorpsCeleste;
    }
    
}
