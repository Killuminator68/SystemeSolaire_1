package System;

import java.io.IOException;


public class Main {
    public static void main(String[] args) throws IOException {
        SystemeSolaire systemeSolaire = new SystemeSolaire();

        /*Position positionSoleil = new Position(0, 0); // Ajoutez cette ligne pour créer un objet Position pour le Soleil
        Etoile soleil = new Etoile("Soleil", 1392000, 4.6, 5778, "Hydrogène et Hélium", 0, 1, systemeSolaire, positionSoleil); // Ajoutez positionSoleil comme paramètre
        systemeSolaire.setEtoile(soleil);

        
        Planete terre = new Planete("Terre", 12742, 365.2, 4.54, 288, "Silicate et fer", 1, systemeSolaire, new Position(1.0, 0.0));
        systemeSolaire.addPlanete(terre);

        Planete mars = new Planete("Mars", 6779, 687, 4.6, 210, "Fer, nickel et soufre", 2, systemeSolaire, positionSoleil);
        systemeSolaire.addPlanete(mars);

        Planete jupiter = new Planete("Jupiter", 139820, 4333, 4.5, 165, "Hydrogène et hélium", 3, systemeSolaire, positionSoleil);
        systemeSolaire.addPlanete(jupiter);

        Planete venus = new Planete("Venus", 12104, 225, 4.5, 737, "Roches silicatées et métalliques", 4, systemeSolaire, positionSoleil);
        systemeSolaire.addPlanete(venus);

        Planete uranus = new Planete("Uranus", 50724, 30687, 4.5, 76, "Hydrogène et hélium", 5, systemeSolaire, positionSoleil);
        systemeSolaire.addPlanete(uranus);

        Planete pluton = new Planete("Pluton", 2370, 90560, 4.5, 44, "Roches et glace d'azote", 6, systemeSolaire, positionSoleil);
        systemeSolaire.addPlanete(pluton);

        Satellite lune = new Satellite("Lune", 3475, 27.3, 4.53, 220, "Roches ignées et poussière", 1, systemeSolaire, positionSoleil);
        terre.addSatellite(lune);
        
        Scanner scanner = new Scanner(System.in);
        System.out.print("Entrez le nombre de jours écoulés : ");
        int joursEcoulés = scanner.nextInt();
        
        scanner.close();
        
     
        terre.avancerDansLeTemps(joursEcoulés);
        Position positionTerre = terre.getPosition();
        Position positionInitiale = terre.getPosition();
        System.out.println("Position initiale : (" + positionInitiale.getX() + ", " + positionInitiale.getY() + ")");
        terre.avancerDansLeTemps(1);
        Position positionFinale = terre.getPosition();
        
        systemeSolaire.afficherPositionTerre(joursEcoulés);
        System.out.println("Position finale : (" + positionFinale.getX() + ", " + positionFinale.getY() + ")");
        System.out.println("La Terre est à la position (" + positionTerre.getX() + ", " + positionTerre.getY() + ")");  
        
     // Affiche les informations du système solaire
        System.out.println(systemeSolaire.toString());
    */
   
        Planete terre = (Planete) FCorpsCeleste.crerCoprsCeleste(ETypeCorpsCeleste.PLANETE, Outils.jsonFileToJsonObject("terre.json"), systemeSolaire);
        
        terre.avancerDansLeTemps(50);
        
        Satellite lune = (Satellite) FCorpsCeleste.crerCoprsCeleste(ETypeCorpsCeleste.SATELLITE, Outils.jsonFileToJsonObject("satellite.json"), systemeSolaire);

        lune.avancerDansLeTemps(50);
        
        Etoile soleil = (Etoile) FCorpsCeleste.crerCoprsCeleste(ETypeCorpsCeleste.ETOILE, Outils.jsonFileToJsonObject("soleil.json"), systemeSolaire);
        
        
    // Affichez les positions des corps célestes après une semaine
    systemeSolaire.afficherSystemeSolaire();
    }}

