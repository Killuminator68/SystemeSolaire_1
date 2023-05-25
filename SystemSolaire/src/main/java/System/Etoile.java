package System;

public class Etoile extends CorpsCeleste {
    private double temperature; // En Kelvin
    private String composition; // Par exemple : "Hydrogène et Hélium"
    public Etoile(String nom, double taille, double age, double temperature, String composition, double tempsRevolution, int idOrbiteCorpsCeleste, SystemeSolaire systemeSolaire, Position position) {
        super(nom, taille, age, idOrbiteCorpsCeleste, systemeSolaire, position); // Mise à jour de l'appel au constructeur de CorpsCeleste
        this.temperature = temperature;
        this.composition = composition;
    }


    // Getters et setters pour temperature et composition
    
    public int getId() {
        return idOrbiteCorpsCeleste;
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
        return "Étoile:\n" + super.toString() +
               "Température: " + temperature + " K\n" +
               "Composition: " + composition + "\n";
    }

    public int getIdOrbiteCorpsCeleste() {
        return idOrbiteCorpsCeleste;
    }

   
}
