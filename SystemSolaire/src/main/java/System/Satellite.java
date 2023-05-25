package System;


public class Satellite extends CorpsCeleste {
    private double tempsRevolution; // En jours terrestres
    private double temperature; // En Kelvin
    private String composition; // Par exemple : "Roches ignées et poussière"
    private SystemeSolaire systemeSolaire;

    public Satellite(String nom, double taille, double tempsRevolution, double age, double temperature, String composition, int idOrbiteCorpsCeleste, SystemeSolaire systemeSolaire, Position position) {
        super(nom, taille, age, idOrbiteCorpsCeleste, systemeSolaire, position); // Mise à jour de l'appel au constructeur de CorpsCeleste
        this.tempsRevolution = tempsRevolution;
        this.temperature = temperature;
        this.composition = composition;
        this.systemeSolaire = systemeSolaire;
        this.position = position;
    }


    public int getId() {
        return idOrbiteCorpsCeleste;
    }

    public double getTempsRevolution() {
        return tempsRevolution;
    }

    public void setTempsRevolution(double tempsRevolution) {
        this.tempsRevolution = tempsRevolution;
    }

    public double getTemperature() {
        return temperature;
    }

    public void setTemperature(double temperature) {
        this.temperature = temperature;
    }

    public String getComposition() {
        return composition;
    }

    public void setComposition(String composition) {
        this.composition = composition;
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
        return "Satellite:\n" + super.toString() +
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

	
}
